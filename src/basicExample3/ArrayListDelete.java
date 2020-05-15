package basicExample3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDelete {

	public static void main(String[] args) {
		List<Hero> value = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			value.add(new Hero("hero " + i));
		}
		//存放要删除的对象集合
		List<Hero> temp = new ArrayList<>();
		
		Iterator<Hero> it = value.iterator();
		while (it.hasNext()) {
			Hero h = it.next();
			//提取字符串的数字部分
			String[] str = h.name.split(" ");
			int seq = Integer.valueOf(str[1]);
			if (seq % 8 == 0) {
				temp.add(h);
				System.out.println(h.name);
			}
		}
		value.removeAll(temp);
		System.out.println(value.size());
		/*
		 * for(Hero h : value) { String[] str = h.name.split(" "); int seq =
		 * Integer.parseInt(str[1], 10); if(seq % 8 == 0) { value.remove(h);
		 * System.out.println(h.name); } }
		 */
	}
}
