package basicExample3;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareArrayListAndHashMap {

	public static void main(String[] args) {
		int total = 3000*1000;
		int count = 0;
		ArrayList<Hero> value1 = new ArrayList<>();
		for(int i=0;i<total;i++) {
			int number = getNumber();
			value1.add(new Hero("hero-"+number));
		}
		long start = System.currentTimeMillis();
		for(int i=0;i<total;i++) {
			Hero h = (Hero) value1.get(i);
			if(h.name.equals("hero-5555")) {
				count++;
				System.out.println(h.name);
			}
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.printf("ArrayList耗费的时间为%d毫秒%n",end-start);
		HashMap<String,Hero> value2 = new HashMap<>();
		String str = null;
		for(int i=0;i<total;i++) {
			int number = getNumber();
			str = "hero-"+number;
			value2.put(str, new Hero(str));
		}
		start = System.currentTimeMillis();
		System.out.println(value2.get("hero-5555").name);
		value2.get("hero-5555");
		end = System.currentTimeMillis();
		System.out.printf("HashMap耗费的时间为%d毫秒",end-start);
	}
	private static int getNumber() {
		int number = 0;
		while(true) {
			number = (int) (Math.random()*10000);
			if(number > 999) {
				break;
			}
		}
		return number;
	}

}
