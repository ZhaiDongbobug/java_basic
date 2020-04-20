package numberAndString;

import java.util.Arrays;

public class StrArrSort {

	public static void main(String[] args) {
		String[] strArr = new String[8];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = getString(5);
		}
		System.out.println("未排序前的字符串数组：");
		System.out.println(Arrays.toString(strArr));
		for (int j = 0; j < strArr.length; j++) {
			for (int i = 1; i < strArr.length - j - 1; i++) {
				char firstChar1 = strArr[i].charAt(0);
				char firstChar2 = strArr[i + 1].charAt(0);
				firstChar1 = Character.toLowerCase(firstChar1);
				firstChar2 = Character.toLowerCase(firstChar2);
				if (firstChar1 > firstChar2) {
					String med = strArr[i];
					strArr[i] = strArr[i + 1];
					strArr[i + 1] = med;
				}
			}
		}
		System.out.println("排序后的字符串数组：");
		System.out.println(Arrays.toString(strArr));
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
