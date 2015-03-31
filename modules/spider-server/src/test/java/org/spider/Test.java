package org.spider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class Test {

	class myThread extends Thread {
		Socket clientSocket;
		InputStream in;
		OutputStream out;

		myThread() throws InterruptedException {
			try {
				clientSocket = new Socket(InetAddress.getByName("127.0.0.1"),
						8502);
				out = clientSocket.getOutputStream();
				in = clientSocket.getInputStream();
				System.out.println(InetAddress.getByName("127.0.0.1"));
				ByteOutputStream bout = new ByteOutputStream();
				/*
				 * out.write(0x01); byte[] b1 = "tf123".getBytes(); byte[] b2 =
				 * "tf123".getBytes(); out.write(b1.length); out.write(b1);
				 * out.write(b2.length); out.write(b2); out.flush();
				 */
				bout.write(0x01);
				byte[] b1 = "tf123".getBytes();
				byte[] b2 = "tf123".getBytes();
				bout.write((byte)b1.length);
				bout.write(b1);
				bout.write((byte)b2.length);
				bout.write(b2);
				bout.flush();
				System.out
						.println("------------" + new String(bout.getBytes()));
				out.write(bout.getBytes());
				out.flush();
				byte[] data = new byte[20];
				int l = in.read(data);
				System.out.println("data:" + new String(data));
				if (l != -1)
					System.out.println(new String(data, 0, l));
				Thread.sleep(1000 * 50);
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
			// while (true)
			try {

				// break;
			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		try {
			System.out.println(InetAddress.getLocalHost());
			t.new myThread().start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
