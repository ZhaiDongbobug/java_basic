package basicExample2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class copyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File srcFile = new File("d:\\student");
		File destFile = new File("d:\\teacher");
		copyFile(srcFile,destFile);
	}

	private static void copyFile(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		char[] store = new char[(int) srcFile.length()];
		try(FileReader fr = new FileReader(srcFile);
			PrintWriter pw = new PrintWriter(destFile);
				){
			fr.read(store);
			pw.write(store);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
