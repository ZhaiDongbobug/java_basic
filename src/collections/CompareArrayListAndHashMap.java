package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompareArrayListAndHashMap {

	public static void main(String[] args) {
		int total = 3000*1000;
		ArrayList<Hero> value1 = new ArrayList<>();
		HashMap<String,List<Hero>> value2 = new HashMap<>();
		// 定义字符串键值key
		String str = null;
		// 定义存储相同Hero对象的value值list
		List<Hero> list;
		//同时初始化ArrayList和HashMap
		for(int i=0;i<total;i++) {
			int number = getNumber();
			str = "hero-"+number;
			Hero hero = new Hero(str);
			//初始化HashMap
			//判断HashMap里是否有这个键值，没有创建新的集合放相同的Hero对象
			if(value2.get(str) == null) {
				list = new ArrayList<>();
				list.add(hero);
				value2.put(str, list);
			}else {
				//如果有这个键值不为空，那么向list中添加对象
				list = value2.get(str);
				list.add(hero);
				value2.put(str, list);
			}		
			value1.add(hero);
		}
		long start = System.currentTimeMillis();
		//计算ArrayList中“hero-5555”的对象数量
		int count = 0;
		for(int i=0;i<total;i++) {
			Hero h = (Hero) value1.get(i);
			if(h.name.equals("hero-5555")) {
				count++;
				//System.out.println(h.name);
			}
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.printf("ArrayList耗费的时间为%d毫秒%n",end-start);
		//HashMap查找
		start = System.currentTimeMillis();
		List<Hero> heroList = value2.get("hero-5555");
		System.out.println(heroList.size());
		end = System.currentTimeMillis();
		System.out.printf("HashMap耗费的时间为%d毫秒",end-start);
	}
	private static int getNumber() {
		int number = 0;
		while(true) {
			number = (int) (Math.random()*10000);
			if(number > 999 && number < 10000) {
				break;
			}
		}
		return number;
	}

}
