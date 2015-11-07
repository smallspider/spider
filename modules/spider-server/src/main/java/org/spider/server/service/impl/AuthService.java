package org.spider.server.service.impl;

public class AuthService extends AbstSpiderServerImpl {

	public void init() {

	}

	@Override
	public Runnable getServerInstance() {
		return this;
	}

	@Override
	protected void execute() throws Exception {

	}

	public String name() {
		return null;
	}

	public boolean authLogin(String name, String password) {
		System.out.println("name：" + name + "  password:" + password);
		return true;
	}
}
