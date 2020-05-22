package basicExample3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		int total = 100;
		String[] strArry = new String[total];
		for(int i=0;i<total;i++) {
			strArry[i] = randomString(2);
		}
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		for(String str:strArry) {
			if(set.contains(str)) {
				list.add(str);
			}
			set.add(str);
		}
		System.out.printf("总共有%d种重复的字符串%n",list.size());
		System.out.println(list);	
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
