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
package org.spider.client.impl;


/**
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public class SpiderMessage {
	
	/**
	 * 获取头信息
	 * 
	 * @param b
	 */
	private void readHeader(byte[] b) {

	}

	/**
	 * 获取命令
	 * 
	 * @param b
	 */
	private void readSessionKey(byte[] b) {

	}

	/**
	 * 发送者号码 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSenderNum(byte[] b) {
		return null;
	}

	/**
	 * 接受者号码 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readReceiverNum(byte[] b) {
		return null;
	}

	/**
	 * 包序号 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSequenceNum(byte[] b) {
		return null;
	}

	/**
	 * 发送者IP 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSenderIp(byte[] b) {
		return null;
	}

	/**
	 * 发送者端口 2字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSenderPort(byte[] b) {
		return null;
	}

	/**
	 * 消息类型 2字节
	 * 
	 * @param b
	 * @return
	 */
	private String readMessageType(byte[] b) {
		return null;
	}

	/**
	 * 发送者版本类型 2字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSenderVersion(byte[] b) {
		return null;
	}

	/**
	 * 发送时间 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSendTime(byte[] b) {
		return null;
	}

	/**
	 * 发送时间 4字节
	 * 
	 * @param b
	 * @return
	 */
	private String readSenderImg(byte[] b) {
		return null;
	}

	/**
	 * 获取字体 1字节 有一般是0x00000001
	 * 
	 * @param b
	 * @return
	 */
	private String readHasFontProperty(byte[] b) {
		return null;
	}

	/**
	 * 消息的分片数 1字节
	 * 
	 * @param b
	 * @return
	 */
	private String readMessageSliceNum(byte[] b) {
		return null;
	}

	/**
	 * 消息Id 2字节
	 * 
	 * @param b
	 * @return
	 */
	private String readMessageId(byte[] b) {
		return null;
	}

	/**
	 * 消息回复类型 2字节
	 * 
	 * @param b
	 * @return
	 */
	private String readMessageResponsesType(byte[] b) {
		return null;
	}

	/**
	 * 消息正文 消息正文
	 * 
	 * @param b
	 * @return
	 */
	private String readMessageBody(byte[] b) {
		return null;
	}

	/**
	 * 字体属性
	 * 
	 * @param b
	 * @return
	 */
	private String readFontProperty(byte[] b) {
		return null;
	}
}
