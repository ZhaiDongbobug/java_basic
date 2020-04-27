package numberAndString;

public class bruForceCode {
	private static boolean found = false;

	public static void main(String[] args) {
		String password = randomString(3);
		System.out.println("密码是：" + password);
		char[] guessPassword = new char[password.length()];
		generatePassword(guessPassword, password);
	}

	private static void generatePassword(char[] guessPassword, String password) {
		generatePassword(guessPassword, 0, password);

	}

	private static void generatePassword(char[] guessPassword, int index, String password) {
		if (found)
			return;
		for (short i = '0'; i <= 'z'; i++) {
			char c = (char) i;
			if (!Character.isLetterOrDigit(c))
				continue;
			guessPassword[index] = c;
			if (index != guessPassword.length - 1) {
				generatePassword(guessPassword, index + 1, password);
			} else {
				String guess = new String(guessPassword);
				if (guess.equals(password)) {
					found = true;
					System.out.println("找到密码了，密码是：" + guess);
					return;
				}
			}
		}
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
