package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class searchString {

	public static void main(String[] args) {
		File Folder = new File("e://project");
		search(Folder,"Magic");
	}

	private static void search(File folder, String string) {
		if(folder.isFile()) {
			if(folder.getName().toLowerCase().endsWith(".java")) {
				String fileContent = readFileContent(folder);
				if(fileContent.contains(string)) {
					System.out.printf("找到子目标字符串%s,在文件:%s%n",string,folder);
				}
			}
		}
		if (folder.isDirectory()) {
            File[] fs = folder.listFiles();
            for (File f : fs) {
                search(f, string);
            }
        }
		
	}

	private static String readFileContent(File folder) {
		try(FileReader fr = new FileReader(folder);){
			char[] all = new char[(int) folder.length()];
			fr.read(all);
			return new String(all);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
