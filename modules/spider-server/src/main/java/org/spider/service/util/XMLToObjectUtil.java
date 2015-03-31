/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.spider.service.util;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.spider.service.annotation.ElementSign;
import org.w3c.dom.DOMException;

/**
 * 配置文件转换对象
 * 
 * @author yangguangftlp
 * @date 2014年10月27日
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class XMLToObjectUtil {
	public static final String GENERAL_M_PREFIX = "set";
	public static final String BOOL_PREFIX = "is";
	private static XMLToObjectUtil instance;
	private ThreadLocal<Map<Class, Map<String, Method>>> localVar = new ThreadLocal<Map<Class, Map<String, Method>>>();

	private XMLToObjectUtil() {

	}

	/**
	 * 获取实例
	 * 
	 * @param cls
	 *            子类
	 * @return
	 */
	public static XMLToObjectUtil getInstance(Class cls) {
		if (null == instance) {
			synchronized (XMLToObjectUtil.class) {
				if (null == instance) {
					instance = new XMLToObjectUtil();
				}
			}
		}
		return instance;
	}

	/**
	 * 将xml转换Object
	 * 
	 * @param in
	 *            文档对象
	 * @param objClass
	 *            class
	 * @param flag
	 *            方法可见性 true public false all
	 * @return 返回 生成objClass 实例对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws DOMException
	 * @throws ClassNotFoundException
	 */
	public Object transform(InputStream in, Class objClass, boolean flag) {
		if (null == in) {
			throw new IllegalArgumentException("in is null!");
		}
		try {
			return transform(new SAXReader().read(in), objClass, flag);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 将xml转换Object
	 * 
	 * @param doc
	 *            文档对象
	 * @param objClass
	 *            class
	 * @param flag
	 *            是否获取 objClass 继承的所有方法
	 * @return 返回 生成objClass 实例对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws DOMException
	 * @throws ClassNotFoundException
	 */
	public Object transform(Document doc, Class objClass, boolean flag) {
		if (null == doc) {
			throw new IllegalArgumentException("doc is null!");
		}
		if (null == objClass) {
			throw new IllegalArgumentException("objClass is null!");
		}
		try {
			localVar.set(new HashMap<Class, Map<String, Method>>());
			return parseElement(doc.getRootElement(), objClass.newInstance(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 清空数据
			localVar.set(null);
		}
		return null;
	}

	/**
	 * 处理当前节点以及子节点
	 * 
	 * @param element
	 * @param obj
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private Object parseElement(Element element, Object obj, int level) throws ClassNotFoundException,
			IllegalAccessException, InvocationTargetException, InstantiationException {

		if (null != element && null != obj) {
			// 处理当前节点属性
			String nodeName = null;
			if (0 == level || 1 == level) {
				nodeName = separatorName(element.getName());
				// 需要判断当前节点是否和obj关联
				ElementSign ElementSign = obj.getClass().getAnnotation(ElementSign.class);
				if (null != ElementSign && ElementSign.xmlEleName().equalsIgnoreCase(nodeName) || 1 == level) {
					// 处理属性
					doAttributes(element, obj);
				}
			}
			// 处理子节点
			Element childEle = null;
			Method method = null;
			Map<String, Method> methodMap = getXMLElementSignMethods(obj.getClass());
			Map<String, List<Object>> objMap = new HashMap<String, List<Object>>();
			Class targetClass = null;
			// 获取obj所有方法
			for (Iterator<Element> iterator = element.elementIterator(); iterator.hasNext();) {
				childEle = iterator.next();
				nodeName = childEle.getName();
				method = methodMap.get(nodeName);
				// 处理当前节点
				if (null != method) {
					targetClass = method.getAnnotation(ElementSign.class).beanType();
					if (null != targetClass && Modifier.PUBLIC == targetClass.getModifiers()) {
						if (!objMap.containsKey(nodeName)) {
							objMap.put(nodeName, new ArrayList<Object>());
						}
						objMap.get(nodeName).add(parseElement(childEle, targetClass.newInstance(), 1));
					} else {
						// 抱异常
						throw new IllegalArgumentException("方法名称：" + method.getName() + "的参数非法!");
					}
				} else /** 如果对应节点不存在映射,那么可能在起子节点中,这里 跳过当前节点继续子节点 */
				{
					parseElement(childEle, obj, 2);
				}
			}
			// 合并
			// 处理当前
			Entry<String, List<Object>> entry = null;
			Class paramType = null;
			for (Iterator iterator = objMap.entrySet().iterator(); iterator.hasNext();) {
				entry = (Entry<String, List<Object>>) iterator.next();
				method = methodMap.get(entry.getKey());
				paramType = method.getParameterTypes()[0];
				if (paramType.isAssignableFrom(List.class)) {
					methodMap.get(entry.getKey()).invoke(obj, entry.getValue());
				} else if (paramType.isArray()) {
					methodMap.get(entry.getKey()).invoke(
							obj,
							(Object) copyOf(entry.getValue().toArray(), entry.getValue().size(),
									(Class) method.getParameterTypes()[0]));
				} else if (!paramType.isInterface() && !paramType.isAnnotation()) {
					methodMap.get(entry.getKey()).invoke(obj, entry.getValue().get(0));
				}
			}
		}

		return obj;
	}

	/**
	 * 获取方法
	 * 
	 * @param objClass
	 * @return
	 */
	private Map<String, Method> getXMLElementSignMethods(Class objClass) {

		Map<Class, Map<String, Method>> classMap = localVar.get();
		if (null != classMap.get(objClass)) {
			return classMap.get(objClass);
		}
		Method[] methods = objClass.getMethods();
		Map<String, Method> methodMap = new HashMap<String, Method>();
		String name = null;
		Class paramType = null;
		for (int i = 0, length = methods.length; i < length; i++) {
			if (methods[i].getParameterTypes().length == 1) {
				paramType = methods[i].getParameterTypes()[0];
				name = null;
				if (null != methods[i].getAnnotation(ElementSign.class)) {
					name = methods[i].getAnnotation(ElementSign.class).xmlEleName();
				} else if (paramType.isPrimitive() || paramType.isAssignableFrom(String.class)) {
					name = methods[i].getName();
				}
				if (null != name) {
					methodMap.put(name, methods[i]);
				}
			}
		}
		classMap.put(objClass, methodMap);
		return methodMap;

	}

	/**
	 * 通过节点名称构造方法名
	 * 
	 * @param prefix
	 *            get
	 * @param name
	 *            节点名称
	 * @return 返回方法名
	 */
	private String generateMethodName(String prefix, String name) {
		StringBuffer sbuffer = new StringBuffer(separatorName(name));
		// 处理boolean变量
		if (sbuffer.toString().startsWith(BOOL_PREFIX)) {
			sbuffer.delete(0, 2);
		}
		// 处理有些节点属性a:b 去掉a:
		return new StringBuffer(prefix).append(Character.toUpperCase(sbuffer.charAt(0))).append(sbuffer.substring(1))
				.toString();
	}

	/**
	 * 名称分隔处理
	 * 
	 * @param name
	 * @return
	 */
	private String separatorName(String name) {
		return name.substring(name.indexOf(':') + 1);
	}

	/**
	 * 处理属性
	 * 
	 * @param element
	 * @param paramObj
	 * @param temp
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void doAttributes(Element element, Object paramObj) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		// 处理element属性
		Method method = null;
		Attribute attribute = null;
		Map<Class, Map<String, Method>> classMap = localVar.get();
		if (null == classMap.get(paramObj.getClass())) {
			classMap.put(paramObj.getClass(), getXMLElementSignMethods(paramObj.getClass()));
		}
		Map<String, Method> methods = classMap.get(paramObj.getClass());
		for (int i = 0, length = element.attributeCount(); i < length; i++) {
			attribute = element.attribute(i);
			method = methods.get(generateMethodName(GENERAL_M_PREFIX, attribute.getName()));
			if (null != method && method.getParameterTypes().length == 1) {
				setAttributeValue(paramObj, method, attribute.getValue(), method.getParameterTypes()[0]);
			}
		}
	}

	/**
	 * 处理参数值
	 * 
	 * @param pObj
	 * @param method
	 * @param value
	 * @param pType
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected void setAttributeValue(Object pObj, Method method, String value, Class pType)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		if (String.class == pType) {
			method.invoke(pObj, value);
		} else if (boolean.class == pType) {
			method.invoke(pObj, Boolean.valueOf(value));
		} else if (Integer.class == pType) {
			method.invoke(pObj, Integer.valueOf(value));
		} else {
			// 暂不支持的类型
			throw new IllegalArgumentException("不支持的类型是:" + pType);
		}
	}

	/**
	 * 拷贝数组
	 * 
	 * @param original
	 *            原数组
	 * @param newLength
	 *            新的长度
	 * @param newType
	 *            新的类型
	 * @return
	 */
	private <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
		T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength] : (T[]) Array
				.newInstance(newType.getComponentType(), newLength);
		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		return copy;
	}
}
