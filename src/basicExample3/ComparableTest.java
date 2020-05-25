package basicExample3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>();
		System.out.println("开始初始化");
		for(int i=0;i<10;i++) {
			String name = randomString(4);
			int price = (int) (Math.random()*100+50);
			list.add(new Item(price,name));
		}
		System.out.println("初始化完成");
		System.out.println("初始化内容：");
		System.out.println(list);
		System.out.println("排序后的结果：");
		Collections.sort(list);
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
