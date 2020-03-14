package basicExample2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class basicExample2 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		try {
			File f = new File("d:/xyz/abc/def/lol2.txt");
			if(f.getParentFile() == null) {
				//f.getParentFile().mkdir();
				f.getParentFile().mkdirs();
			}
			byte data[] = {88,89};
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
