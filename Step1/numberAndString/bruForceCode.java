package numberAndString;

import java.util.Arrays;

public class bruForceCode {

	public static void main(String[] args) {
		Boolean flag = false;
		String code = getString(3);
		System.out.println("随机取得的密码串：" + code);
		for (char i = '0'; i < 'z' + 1; i++) {
			if (flag) {
				break;
			}				
			for (char j = '0'; j < 'z' + 1; j++) {
				if (flag) {
					break;
				}
				for (char k = '0'; k < 'z' + 1; k++) {
					char[] recode = new char[3];
					recode[0] = (char)i;
					recode[1] = (char)j;
					recode[2] = (char)k;
					String strRecode = Arrays.toString(recode);
					if (code.equals(strRecode)) {
						System.out.println("经多层for循环得到的解码：" + strRecode);
						flag = true;
						break;
					}
				}
			}
		}
	}

	private static String getString(int length) {
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
