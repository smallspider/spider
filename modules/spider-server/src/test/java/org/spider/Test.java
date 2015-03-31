package org.spider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

	class myThread extends Thread {
		Socket clientSocket;
		InputStream in;
		OutputStream out;

		myThread() {
			try {
				clientSocket = new Socket(InetAddress.getByName("127.0.0.1"),
						8502);
				out = clientSocket.getOutputStream();
				in = clientSocket.getInputStream();
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
			while (true)
				try {
					out.write(0x01);
					//out.write("tf123".getBytes());
					//out.write("tf123".getBytes());
					out.flush();
					Thread.sleep(1000 * 5);
					System.out.println(in.read());
					break;
				} catch (IOException e1) {
					System.out.println("接收文件通过Socket连接文件服务器异常"+e1);
				} catch (InterruptedException e) {
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
