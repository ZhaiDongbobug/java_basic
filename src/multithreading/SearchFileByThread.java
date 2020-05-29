package multithreading;

import java.io.File;

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
				SearchThread find = new SearchThread(f, search);
				find.start();
			}
		}
	}
}
