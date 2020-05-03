package numberAndString;

import java.util.ArrayList;

public class compareString {

	public static void main(String[] args) {
		String[] strArry = new String[100];
		for(int i=0;i<strArry.length;i++) {
			strArry[i] = randomString(2);
			
		}
		//System.out.println(strArry.length);
		for(int i=0;i<strArry.length;i++) {
			System.out.printf("%-3s",strArry[i]);
			if((i+1)%20 == 0) {
				System.out.printf("\n");
			}
		}
		ArrayList<String> alStr = new ArrayList<String>(); 
		for(int i=0;i<strArry.length;i++) {
			for(int j=0;i<strArry.length;j++) {
				if(strArry[i].equals(strArry[j])) {
					alStr.add(strArry[i]);
				}
			}
		}
		ArrayList<String> tempList = new ArrayList<String>(alStr.size());
		for(int i=0;i<alStr.size();i++) {
			if(!tempList.contains(alStr.get(i))) {
				tempList.add(alStr.get(i));
			}
		}
		System.out.printf("总共有%d种重复的字符串\n",tempList.size());
		System.out.printf("分别是：\n");
		System.out.printf("%-3s",tempList.listIterator());
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
