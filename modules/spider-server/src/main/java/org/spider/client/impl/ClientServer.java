/**
 * 
 */
package org.spider.client.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

import org.spider.server.impl.AbstSpiderServerImpl;
import org.spider.server.impl.AuthService;
import org.spider.server.impl.TCPAcceptServer;
import org.spider.server.util.SpiderServerUtil;
import org.springframework.core.io.ByteArrayResource;

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
	private DataInputStream dataIn;
	private DataOutputStream dataOut;

	private String userId;
	private TCPAcceptServer tcpAcceptServer;
	private String cookieId;
	String tempCookieId = null;

	public ClientServer(TCPAcceptServer tcpAcceptServer, Socket socket) {
		this.tcpAcceptServer = tcpAcceptServer;
		this.socket = socket;
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();
			this.dataIn = new DataInputStream(in);
			this.dataOut = new DataOutputStream(out);

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
		// 获取登录信息
		int flag = dataIn.readInt();
		switch (flag) {
		// 登录
		case 0x01:
			// 获取用户名密码
			byte[] idb = new byte[4];
			dataIn.read(idb);
			byte[] idp = new byte[4];
			dataIn.read(idp);
			AuthService authService = (AuthService) SpiderServerUtil.getInstance().getServerManager()
					.getServer(AuthService.class);
			if (!authService.authLogin(idb, idp)) {
				userId = new String(idb);
			}
			// 发送会话令牌
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			tempCookieId = UUID.randomUUID().toString();
			byteArrayOut.write(0x11);
			byteArrayOut.write(tempCookieId.length());
			byteArrayOut.write(tempCookieId.getBytes());
			tcpAcceptServer.sendOneClient(this, byteArrayOut.toByteArray());
			break;
		// 令牌
		case 0x02:
			// 获取客户端回复
			int length = in.read();
			byte[] b = new byte[length];
			in.read(b);
			if (tempCookieId.equals(new String(b))) {
				cookieId = new String(b);
				// 通知所有人该用户登陆
				// tcpAcceptServer.sendAllClients();
				// 通知该用户相关信息
				// tcpAcceptServer.sendOneClient(this, idb);
			}
			// 生成会话令牌
			break;
		case 0x03:
			break;
		case 0x04:
			break;
		case 0x05:
			break;
		case 0x06:
			break;
		case 0x07:
			break;
		case 0x08:
			break;
		case 0x09:
			break;
		case 0x010:
			break;
		case 0x011:
			break;
		case 0x012:
			break;
		}
	}

	/**
	 * 
	 */
	public void destroy() {
		super.destroy();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}