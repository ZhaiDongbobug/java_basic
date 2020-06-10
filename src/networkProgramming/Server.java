package networkProgramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			dos.writeUTF(str);
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
