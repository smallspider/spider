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

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.spider.server.data.model.DataPacket;
import org.spider.server.service.util.DataPacketUtil;

/**
 * @author yangguangftlp
 * 
 */
public class UDPServer extends AbstSpiderServerImpl {

	DatagramSocket datagramSocket;

	public void init() {
		if (null != datagramSocket) {
			try {
				datagramSocket = new DatagramSocket(8008,
						InetAddress.getLocalHost());
			} catch (Exception e) {
				this.isStop = true;
				e.printStackTrace();
			}
		}

	}

	public void execute() throws Exception {
		DataPacket dataPacket = DataPacketUtil.getInstance().get();
		datagramSocket.send(new DatagramPacket(dataPacket.getData(), dataPacket
				.getOffset(), dataPacket.getLength(), new InetSocketAddress(
				dataPacket.getAddress(), dataPacket.getPort())));

	}

	public int status() {
		return this.status;
	}

	public String name() {
		return this.getClass().getSimpleName();
	}

	@Override
	public Runnable getServerInstance() {
		return this;
	}

	public void run() {
		// TODO Auto-generated method stub

	}

}
