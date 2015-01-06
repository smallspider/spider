package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.SpiderServer;
import org.spider.server.manage.ServerManager;
import org.spider.server.utils.SpiderServerUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpiderServerManager implements ServerManager,
		ApplicationContextAware {
	private List<SpiderServer> spiderServers = new ArrayList<SpiderServer>();

	public SpiderServerManager(String[] serverClassNames) {
		super();
		if (null != serverClassNames) {
			for (String className : serverClassNames) {
				try {
					spiderServers.add((SpiderServer) Class.forName(className)
							.newInstance());
				} catch (Exception e) {
					e.printStackTrace();
					throw new IllegalArgumentException(e);
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
