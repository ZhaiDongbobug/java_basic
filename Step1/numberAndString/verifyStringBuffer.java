package numberAndString;

public class verifyStringBuffer {

	public static void main(String[] args) {
		String str = "";
		StringBuffer sbf = new StringBuffer();	
		int currentTime = (int) System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			str+=randomString(10);
		}
		int strEnd = (int) System.currentTimeMillis();
		System.out.printf("使用字符串连接的方式，连接10000次，耗时：%d毫秒",(strEnd-currentTime));
		System.out.println();
		for(int i=0;i<10000;i++) {
			sbf.append(randomString(10));
		}
		int sbfEnd = (int) System.currentTimeMillis();
		System.out.printf("使用StringBuffer的方式，连接1000000次，耗时%d毫秒",(sbfEnd-strEnd));
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
