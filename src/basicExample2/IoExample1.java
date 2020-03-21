package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IoExample1 {
	public static void main() {
		long eachsize = 100 * 1024;
		File srcfile = new File("d:/eclipse.exe");
		splitFile(srcfile,eachsize);
	}
	 public static void splitFile(File f,long l) {
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] b = new byte[];
			b=
			for(int i;i<=f.length()/l;i++) {
				Filename 
				fis.read(b, off, l);
				File fn =new File(null, null);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
