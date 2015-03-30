package org.spider.server.impl;

import org.spider.server.SpiderServer;

/**
 * 
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public abstract class AbstSpiderServerImpl implements SpiderServer {

	/** 服务状态 */
	protected int status;
	/** 是否暂停 */
	protected boolean isStop;
	/** 是否继续 */
	protected boolean isSuspend;
	/** 默认时间 */
	protected int threadSleep = 100;
	/** 服务名称 */
	protected String name;

	public void start() {
		if (!this.isStop) {
			Runnable runnable = getServerInstance();
			Thread thread = null;
			if (null != runnable) {
				thread = new Thread(runnable);
				thread.setDaemon(true);
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

	public int status() {
		return this.status;
	}

	public void doContinue() {
		isSuspend = false;
	}

	public void destroy() {
		isStop = true;
	}

	/**
	 * 获取服务实体
	 * 
	 * @return
	 */
	public abstract Runnable getServerInstance();
}
