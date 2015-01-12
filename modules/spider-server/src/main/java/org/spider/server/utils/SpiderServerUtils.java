package org.spider.server.utils;

import org.spider.server.manage.impl.SpiderServerManager;
import org.spider.server.model.DataPacketQueue;
import org.springframework.context.ApplicationContext;

public class SpiderServerUtils {
	private static SpiderServerUtils instance;
	private ApplicationContext applicationContext;
	private SpiderServerManager serverManager;

	private SpiderServerUtils() {
		super();
	}

	public static SpiderServerUtils getInstance() {
		if (null == instance) {
			synchronized (DataPacketQueue.class) {
				if (null == instance) {
					instance = new SpiderServerUtils();
				}
			}
		}
		return instance;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public SpiderServerManager getServerManager() {
		return serverManager;
	}

	public void setServerManager(SpiderServerManager serverManager) {
		this.serverManager = serverManager;
	}

	public DataPacketQueue getDataPacketQueue() {
		return DataPacketQueue.getInstance();
	}

}
