package basicExample2;

import java.io.File;
import java.nio.file.Files;

public class fileExample1 {

	public static void listFiles(File[] fs) {
		for(File F : fs) {
			if(F.isDirectory()) {
				System.out.println("子文件夹："+F.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\windows");
		File[] fs= f.listFiles();
		listFiles(fs);
	}

}
