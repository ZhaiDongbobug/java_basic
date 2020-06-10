package networkProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("127.0.0.1", 8888);
			InputStream is = s.getInputStream();	 
	        //把输入流封装在DataInputStream
	        DataInputStream dis = new DataInputStream(is);
	        String msg = dis.readUTF();
	        System.out.println("收到服务端信息：" + msg);
	        dis.close();
	        s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
