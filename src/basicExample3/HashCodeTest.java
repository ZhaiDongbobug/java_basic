package basicExample3;

public class HashCodeTest {

	public static void main(String[] args) {
		int length;
		String[] strArry = new String[100];
		for (int i = 0; i < strArry.length; i++) {
			length = (int) (Math.random() * 8 + 2);
			strArry[i] = randomString(length);
		}
		for (String str : strArry) {
			int hash = hashcode(str);
			System.out.println(hash);
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

	public static int hashcode(String str) {
		if (str == null) {
			return 0;
		}
		char[] ch = str.toCharArray();
		int hash = 0;
		for (char c : ch) {
			hash += Math.abs(c);
		}
		hash *= 23;
		if (hash > 1999) {
			return hash % 2000;
		}
		return hash;
	}

}
