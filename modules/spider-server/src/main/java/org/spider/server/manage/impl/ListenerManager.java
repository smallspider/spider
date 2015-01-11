package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.interceptor.Interceptor;
import org.spider.server.interceptor.SystemInterceptor;
import org.spider.server.manage.ListenerManage;

public class ListenerManager implements ListenerManage {

	private List<Interceptor> interceptors = new ArrayList<Interceptor>();
	private SystemInterceptor sysInterceptor;

	public void init() {

	}

	public void stop() {

	}

}
