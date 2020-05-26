package collections;

import java.util.ArrayList;
import java.util.List;

public class MyHashMapCompare {

	public static void main(String[] args) {
		int total = 100 * 1000;
		List<Hero> list = new ArrayList<>(total);//避免多次扩容浪费时间
		System.out.println("初始化开始");
		for (int i = 0; i < total; i++) {
			int number = (int) (Math.random() * 8999 + 1000);
			list.add(new Hero("hero-" + number));
		}	
		//名字作为key
		//名字相同的hero,放在一个List中,作为value
		MyHashMap map = new MyHashMap();
		for (Hero hero : list) {
			List<Hero> value = (List<Hero>) map.get(hero.name);
			if (value == null) {
				value = new ArrayList();
				map.put(hero.name, value);
			}
			value.add(hero);		
		}
		System.out.println("初始化结束");
		System.out.println("开始查找");
		findByIterator(list);
		findByMyHashMap(map);
	}
	
	private static List<Hero> findByIterator(List<Hero> list){ 
		long start = System.currentTimeMillis();
		List<Hero> temp = new ArrayList<>();
		for (Hero hero : list) {
			if (hero.name.equals("hero-5555")) {
				temp.add(hero);
			}
		}
		long end = System.currentTimeMillis();
		System.out.printf("使用for循环，查询得到%d个hero对象,耗费%d毫秒%n",temp.size(),end-start);
		return temp;
	}
	
	private static List<Hero> findByMyHashMap(MyHashMap map){
		long start = System.currentTimeMillis();
		System.out.println("使用MyHashMap: ");
		List<Hero> temp = (List<Hero>) map.get("hero-5555");
		long end = System.currentTimeMillis();
		System.out.printf("MyHashMap查询得到%d个hero对象，耗费%d毫秒",temp.size(), end - start);
		return temp;
	}

}
