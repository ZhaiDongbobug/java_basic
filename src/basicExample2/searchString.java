package basicExample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class searchString {

	public static void main(String[] args) {
		search("e://project","Magic");
	}

	private static void search(String folder, String search) {
		File Folder = new File(folder);
		if(!Folder.exists())
			return;
		File[] files = Folder.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				File newFolder = new File(Folder.getAbsolutePath(),file.getName());
				search(newFolder.getAbsolutePath(),search);
			}
			if(file.length() == 0)
				continue;
			if(file.isFile()) {
				File newFile = new File(Folder.getAbsolutePath(),file.getName());
				try(FileReader fr = new FileReader(newFile);
					BufferedReader br = new BufferedReader(fr);	
						){
					String s = null;
					while((s = br.readLine()) != null) {
						if(s.contains(search))
							break;
					}
					br.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
