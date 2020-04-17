package numberAndString;

import java.util.ArrayList;
import java.util.Scanner;

public class characterExample {

	public static void main(String[] args) {
		ArrayList all = new ArrayList();
		Scanner s = new Scanner(System.in);
		String str = s.next();
		char[] cs = str.toCharArray();
		for(char ch:cs) {
			Character ca = ch;
			if(ca.isDigit(ch)||ca.isUpperCase(ch)) {
				all.add(ch);
			}
		}
		String str2 = all.toString();
		System.out.println(str2);

	}

}
