package multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SearchFileByPoolThread {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		File folder = new File("c://eclipsejee");
		searchFile(folder, "randomString", threadPool);

	}

	private static void searchFile(File folder, String string, ThreadPoolExecutor threadPool) {
		if (folder.isFile()) {
			if (folder.getName().toLowerCase().endsWith(".java")) {
				threadPool.execute(new Runnable() {

					@Override
					public void run() {
						String fileContent = readFileContent(folder);
						if (fileContent.contains(string)) {
							System.out.printf("找到子目标字符串%s,在文件:%s%n", string, folder);
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				});

			}
		}
		if (folder.isDirectory()) {
			File[] fs = folder.listFiles();
			for (File f : fs) {
				searchFile(f, string, threadPool);
			}
		}

	}

	private static String readFileContent(File folder) {
		try (FileReader fr = new FileReader(folder);) {
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
