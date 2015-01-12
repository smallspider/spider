package org.spider.server.impl;

import org.spider.server.SpiderServer;

public abstract class AbstSpiderServerImpl implements SpiderServer {

	protected int status;
	protected boolean isStop;
	protected boolean isSuspend;
	/** 默认时间 */
	protected int threadSleep = 100;

	public void start() {
		if (!this.isStop) {
			Runnable runnable = getServerInstance();
			Thread thread = null;
			if (null != runnable) {
				thread = new Thread(runnable);
				// thread.setDaemon(true);
				thread.start();
			}
		}
	}

	public void stop() {
		isStop = true;
	}

	public void suspend() {
		isSuspend = true;
	}

	public void doContinue() {
		isSuspend = false;
	}

	/**
	 * 获取服务实体
	 * 
	 * @return
	 */
	public abstract Runnable getServerInstance();
}
