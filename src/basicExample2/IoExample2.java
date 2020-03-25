package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoExample2 {

	public static void main(String[] args) {
		
		murgeFile("d:/","eclipse.exe");
	}		
	private static void murgeFile(String folder,String fileName) {
		try {
			File destFile = new File(folder,fileName);
			int index=0;
			FileOutputStream fos = new FileOutputStream(destFile);
			while(true) {
	            File eachFile = new File(folder,fileName + "-" + index++);
	            if(!eachFile.exists()) {
	            	break;
	            }
	            byte[] eachContent = new byte[(int) eachFile.length()];
				FileInputStream fis = new FileInputStream(eachFile);
				fis.read(eachContent);				
				fos.write(eachContent);
				fis.close();
				fos.flush();
			}
            fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
    }
}
