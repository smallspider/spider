package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spider.server.interceptor.Interceptor;
import org.spider.server.manage.InterceptorManage;

public class InterceptorManager implements InterceptorManage {

	List<Interceptor> interceptors = new ArrayList<Interceptor>();
	Map<String, Interceptor> interceptorMap = new HashMap<String, Interceptor>();

	public void init() {

	}

	public void stop() {

	}

	public Interceptor get(String key) {
		return interceptorMap.get(key);
	}
}
