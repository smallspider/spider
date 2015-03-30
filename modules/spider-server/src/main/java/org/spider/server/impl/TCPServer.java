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
package org.spider.server.impl;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 
 * 服务器
 * 
 * @author yangguangftlp
 * 
 */
public class TCPServer extends AbstSpiderServerImpl {

	private ServerSocket serverSocket;
	private String ip;
	private int port;
	private TCPAcceptServer tcpAcceptServer;

	public TCPServer(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("ip:" + serverSocket.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int status() {
		return 0;
	}

	public String name() {
		return null;
	}

	@Override
	public Runnable getServerInstance() {
		return this;
	}

	public void setTcpAcceptServer(TCPAcceptServer tcpAcceptServer) {
		this.tcpAcceptServer = tcpAcceptServer;
	}

	@Override
	protected void execute() throws Exception {
		if (null != tcpAcceptServer) {
			tcpAcceptServer.acceptSocket(serverSocket.accept());
			System.out.println("连接成功!");
		}
	}
}
