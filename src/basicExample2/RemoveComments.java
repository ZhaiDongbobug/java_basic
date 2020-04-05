package basicExample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RemoveComments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("d:/LOLFolder/LOL.exe");
		removeComments(f);
	}

	public static void removeComments(File javaFile) {
		// TODO Auto-generated method stub
		try(
				FileReader fr = new FileReader(javaFile);
				BufferedReader br = new BufferedReader(fr);
	    	)
		{
			while (true) {
				String line = br.readLine();
				if (null == line)
					break;
				int index = line.indexOf("//");
				if(index > 0) {
					String newStr = line.substring(0, index);
				}
				String[] strA = new 
				
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
