package swing;

import java.io.DataInputStream;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import javax.swing.JFrame;

public class TestGUI {

	public static void main(String[] args) {
		int X = 200;
		int Y = 200;
		JFrame j = new JFrame("LoL");
		read(j,X, Y);
		new ReadThread(j).start();
	}

	private static void read(JFrame j,int X, int Y) {
		File f = new File("d:/location.txt");
		try (FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis);) {
			if(dis.read() != -1) {
				X = dis.readInt();
				Y = dis.readInt();
			}		
			j.setSize(400, 300);
			j.setLocation(X, Y);
			j.setLayout(null);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // 让窗体变得可见
	        j.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
