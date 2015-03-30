package org.spider;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Test {

	public static void main(String[] args) {
		try {
			Socket	acceptFileSocket = new Socket(InetAddress.getByName("localhost"), 8502);
			System.out.println(acceptFileSocket.isClosed());
			
			Thread.sleep(1000 * 5);
		} catch (IOException e1) {
			System.out.print("接收文件通过Socket连接文件服务器异常");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
