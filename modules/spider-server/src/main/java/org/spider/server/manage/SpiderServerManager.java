package org.spider.server.manage;

import java.util.ArrayList;
import java.util.List;

import org.spider.server.SpiderServer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpiderServerManager implements ServerManager,ApplicationContextAware {

	public ApplicationContext applicationContext;

	public List<SpiderServer> spiderServers = new ArrayList<SpiderServer>();

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
		this.applicationContext = arg0;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
