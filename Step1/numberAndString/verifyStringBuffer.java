package numberAndString;

public class verifyStringBuffer {

	public static void main(String[] args) {
		int total = 10000;
		String s = randomString(10);
		String str = "";
		StringBuffer sbf = new StringBuffer();
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			str += s;
		}
		long end = System.currentTimeMillis();
		System.out.printf("使用字符串连接的方式，连接%d次，耗时：%d毫秒", total, (end - start));
		System.out.println();
		start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			sbf.append(s);
		}
		end = System.currentTimeMillis();
		total *= 100;
		System.out.printf("使用StringBuffer的方式，连接%d次，耗时%d毫秒", total, (end - start));
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
