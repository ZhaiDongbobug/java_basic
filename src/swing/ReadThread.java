package swing;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

public class ReadThread extends Thread {

	JFrame j;

	public ReadThread(JFrame j) {
		this.j = j;
	}

	public void run() {
		while (true) {
			File f = new File("d:/location.txt");
			try (FileOutputStream fos = new FileOutputStream(f); DataOutputStream dos = new DataOutputStream(fos);) {
				dos.writeInt(j.getX());
				dos.writeInt(j.getY());
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
