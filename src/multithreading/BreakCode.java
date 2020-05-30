package multithreading;

import java.util.List;
import java.util.Vector;

public class BreakCode {

	public static void main(String[] args) {
		String code = randomString(3);

		List<String> list = new Vector<>();
		Thread thread = new Thread() {
			public void run() {
				findCodeList(list, code);
			}
		};
		thread.start();
		Thread printThread = new Thread() {
			public void run() {
				while (true) {
					if (list.size() == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(list.get(0));
					list.remove(0);
				}
			}
		};
		printThread.setDaemon(true);
		printThread.start();
	}

	private static void findCodeList(List<String> list, String code) {
		outer: for (int i = 48; i <= 122; i++) {
			if (isDigitOrLetter(i))
				for (int j = 48; j <= 122; j++) {
					if (isDigitOrLetter(j))
						for (int k = 48; k <= 122; k++) {
							if (isDigitOrLetter(k)) {
								char LetterA = (char) k;
								char LetterB = (char) j;
								char LetterC = (char) i;
								StringBuffer strbf = new StringBuffer();
								strbf.append(LetterA).append(LetterB).append(LetterC);
								String answer = new String(strbf);
								if (answer.equals(code)) {
									System.out.println("穷举法找到密码: " + answer);
									break outer;
								}
								list.add(answer);
							}
						}
				}
		}
	}

	private static Boolean isDigitOrLetter(int i) {
		return (Character.isDigit(i) || Character.isLetter(i));
	}

	private static String randomString(int length) {
		String pool = "";
		for (int i = '0'; i < '9' + 1; i++) {
			pool += (char) i;
		}
		for (int i = 'A'; i < 'Z' + 1; i++) {
			pool += (char) i;
		}
		for (int i = 'a'; i < 'z' + 1; i++) {
			pool += (char) i;
		}
		char[] cs = new char[length];

		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		String result = new String(cs);
		return result;
	}

}
