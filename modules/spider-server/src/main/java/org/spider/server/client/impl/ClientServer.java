/**
 * 
 */
package org.spider.server.client.impl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.UUID;

import org.spider.server.client.SpiderMessageFactory;
import org.spider.server.service.impl.AbstSpiderServerImpl;
import org.spider.server.service.impl.AuthService;
import org.spider.server.service.impl.TCPAcceptServer;
import org.spider.server.service.util.SpiderServerUtil;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

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
	private BufferedOutputStream out;
	ByteArrayInputStream bin;
	// private DataInputStream dataIn;
	// private DataOutputStream dataOut;
	private String userId;
	private TCPAcceptServer tcpAcceptServer;
	private String sessionId;
	String tempCookieId = null;

	public ClientServer(TCPAcceptServer tcpAcceptServer, Socket socket) {
		this.tcpAcceptServer = tcpAcceptServer;
		this.socket = socket;
		try {
			this.in = socket.getInputStream();
			this.out = new BufferedOutputStream(socket.getOutputStream());
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

	public int getSleepTime() {
		return 1;
	}

	@Override
	public Runnable getServerInstance() {
		return this;
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

	public OutputStream getOut() {
		return out;
	}

	protected void execute() throws Exception {
		// 获取登录信息
		SpiderMessage sm = SpiderMessageFactory.getInstance().createSpiderMessage(in);
		int commandType = sm.getCommandType();
		if (null == sessionId || 0x01 == commandType) {
			doLogin(sm);
		} else {
			// 登录成功后进行业务处理
			switch (commandType) {
			// 退出
			case 0xFFFF:
				doLogout();
				break;
			// 令牌
			case 0x02:
				// 获取客户端回复
				int length = in.read();
				byte[] b = new byte[length];
				in.read(b);
				// 生成会话令牌
				if (tempCookieId.equals(new String(b))) {
					sessionId = new String(b);
					// 通知所有人该用户登陆
					// tcpAcceptServer.sendAllClients();
					// 通知该用户相关信息
					// tcpAcceptServer.sendOneClient(this, idb);
				}
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

	}

	protected byte[] readByte(InputStream in) {
		try {

			int total = 0;
			while (total == 0) {
				total = in.available();
			}
			byte[] data = new byte[total];
			in.read(data, 0, total);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 处理客户登录
	 * 
	 * @throws IOException
	 */
	private void doLogin(SpiderMessage spiderMessage) throws IOException {
		String name = null;
		String password = null;
		byte[] bytes = spiderMessage.getData();
		int index = 0;
		int length = 0;
		System.out.println(new String(bytes));
		length = Arrays.copyOfRange(bytes, index, 1)[0];
		index += 1;
		name = new String(Arrays.copyOfRange(bytes, index, length));
		index += length;
		length = Arrays.copyOfRange(bytes, index, index + 1)[0];
		index += 1;
		password = new String(Arrays.copyOfRange(bytes, index, index + length));
		AuthService authService = SpiderServerUtil.getInstance().getServerManager().getServer(AuthService.class);
		if (null != authService && authService.authLogin(name, password)) {
			userId = new String(name);
			// 发送会话令牌
			sessionId = UUID.randomUUID().toString();
			SpiderMessage message = new SpiderMessage();
			message.setSm_type(0x02);
			message.setVersion("1.0");
			message.setCommandType((short) 0x02);
			message.setData(sessionId.getBytes());
			tcpAcceptServer.sendMessage(this, message);
			System.out.println("----用户：" + String.valueOf(name) + "登录成功!");
		}
	}

	/**
	 * 处理用户退出
	 * 
	 * @throws IOException
	 */
	private void doLogout() throws IOException {
		// 退出
		SpiderMessage message = new SpiderMessage();
		message.setSm_type(0xFFFF);
		tcpAcceptServer.sendMessage(this, message);
		tcpAcceptServer.deleClientServer(this);
	}

	/**
	 * 销毁
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
