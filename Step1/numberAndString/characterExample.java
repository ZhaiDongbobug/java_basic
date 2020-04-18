package numberAndString;

import java.util.Scanner;

public class characterExample {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		char[] cs = str.toCharArray();
		for (char ch : cs) {
			if (Character.isDigit(ch) || Character.isUpperCase(ch)) {
				System.out.print(ch);
			}
		}
	}
}
