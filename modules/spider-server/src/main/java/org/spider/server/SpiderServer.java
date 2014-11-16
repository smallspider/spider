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
package org.spider.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 
 * 服务器
 * 
 * @author yangguangftlp
 * 
 */
public class SpiderServer implements Runnable {

	private ServerSocket ss;
	private int port;
	private boolean stop;
	private boolean suspend;

	public SpiderServer(int port) {
		super();
		this.port = port;
		init();
	}

	private void init() {
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		if (null != ss) {

			while (!stop) {
				try {
					while (suspend) {
						Thread.sleep(100);
					}
					ss.accept();
					Thread.sleep(100);
				} catch (IOException e) {
					e.printStackTrace();
					// 日志记录
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
