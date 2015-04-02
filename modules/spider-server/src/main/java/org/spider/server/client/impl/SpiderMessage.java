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
package org.spider.server.client.impl;

import java.io.EOFException;

/**
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public class SpiderMessage {
	/**
	 * 消息类型
	 */
	private int sm_type;
	/**
	 * 命令类型
	 */
	private short commandType;
	/**
	 * 版本
	 */
	private String version;
	/**
	 * 消息内容
	 */
	private byte[] data;

	public int getSm_type() {
		return sm_type;
	}

	public void setSm_type(int sm_type) {
		this.sm_type = sm_type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public short getCommandType() {
		return commandType;
	}

	public void setCommandType(short commandType) throws EOFException {
		this.commandType = commandType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
