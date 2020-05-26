package IO;

import java.io.File;
import java.io.IOException;

public class fileExample {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\windows");
		File[] fs= f.listFiles();
		long minFileValue = Integer.MAX_VALUE;
		long maxFileValue = 0;
		File maxFile = null;
		File minFile = null;
		for(File file : fs)
		{
			if(file.isDirectory())
				continue;
			if(file.length() > maxFileValue)
			{
				maxFileValue = file.length();
				maxFile = file;
			}
			if(file.length() != 0 && file.length() < minFileValue)
			{
				minFileValue = file.length();
				minFile = file;
			}
		}
		System.out.printf("最大的文件是%s,其大小是%d,字节\n",
				maxFile.getAbsoluteFile(),maxFileValue);
		System.out.printf("最小的文件是%s,其大小是%d,字节",
				minFile.getAbsoluteFile(),minFileValue);
		
	}
}
