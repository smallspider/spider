/**
 * Copyright 2014 smallspider ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.spider.server.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.spider.server.client.impl.ClientServer;
import org.spider.server.client.impl.SpiderMessage;
import org.spider.server.service.constant.SpiderConstants;

/**
 * 处理接收客户端
 * 
 * @author yangguangftlp
 * 
 */
public class TCPAcceptServer extends AbstSpiderServerImpl {

	private List<ClientServer> clientServers = Collections.synchronizedList(new ArrayList<ClientServer>());

	public void acceptSocket(Socket socket) {
		init();
		ClientServer cs = new ClientServer(this, socket);
		//clientServers.add(cs);
		cs.start();
		System.out.println(socket.getInetAddress() + ",连接成功!");
	}

	public void init() {
	}

	public void execute() {
		ClientServer cs = null;
		Iterator<ClientServer> iterator = new ArrayList<ClientServer>(clientServers).iterator();
		while (iterator.hasNext()) {
			// 遍历拦截器
			cs = iterator.next();
			if (SpiderConstants.SERVER_STOP == cs.status) {
				cs.destroy();
				clientServers.remove(cs);
			} 
		}
	}

	public void sendAllClients(String str) {
		ClientServer cs = null;
		Iterator<ClientServer> iterator = new ArrayList<ClientServer>(
				clientServers).iterator();
		while (iterator.hasNext()) {
			// 遍历拦截器
			cs = iterator.next();
			if (SpiderConstants.SERVER_RUN == cs.status) {
				PrintWriter pw = new PrintWriter(cs.getOut());
				pw.println(str);
				pw.flush();
			}
		}
		System.out.println(str);
	}

	public String name() {
		return null;
	}

	@Override
	public Runnable getServerInstance() {
		return this;
	}

	/**
	 * @param socket
	 * @param clientServer
	 */
	public void deleClientServer(ClientServer clientServer) {
		ClientServer cs = null;
		Iterator<ClientServer> iterator = new ArrayList<ClientServer>(
				clientServers).iterator();
		while (iterator.hasNext()) {
			// 遍历拦截器
			cs = iterator.next();
			if (SpiderConstants.SERVER_RUN == cs.status && cs == clientServer) {
				clientServer.stop();
			}
		}
	}

	/**
	 * 给所有客户端发送消息
	 * 
	 * @param b
	 */
	public void sendAllClients(byte[] b) {
		System.out.println(new String(b));
		ClientServer cs = null;
		Iterator<ClientServer> iterator = new ArrayList<ClientServer>(
				clientServers).iterator();
		while (iterator.hasNext()) {
			// 遍历拦截器
			cs = iterator.next();
			if (SpiderConstants.SERVER_RUN == cs.status) {
				try {
					cs.getOut().write(b);
					cs.getOut().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sendMessage(ClientServer cs, SpiderMessage message) {
		if (SpiderConstants.SERVER_RUN == cs.status) {
			try {
				cs.getOut().write(message.getSm_type());
				cs.getOut().write(message.getData());
				cs.getOut().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
