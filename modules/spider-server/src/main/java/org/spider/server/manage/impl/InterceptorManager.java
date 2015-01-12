package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spider.server.interceptor.Interceptor;
import org.spider.server.manage.InterceptorManage;

public class InterceptorManager extends InterceptorManage {

	List<Interceptor> interceptors = new ArrayList<Interceptor>();
	Map<String, Interceptor> interceptorMap = new HashMap<String, Interceptor>();

	/**
	 * 初始化拦截器
	 */
	public void init() {

	}

	/**
	 * 获取拦截器
	 * 
	 * @param key
	 *            拦截器ID
	 * @return 拦截器
	 */
	public Interceptor get(String key) {
		return interceptorMap.get("command");
	}

	public void stop() {
		// TODO Auto-generated method stub

	}
}
