package org.spider.server.util;

import org.spider.server.manage.impl.SpiderServerManager;
import org.springframework.context.ApplicationContext;

public class SpiderServerUtil {
	private static SpiderServerUtil instance;
	private ApplicationContext applicationContext;
	private SpiderServerManager serverManager;

	private SpiderServerUtil() {
		super();
	}

	public static SpiderServerUtil getInstance() {
		if (null == instance) {
			synchronized (DataPacketUtil.class) {
				if (null == instance) {
					instance = new SpiderServerUtil();
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

	public DataPacketUtil getDataPacketQueue() {
		return DataPacketUtil.getInstance();
	}

}
