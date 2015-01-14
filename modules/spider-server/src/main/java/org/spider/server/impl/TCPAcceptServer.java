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

	private List<ClientServer> clientSockets = Collections
			.synchronizedList(new ArrayList<ClientServer>());

	public void acceptSocket(Socket socket) {
		init();
		clientSockets.add(new ClientServer(socket));
	}

	public void init() {
	}

	public void run() {
		while (!isStop) {
			while (!isSuspend) {
				Iterator<ClientServer> iterator = new ArrayList<ClientServer>(clientSockets)
						.iterator();
				while (iterator.hasNext()) {
					// 遍历拦截器
				}
			}
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
