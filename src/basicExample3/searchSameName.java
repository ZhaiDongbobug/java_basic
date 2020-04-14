package basicExample3;

import java.util.ArrayList;

public class searchSameName {

	public static void main(String[] args) {
		ArrayList<hero> heros = new ArrayList<hero>();
		heros.add(new hero("hero 1"));
		heros.add(new hero("hero 2"));
		heros.add(new hero("hero 3"));
		heros.add(new hero("hero 4"));
		for(hero h:heros) {
			if(h.toString() == "hero 1") {
				System.out.println("找到了name是\"hero 1\"的对象 ");
				break;
			}
		}
	}

}
