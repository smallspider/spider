package org.spider.server.service.impl;

public class AuthService extends AbstSpiderServerImpl {

	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public Runnable getServerInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void execute() throws Exception {
		// TODO Auto-generated method stub

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
		System.out.println("name：" + new String(userId) + "  password:"
				+ new String(userPassword));
		return true;
	}
}
