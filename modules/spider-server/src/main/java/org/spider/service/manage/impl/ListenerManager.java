package org.spider.service.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.spider.service.interceptor.Interceptor;
import org.spider.service.interceptor.SystemInterceptor;
import org.spider.service.manage.ListenerManage;

public class ListenerManager extends ListenerManage {

	private List<Interceptor> interceptors = new ArrayList<Interceptor>();
	private SystemInterceptor sysInterceptor;

	public void init() {

	}

	public void stop() {

	}

}
