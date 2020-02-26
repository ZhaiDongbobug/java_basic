package basicExample2;

import java.io.File;

public class fileExample1 {

	public static void listFiles(File f) {
		if(f.isFile()) {
			System.out.println("文件为："+ f.getAbsolutePath());
		}
		if(f.isDirectory()) {
			File[] fs= f.listFiles();
			if(null != fs) {
				for(File F : fs) {
					listFiles(F);
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\windows");
		listFiles(f);
	}
}
