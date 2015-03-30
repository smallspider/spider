import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Test {

	public static void main(String[] args) {
		try {
			Socket s = new Socket(InetAddress.getByName("localhost"), 8085);
			System.out.println(s.isConnected());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
