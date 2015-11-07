/**
 * 
 */
package org.spider.base.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangguangftlp
 * 
 *         2015年1月7日
 */
@SuppressWarnings("rawtypes")
public class SpiderClassLoader extends ClassLoader {
	private static SpiderClassLoader instance;
    public SpiderClassLoader() {
		super();
	}
	public static SpiderClassLoader getInstance() {
		if (null == instance) {
			synchronized (SpiderClassLoader.class) {
				if (null == instance) {
					instance = new SpiderClassLoader();
				}
			}
		}
		return instance;
	}

	public Object[] newInstance(String[] classNames) {
		if (null != classNames) {
			List<Object> objects = new ArrayList<Object>();
			Object object = null;
			for (String className : classNames) {
				object = newInstance(className);
				if (null != object) {
					objects.add(object);
				}
			}
			return objects.toArray();
		}
		return null;
	}

	public Object newInstance(String className) {
		try {
			if (null != className) {
				return newInstance(Class.forName(className));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object newInstance(Class cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	};
	
	public void loadService(){
		//ServiceLoader.load(service)
	}
}
