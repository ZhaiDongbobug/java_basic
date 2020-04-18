package numberAndString;

import java.util.Random;

public class createRandomString {

	public static void main(String[] args) {
		char[] ch = new char[5];
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			String numOrChar = random.nextInt(2) == 0 ? "number" : "char";
			if ("char".equals(numOrChar)) {
				String upOrLowCase = random.nextInt(2) == 0 ? "upperCase" : "lowerCase";
				if ("lowerCase".equals(upOrLowCase)) {
					char ranv = (char) (random.nextInt(26) + 97);
					ch[i] = ranv;
				} else {
					char ranc = (char) (random.nextInt(26) + 65);
					ch[i] = ranc;
				}
			} else {
				int ran = random.nextInt(10) + 48;
				ch[i] = (char) ran;
			}

		}
		String str = new String(ch);
		System.out.println(str);
	}

}
