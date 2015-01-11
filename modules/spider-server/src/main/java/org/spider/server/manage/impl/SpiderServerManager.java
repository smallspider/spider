package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.SpiderServer;
import org.spider.server.manage.ServerManage;
import org.spider.server.utils.SpiderClassLoaderUtils;
import org.spider.server.utils.SpiderServerUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpiderServerManager implements ServerManage,
		ApplicationContextAware {
	private List<SpiderServer> spiderServers = new ArrayList<SpiderServer>();

	public SpiderServerManager(String[] serverClassNames) {
		super();
		Object[] objects = SpiderClassLoaderUtils.getInstance().newInstance(
				serverClassNames);
		if (null != objects) {
			for (Object object : objects) {
				if (object instanceof SpiderServer) {
					spiderServers.add((SpiderServer) object);
				}
			}
		}
	}

	public List<SpiderServer> getSpiderServers() {
		return spiderServers;
	}

	public void setSpiderServers(List<SpiderServer> spiderServers) {
		if (null != spiderServers && !spiderServers.isEmpty()) {
			for (SpiderServer spiderServer : spiderServers) {
				this.spiderServers.add(spiderServer);
			}
		}
	}

	public void init() {

		for (SpiderServer spiderServer : spiderServers) {
			spiderServer.init();
			spiderServer.start();
		}
	}

	public void stop() {
		for (SpiderServer spiderServer : spiderServers) {
			spiderServer.stop();
		}
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpiderServerUtils.getInstance().setApplicationContext(arg0);
		SpiderServerUtils.getInstance().setServerManager(this);
	}
}
