package org.spider.service.manage.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spider.service.interceptor.Interceptor;
import org.spider.service.manage.InterceptorManage;

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
