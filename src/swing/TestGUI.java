package swing;

import java.io.DataInputStream;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI {

	public static void main(String[] args) {
		JFrame j = new JFrame("LoL");
		j.setSize(400, 300);
		Point p = read();
		if (p != null) {
			j.setLocation(p.x, p.y);
		} else {
			j.setLocation(200, 200);
		}
		j.setLayout(null);
		JButton b = new JButton("一键秒对方基地挂");

		// 同时设置组件的大小和位置
		b.setBounds(50, 50, 280, 30);

		// 把按钮加入到主窗体中
		j.add(b);

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		new ReadThread(j).start();
	}

	static class Point {
		int x;
		int y;
	}

	private static Point read() {
		File f = new File("d:/location.txt");
		Point p = null;
		try (FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis);) {
			int x = dis.readInt();
			int y = dis.readInt();
			p = new Point();
			p.x = x;
			p.y = y;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
