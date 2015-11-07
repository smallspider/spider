package org.spider.server.service.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.service.interceptor.Interceptor;
import org.spider.server.service.interceptor.SystemInterceptor;
import org.spider.server.service.manage.ListenerManage;

public class ListenerManager extends ListenerManage {

	private List<Interceptor> interceptors = new ArrayList<Interceptor>();
	private SystemInterceptor sysInterceptor;

	public void init() {

	}

	public void stop() {

	}

}
