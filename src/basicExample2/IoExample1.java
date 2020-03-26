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
		int eachSize = 100 * 1024;
		File srcFile = new File("d:/eclipse.exe");
		splitFile(srcFile,eachSize);
	}
	 private static void splitFile(File srcFile,int eachSize) {
		 if(0 == srcFile.length()) {
			 throw new RuntimeException("此文件无法分割！");
		 }
		 byte[] fileContent = new byte[(int) srcFile.length()];
		 FileInputStream fis;
		 try {	
			fis = new FileInputStream(srcFile);
			fis.read(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null == fis)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		int fileNumber;
		
		if(srcFile.length() % eachSize == 0) {
			fileNumber = (int) (fileContent.length/eachSize);
		}else {
			fileNumber = (int) (fileContent.length/eachSize)+1;
		}
		for(int i = 0;i<fileNumber;i++) {
			String eachFileName = srcFile.getName() + "-" + i;
			File eachFile = new File(srcFile.getParent(),eachFileName);
			byte[] eachContent;
			
			if(i != fileNumber - 1) {
				eachContent = Arrays.
						copyOfRange(fileContent, eachSize*i, eachSize*(i+1));
			}else {
				eachContent = Arrays.
						copyOfRange(fileContent, eachSize*i, fileContent.length);
			}
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(eachFile);
				fos.write(eachContent);			
				System.out.printf("输出子文件%s，其大小是 %d字节%n", 
						eachFile.getAbsoluteFile(), eachFile.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(null == fos)
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	 }
}
