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

import java.io.InputStream;

/**
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public class MessageParser {
	/**
	 * 　一直搞不清楚整形变量与字节数组的转换，看过各位网友的解释，现写下此随笔： •整形变量转换成字节数组　　
	 * 
	 * 　　　　对于int类型变量a,将其转换为字节数组b，方法如下：　　　　　　
	 * 
	 * 
	 * int a = 100;
	 * 
	 * byte[] b = byte[4];
	 * 
	 * 
	 * 
	 * b[3] = (byte)(a & 0xff);
	 * 
	 * b[2] = (byte)(a>>8 & 0xff);
	 * 
	 * b[1] = (byte)(a>>16 & 0xff);
	 * 
	 * b[0] = (byte)(a>>24 & 0xff);
	 * 
	 * •字节数组转换成整形变量
	 * 
	 * 　　　　将刚才得到的字节数组b转换成整形变量a，
	 * 
	 * int a = 0; for(int i =0; i< b.length; i++){ a += (b[i]&0xff) << (24-8*i);
	 * } return a;
	 * 
	 * @param in
	 */
	public void parser(InputStream in) {

	}

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
