package numberAndString;

public class compareString {

	public static void main(String[] args) {
		String[] strArry = new String[100];
		for(int i=0;i<strArry.length;i++) {
			strArry[i] = randomString(2);
		}
		String str = strArry.toString();
		System.out.println(str);
		int count = 0;

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
