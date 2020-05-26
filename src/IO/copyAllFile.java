package IO;

import java.io.File;

public class copyAllFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copyFolder("d:\\teacher","d:\\student");
		
	}

	private static void copyFolder(String srcPath, String destPath) {
		// TODO Auto-generated method stub
		File srcFolder = new File(srcPath);
		File destFolder = new File(destPath);
		if(!srcFolder.exists())
			return;
		if(!srcFolder.isDirectory())
			return;
		if(!destFolder.isFile())
			return;
		if(!destFolder.exists())
			destFolder.mkdirs();
		
		File[] files = srcFolder.listFiles();
		for(File srcFile:files) {
			if(srcFile.isFile()) {
				File newDestFolder = new File(destFolder,srcFile.getName());
				copyFile.copyFile(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
			}
			if(srcFile.isDirectory()) {
				File newDestFolder = new File(destFolder,srcFile.getName());
				copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
			}
		}
	}

}
