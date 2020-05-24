package basicExample3;

import java.util.ArrayList;
import java.util.List;

public class MyHashMapCompare {

	public static void main(String[] args) {
		int total = 100 * 1000;
		List<Hero> list = new ArrayList<>(total);
		for (int i = 0; i < total; i++) {
			int number = (int) (Math.random() * 8999 + 1000);
			list.add(new Hero("hero-" + number));
		}
		// 强for循环遍历
		long start = System.currentTimeMillis();
		List<Hero> temp = new ArrayList<>();
		for (Hero hero : list) {
			if (hero.name.equals("hero-5555")) {
				temp.add(hero);
			}
		}
		System.out.println("使用for循环，遍历出来的结果是：");
		for (int i = 0; i < temp.size(); i++) {
			Hero hero = temp.get(i);
			System.out.printf(hero.name + " ");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		long end = System.currentTimeMillis();
		System.out.printf("for循环查找耗费%d毫秒的时间", end - start);
		MyHashMap map = new MyHashMap();
		List<Hero> values;
		for (Hero hero : list) {
			if (map.get(hero.name) != null) {
				List<Hero> value = (List<Hero>) map.get(hero.name);
				value.add(hero);
				continue;
			}
			values = new ArrayList();
			values.add(hero);
			map.put(hero.name, values);
		}
		// 使用MyHashMap
		start = System.currentTimeMillis();
		System.out.println("使用MyHashMap: ");
		List<Hero> temp2 = (List<Hero>) map.get("hero-5555");
		for (int i = 0; i < temp2.size(); i++) {
			Hero hero = temp2.get(i);
			System.out.printf(hero.name + " ");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		end = System.currentTimeMillis();
		System.out.printf("MyHashMap查询耗费%d毫秒", end - start);
	}

}
