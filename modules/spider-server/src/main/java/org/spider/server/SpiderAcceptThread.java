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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 处理接收客户端
 * 
 * @author yangguangftlp
 * 
 */
public class SpiderAcceptThread implements Runnable {

	private Socket s;
	private InputStream in;
	private OutputStream out;

	public SpiderAcceptThread(Socket s) {
		super();
		this.s = s;
		init();
	}

	private void init() {
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

		while (true) {

			;
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

}
