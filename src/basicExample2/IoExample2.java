package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoExample2 {

	public static void main(String[] args) {
		File srcFile = new File("d:/eclipse.exe");
		int i=0;
		while(i<5) {
            String eachFileName = srcFile.getName() + "-" + i;
            i++;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] fileContent = new byte[(int) srcFile.length()]; 
            byte[] eachContent = new byte[(int) eachFile.length()];
			try {
				FileInputStream fis = new FileInputStream(srcFile);
				fis.read(eachContent);
				fis.close();
				FileOutputStream fos = new FileOutputStream(eachFile);
				fos.write(fileContent);
	            fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
        }
	}

}
