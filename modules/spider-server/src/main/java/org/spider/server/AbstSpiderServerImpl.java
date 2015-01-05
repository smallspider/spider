package org.spider.server;

public abstract class AbstSpiderServerImpl implements SpiderServer {

	protected int status;
	protected boolean isStop;

	public void start() {
		if (!this.isStop) {
			Runnable runnable = getServerInstance();
			Thread thread = null;
			if (null != runnable) {
				thread = new Thread(runnable);
				//thread.setDaemon(true);
				thread.start();
			}
		}
	}

	/**
	 * 获取服务实体
	 * 
	 * @return
	 */
	public abstract Runnable getServerInstance();
}
