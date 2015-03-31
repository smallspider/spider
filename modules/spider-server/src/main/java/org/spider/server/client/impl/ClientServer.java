/**
 * 
 */
package org.spider.server.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

import org.spider.server.service.impl.AbstSpiderServerImpl;
import org.spider.server.service.impl.AuthService;
import org.spider.server.service.impl.TCPAcceptServer;
import org.spider.server.service.util.SpiderServerUtil;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
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
	private BufferedInputStream in;
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
			this.in = new BufferedInputStream(socket.getInputStream());
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

	
	/*public void run() {
		while (!isStop) {
			try {
				while (!isSuspend) {
					Thread.sleep(getSleepTime());
					execute();
				}
				Thread.sleep(getSleepTime());
			} catch (IOException e) {
				e.printStackTrace();
				// 日志记录
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}*/
	
	protected void execute() throws Exception {
		if (socket.isClosed()) {
			return;
		}
		// 获取登录信息
		byte[] buff = new byte[80000];
		int rc = 0;
		ByteOutputStream swapStream = new ByteOutputStream();
		// bin = new ByteArrayInputStream(swapStream.getBytes());
		if (in.available() <= 0) {
			return;
		}
		//IOUtils.copy(in, swapStream);
		System.out.println("----------------- 等待读取...");
		int flag = in.read(buff, 0, buff.length);
		bin = new ByteArrayInputStream(swapStream.getBytes());
		//bin = new ByteArrayInputStream(buff, 0, flag);
		//System.out.println("----------------- flag:" + flag + " "+ new String(buff, 0, flag));
		 flag = bin.read();
		if (null == sessionId || 0x01 == flag) {
			doLogin(bin);
		} else {
			// 登录成功后进行业务处理
			switch (flag) {
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

	/**
	 * 处理客户登录
	 * 
	 * @throws IOException
	 */
	private void doLogin(InputStream in) throws IOException {
		byte[] bname = null;
		byte[] bpassword = null;
		int flag = -1;
		// 获取用户名长度
		flag = in.read();
		if (-1 != flag) {
			bname = new byte[flag];
			in.read(bname);
		}
		// 读取用户密码
		flag = in.read();
		if (-1 != flag) {
			bpassword = new byte[flag];
			in.read(bpassword);
		}
		AuthService authService = SpiderServerUtil.getInstance()
				.getServerManager().getServer(AuthService.class);
		
		System.out.println("name：" + new String(bname) + "  password:"+ new String(bpassword));
		if (null != authService && authService.authLogin(bname, bpassword)) {
			userId = new String(bname);
			// 发送会话令牌
			sessionId = UUID.randomUUID().toString();
			SpiderMessage message = new SpiderMessage();
			message.setSm_type(0x02);
			message.setData(sessionId.getBytes());
			tcpAcceptServer.sendMessage(this, message);
			System.out.println("----用户：" + String.valueOf(bname) + "登录成功!");
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
