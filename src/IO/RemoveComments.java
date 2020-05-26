package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveComments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("d:/LOLFolder/LOL.exe");
		removeComments(f);
	}

	public static void removeComments(File javaFile) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		try(
				FileReader fr = new FileReader(javaFile);
				BufferedReader br = new BufferedReader(fr);
	    	)
		{
			while (true) {
				String line = br.readLine();
				if (null == line)
					break;
				if(!line.trim().startsWith("//")) {
					sb.append(line).append("\r\n");
				} 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(FileWriter fw = new FileWriter(javaFile);
			PrintWriter pw = new PrintWriter(fw);
				){
			pw.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
