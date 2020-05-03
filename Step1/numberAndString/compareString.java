package numberAndString;


public class compareString {

	static int pos;
	static String[] foundDuplicated = new String[100];

	public static void main(String[] args) {
		String[] ss = new String[100];
		//初始化
		for(int i=0;i<ss.length;i++) {
			ss[i] = randomString(2);
		}
		//打印
		for(int i=0;i<ss.length;i++) {
			System.out.print(ss[i] + " ");
			if(19 == i%20)
				System.out.println();
		}
		
		for(String s1:ss) {
			int repeat = 0;
			for(String s2:ss) {
				if(s1.equalsIgnoreCase(s2)) {
					repeat++;
					if(2 == repeat) {
						//当repeat==2时候，就找打了一个非己的重复字符串
						
						putIntDuplicatedArray(s1);
						break;
					}
				}
			}
		}
		System.out.printf("总共有 %d种重复的字符串%n", pos);
		if (pos != 0) {
			System.out.println("分别是：");
			for(int i=0;i<pos;i++) {
				System.out.print(foundDuplicated[i] + " ");
			}
		}
	}
	
	private static void putIntDuplicatedArray(String s) {
		for(int i=0;i<pos;i++) {
			if(foundDuplicated[i].equalsIgnoreCase(s))
				return;
		}
		foundDuplicated[pos++] = s;
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
