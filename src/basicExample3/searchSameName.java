package basicExample3;

import java.util.ArrayList;

public class searchSameName {

	public static void main(String[] args) {
		ArrayList<hero> heros = new ArrayList<hero>();
		String name = "hero 1";
		for(int i=0; i<5; i++) {
			heros.add(new hero("hero "+i));
		}
		for(int i=0; i<heros.size(); i++) {
			hero h = heros.get(i);
			if(name.equals(h.toString())) {
				System.out.println("找到了name是\"hero 1\"的对象 ");
				break;
			}
		}
	}

}
