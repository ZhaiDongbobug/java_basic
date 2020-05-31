package multithreading;

import java.util.List;

public class PasswordThread extends Thread {

	private boolean found = false;
	private String password;
	private List<String> passwords;

	public PasswordThread(String password, List<String> passwords) {
		this.password = password;
		this.passwords = passwords;
	}

	public void run() {
		char[] guessPassword = new char[password.length()];
		generatePassword(guessPassword, password);
	}

	private void generatePassword(char[] guessPassword, String password2) {
		generatePassword(guessPassword, 0, password);
	}

	private void generatePassword(char[] guessPassword, int index, String password) {
		if (found)
			return;
		for (short i = '0'; i <= 'z'; i++) {
			if (!Character.isLetterOrDigit(i))
				continue;
			char c = (char) i;
			guessPassword[index] = c;
			if (index != guessPassword.length - 1) {
				generatePassword(guessPassword, index + 1, password);
			} else {
				String guess = new String(guessPassword);
				passwords.add(guess);
				if (guess.equals(password)) {
					System.out.println("找到了,密码是" + guess);
					found = true;
					return;
				}
			}
		}
	}

}
