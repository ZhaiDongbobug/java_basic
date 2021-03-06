package networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			
			InputStream is = s.getInputStream();	 
	        DataInputStream dis = new DataInputStream(is);
	        OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			while(true) {
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				dos.writeUTF(str);
				String msg = dis.readUTF();
		        System.out.println(msg);
		        System.out.println();
			}
	        
	        //dis.close();
	        //s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
