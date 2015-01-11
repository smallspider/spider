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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 处理接收客户端
 * 
 * @author yangguangftlp
 * 
 */
public class TCPAcceptServer extends AbstSpiderServerImpl {

	private List<Socket> clientSockets = Collections
			.synchronizedList(new ArrayList<Socket>());
	private Socket s;
	private InputStream in;
	private OutputStream out;

	public TCPAcceptServer(Socket s) {
		super();
		this.s = s;
		init();
	}

	public void init() {
		try {
			if (null != s) {
				in = s.getInputStream();
				out = s.getOutputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (!isStop) {
			while (!isSuspend) {
				Iterator<Socket> iterator = new ArrayList<Socket>(clientSockets)
						.iterator();
				while (iterator.hasNext()) {
					//遍历拦截器
				}
			}
		}
	}

	/**
	 * 添加客户端Socket
	 * 
	 * @param socket
	 */
	public void addSocket(Socket socket) {
		clientSockets.add(socket);
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

	public void stop() {
		this.isStop = true;
		
	}

	public void suspend() {
        this.isSuspend = true;		
	}

	public int status() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Runnable getServerInstance() {
		return this;
	}

}
