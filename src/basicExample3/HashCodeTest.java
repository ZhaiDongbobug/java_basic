package basicExample3;

public class HashCodeTest {

	public static void main(String[] args) {
		int length;
		String str;
		for (int i = 0; i < 100; i++) {
			length = (int) (Math.random() * 8 + 2);
			str = randomString(length);
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
			hash += c;
		}
		hash *= 23;
		//取绝对值
		hash = hash<0 ? 0-hash:hash;
		//落在0-1999之间
		hash = hash % 2000;
		
		return hash;
	}

}
