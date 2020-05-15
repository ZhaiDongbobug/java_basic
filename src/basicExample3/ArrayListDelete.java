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
		Iterator<Hero> it = value.iterator();
		while (it.hasNext()) {
			Hero h = it.next();
			String[] str = h.name.split(" ");
			int seq = Integer.valueOf(str[1]);
			if (seq % 8 == 0) {
				it.remove();
				System.out.println(h.name);
			}
		}
		/*
		 * for(Hero h : value) { String[] str = h.name.split(" "); int seq =
		 * Integer.parseInt(str[1], 10); if(seq % 8 == 0) { value.remove(h);
		 * System.out.println(h.name); } }
		 */
	}
}
