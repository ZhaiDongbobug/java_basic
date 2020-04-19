package numberAndString;

import java.util.Random;

public class createRandomString {

	public static void main(String[] args) {
		// 方法一
		char[] cs = new char[5];
		short start = '0';
		short end = 'z' + 1;
		for (int i = 0; i < cs.length; i++) {
			while (true) {
				char c = (char) (Math.random() * (end - start) + start);
				if (Character.isDigit(c) || Character.isLetter(c)) {
					cs[i] = c;
					break;
				}
			}
		}
		String result = new String(cs);
		System.out.println(result);
		// 方法二
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
		char[] cs2 = new char[5];

		for (int i = 0; i < cs2.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs2[i] = pool.charAt(index);
		}
		String result2 = new String(cs2);
		System.out.println(result2);
	}

}
