package org.spider.server.impl;

public class AuthService extends AbstSpiderServerImpl {

	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public Runnable getServerInstance() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.spider.server.SpiderServer#name()
	 */
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param idb
	 * @param idp
	 * @return
	 */
	public boolean authLogin(byte[] userId, byte[] userPassword) {
		return true;
	}

	public void run() {
		
	}
}
