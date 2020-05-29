package multithreading;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileByThread {

	public static void main(String[] args) {
		File file = new File("c:\\eclipsejee");
		searchFileByThread(file, "Magic");

	}

	private static void searchFileByThread(File file, String search) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				searchFileByThread(f, search);
			}
			if (f.isFile() && f.getName().toLowerCase().endsWith(".java")) {
				Thread find = new Thread() {
					public void run() {
						String fileContent = readFileConent(f);
						if (fileContent.contains(search)) {
							System.out.printf("找到子目标字符串%s,在文件:%s%n", search, file);
						}
					}
				};
				find.start();
			}
		}
	}

	private static String readFileConent(File file) {
		try (FileReader fr = new FileReader(file)) {
			char[] all = new char[(int) file.length()];
			fr.read(all);
			return new String(all);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
