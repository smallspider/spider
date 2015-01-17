/**
 * 
 */
package org.spider.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.spider.server.impl.AbstSpiderServerImpl;
import org.spider.server.impl.AuthService;
import org.spider.server.impl.TCPAcceptServer;
import org.spider.server.util.SpiderServerUtil;

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

	private String userId;
	private TCPAcceptServer tcpAcceptServer;

	public ClientServer(TCPAcceptServer tcpAcceptServer, Socket socket) {
		this.tcpAcceptServer = tcpAcceptServer;
		this.socket = socket;
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			this.status = -1;
		}
	}

	/**
	 * 读取内容
	 */
	public void read() {
	}

	/**
	 * 写入内容
	 */
	public void write() {
	}

	public void init() {

	}

	public String name() {
		return this.getClass().getSimpleName();
	}

	public int status() {
		return status;
	}

	public void run() {
		while (!isStop) {
			try {
				while (isSuspend) {
					Thread.sleep(threadSleep);

				}
				Thread.sleep(threadSleep);
			} catch (IOException e) {
				e.printStackTrace();
				// 日志记录
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Runnable getServerInstance() {
		return null;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	@Override
	protected void execute() throws Exception {

		if (userId == null) {

			AuthService authService = (AuthService) SpiderServerUtil.getInstance().getServerManager()
					.getServer(AuthService.class);
			if (!authService.authLogin(userId)) {
				byte[] b = new byte[2];
				in.read(b);
				// Short.parseShort(s)
				// 版本
				// 标示
				// 命令
				// 数据
			}
		}

		else {

		}

	}

	/**
	 * 
	 */
	public void destroy() {
		super.destroy();
		socket.close();
	}

}
