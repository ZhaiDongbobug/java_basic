package basicExample2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class dateStreamExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		write();
		read();
	}

	private static void read() {
		// TODO Auto-generated method stub
		File f = new File("d:/lol.txt");
		try(
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
				){
			int i = dis.readInt();
			int j = dis.readInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void write() {
		// TODO Auto-generated method stub
		File f = new File("d:/lol.txt");
		try(
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
				){
			dos.writeInt(31);
			dos.writeInt(15);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}