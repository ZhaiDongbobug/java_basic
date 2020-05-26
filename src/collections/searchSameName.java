package collections;

import java.util.ArrayList;

public class searchSameName {

	public static void main(String[] args) {
		ArrayList<Hero> heros = new ArrayList<Hero>();
		heros.add(new Hero("hero 1"));
		heros.add(new Hero("hero 2"));
		heros.add(new Hero("hero 3"));
		heros.add(new Hero("hero 4"));
		for(Hero h:heros) {
			if(h.toString() == "hero 1") {
				System.out.println("找到了name是\"hero 1\"的对象 ");
				break;
			}
		}
	}

}
