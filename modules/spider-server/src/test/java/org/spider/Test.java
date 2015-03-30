package org.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	class myThread extends Thread {
		Socket clientSocket;

		myThread() {
			try {
				clientSocket = new Socket(InetAddress.getByName("127.0.0.1"), 8502);
			    System.out.println(InetAddress.getByName("127.0.0.1"));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			InputStream in;
			OutputStream out;
			while (true)
				try {
					System.out.println(clientSocket.isClosed());
					out = clientSocket.getOutputStream();
					in = clientSocket.getInputStream();
					out.write("tf123".getBytes());
					out.write("tf123".getBytes());
					out.flush();
					Thread.sleep(1000 * 5);
				} catch (IOException e1) {
					System.out.print("接收文件通过Socket连接文件服务器异常");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		try {
			System.out.println(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.new myThread().start();
	}

}
