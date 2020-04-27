package numberAndString;

import java.util.ArrayList;

public class bruForceCode {
	public static void main(String[] args) {
		String password = randomString(3);
		System.out.println("密码是：" + password);
		char[] guessPassword = new char[3];
		outloop:
			for(short i='0';i<='z';i++) {
				for(short j='0';j<='z';j++) {
					for(short k='0';k<='z';k++) {
						if(!isLetterOrDigital(i,j,k))
							continue;
						guessPassword[0] = (char)i;
						guessPassword[1] = (char)j;
						guessPassword[2] = (char)k;
						String guess = new String(guessPassword);
						if(guess.equals(password)) {
							System.out.println("找到了，密码是：" + guess);
							break outloop;
					}
				}
			}
		}
	}
	private static boolean isLetterOrDigital(short i, short j, short k) {
		if(Character.isLetterOrDigit(i)
				&&Character.isLetterOrDigit(j)
				&&Character.isLetterOrDigit(k))
		return true;
		return false;
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
