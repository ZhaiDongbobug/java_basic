package basicExample2;

import java.io.File;
import java.io.IOException;

public class fileExample {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\windows");
		File[] fs= f.listFiles();
		double fd = fs[fs.length-1].length();
		for(File fi : fs)
		{
			System.out.println(fi);
			double fu = 0;
					
			
		}
		
		
	}
}
