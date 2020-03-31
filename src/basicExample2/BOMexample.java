package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class BOMexample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File f = new File("E:\\project\\j2se\\src\\test.txt");
		try(InputStreamReader isr = new InputStreamReader
				(new FileInputStream(f),Charset.forName("UTF-8"))){
			char[] cs = new char[(int) f.length()];
			isr.read(cs);
			char[] bom = new char[1];
			bom[0]=cs[0];
			String str = new String(bom);
			byte[] bs = str.getBytes("UTF-8");
			for (byte b:bs) {
				int i=b&0x000000ff;
				System.out.println(Integer.toHexString(i));
			}
			
			
		}
	}

}
