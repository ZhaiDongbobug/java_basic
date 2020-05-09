package numberAndString;

public class CompareStringBuffer {

	public static void main(String[] args) {
		String str = randomString(10);
		StringBuffer sbf = new StringBuffer();
		int total = 1000000;
		long start = System.currentTimeMillis();
		for(int i=0;i<total;i++) {
			sbf.append(str);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuffer耗费的时间为：" + (end-start));
		MyStringBuffer msbf = new MyStringBuffer();
		start = System.currentTimeMillis();
		for(int i=0;i<total;i++) {
			msbf.append(str);
		}
		end = System.currentTimeMillis();
		System.out.println("MyStringBuffer耗费的时间为：" + (end-start));
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
