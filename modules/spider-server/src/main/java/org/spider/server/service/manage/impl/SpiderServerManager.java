package org.spider.server.service.manage.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.spider.server.service.SpiderServer;
import org.spider.server.service.manage.ServerManage;
import org.spider.server.service.util.SpiderServerUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpiderServerManager extends ServerManage implements ApplicationContextAware {

	private static Log LOGGER = LogFactoryImpl.getLog(SpiderServerManager.class);
	private List<SpiderServer> spiderServers = new ArrayList<SpiderServer>();

	public SpiderServerManager(Object[] servers) {
		super();
		//Object[] objects = SpiderClassLoaderUtil.getInstance().newInstance(serverClassNames);
		LOGGER.debug("the load server :" + Arrays.toString(servers));
		if (null != servers) {
			for (Object server : servers) {
				if (server instanceof SpiderServer) {
					spiderServers.add((SpiderServer) server);
				}
			}
		}
	}

	public List<SpiderServer> getSpiderServers() {
		return spiderServers;
	}

	public SpiderServer getServer(Class<?> cls) {
		for (SpiderServer spiderServer : spiderServers) {
			if (spiderServer.getClass().getSimpleName() == cls.getSimpleName()) {
				return spiderServer;
			}
		}
		return null;
	}

	public void setSpiderServers(List<SpiderServer> spiderServers) {
		if (null != spiderServers && !spiderServers.isEmpty()) {
			for (SpiderServer spiderServer : spiderServers) {
				this.spiderServers.add(spiderServer);
			}
		}
	}

	public void init() {
		// 初始化服务

		for (SpiderServer spiderServer : spiderServers) {
			LOGGER.info("the server " + spiderServer.getClass().getName() + " is init  ");
			spiderServer.init();
			LOGGER.info("the server " + spiderServer.getClass().getName() + " is start");
			spiderServer.start();
		}
	}

	public void stop() {
		for (SpiderServer spiderServer : spiderServers) {
			spiderServer.stop();
		}
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		SpiderServerUtil.getInstance().setApplicationContext(arg0);
		SpiderServerUtil.getInstance().setServerManager(this);
	}
}
