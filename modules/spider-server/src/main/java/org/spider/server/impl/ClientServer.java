/**
 * 
 */
package org.spider.server.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端服务
 * 
 * @author yangguangftlp
 * 
 *         2015年1月14日
 */
public class ClientServer extends AbstSpiderServerImpl {
	private Socket socket;
	private InputStream in;
	private OutputStream out;

	public ClientServer(Socket socket) {
		this.socket = socket;
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			this.status = -1;
		}
	}

	public void init() {

	}

	public String name() {
		return null;
	}

	public int status() {
		return status;
	}

	public void run() {

	}

	@Override
	public Runnable getServerInstance() {
		return null;
	}

}
