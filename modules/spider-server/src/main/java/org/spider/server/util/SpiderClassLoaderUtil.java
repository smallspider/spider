/**
 * 
 */
package org.spider.server.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author yangguangftlp
 * 
 *         2015年1月7日
 */
@SuppressWarnings("rawtypes")
public class SpiderClassLoaderUtil extends ClassLoader {
	private static SpiderClassLoaderUtil instance;

	public SpiderClassLoaderUtil() {
		super();
	}

	public static SpiderClassLoaderUtil getInstance() {
		if (null == instance) {
			synchronized (SpiderClassLoaderUtil.class) {
				if (null == instance) {
					instance = new SpiderClassLoaderUtil();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	
	public void loadService(){
		//ServiceLoader.load(service)
	}
}
