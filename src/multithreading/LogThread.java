package multithreading;

import java.util.List;

public class LogThread extends Thread {

	private List<String> passwords;

	public LogThread(List<String> passwords) {
		this.passwords = passwords;
		this.setDaemon(true);
	}

	public void run() {
		while (true) {
			while (passwords.isEmpty()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String password = passwords.remove(0);
			System.out.println("穷举法本次生成的密码是：" + password);
		}
	}
}
