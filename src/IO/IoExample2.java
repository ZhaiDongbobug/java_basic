package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoExample2 {

	public static void main(String[] args) {
		
		murgeFile("d:/","eclipse.exe");
	}		
	private static void murgeFile(String folder,String fileName) {
		File destFile = new File(folder,fileName);
		try(FileOutputStream fos = new FileOutputStream(destFile)){			
			int index=0;			
			while(true) {
	            File eachFile = new File(folder,fileName + "-" + index++);
	            if(!eachFile.exists()) {
	            	break;
	            }
	            byte[] eachContent = new byte[(int) eachFile.length()];
	            try(FileInputStream fis = new FileInputStream(eachFile);){
	            	fis.read(eachContent);				
					fos.write(eachContent);
					fis.close();
					fos.flush();
	            }		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
    }
}
