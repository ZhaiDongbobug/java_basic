package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class copyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		copyFile("d:\\student","d:\\teacher");
	}

	public static void copyFile(String srcPath, String destPath) {
		// TODO Auto-generated method stub
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		byte[] buffer = new byte[1024]; 
		try(FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);
				){
			
			while(true) {
				int actuallyReaded = fis.read(buffer);
				if(actuallyReaded == -1)
					break;
				fos.write(buffer, 0, actuallyReaded);
				fos.flush();			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
