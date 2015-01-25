package org.spider.server.manage.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.spider.server.SpiderServer;
import org.spider.server.manage.ServerManage;
import org.spider.server.util.SpiderClassLoaderUtil;
import org.spider.server.util.SpiderServerUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpiderServerManager extends ServerManage implements ApplicationContextAware {

	private static Log LOGGER = LogFactoryImpl.getLog(SpiderServerManager.class);
	private List<SpiderServer> spiderServers = new ArrayList<SpiderServer>();

	public SpiderServerManager(String[] serverClassNames) {
		super();
		Object[] objects = SpiderClassLoaderUtil.getInstance().newInstance(serverClassNames);
		LOGGER.debug("the load server :" + Arrays.toString(serverClassNames));
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
			LOGGER.info("the server " + spiderServer.name() + " is init  ");
			spiderServer.init();
			LOGGER.info("the server " + spiderServer.name() + " is start");
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
