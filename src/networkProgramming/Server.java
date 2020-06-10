package networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			 System.out.println("监听在端口号:8888");
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = s.getInputStream();	 
	        DataInputStream dis = new DataInputStream(is);
	        while(true) {
	        	String msg = dis.readUTF();
		        System.out.println("收到客户端信息：" + msg);
				Scanner sc = new Scanner(System.in);
				String str = sc.next();
				dos.writeUTF(str);
	        }       
			//dos.close();
			//s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
