package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class IoExample1 {
	public static void main() {
		long eachsize = 100 * 1024;
		File srcfile = new File("d:/eclipse.exe");
		splitFile(srcfile,eachsize);
	}
	 private static void splitFile(File f,long l) {
		 if(0 == f.length()) {
			 throw new RuntimeException("此文件无法分割！");
		 }
		 byte[] filecontent = new byte[(int) f.length()];
		 try {
			FileInputStream fis = new FileInputStream(f);
			fis.read(filecontent);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int fileNumber;
		
		if(f.length() % l == 0) {
			fileNumber = (int) (f.length()/l);
		}else {
			fileNumber = (int) (f.length()/l)+1;
		}
		for(int i = 0;i<fileNumber;i++) {
			String fileName = "exe-"+ i;
			byte[] eachfile = Arrays.copyOfRange(filecontent, (int) (l*i-1), (int) (l*i));
			File file = new File(f.getParent(),fileName);
			try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(eachfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
		}
		
	 }
}
