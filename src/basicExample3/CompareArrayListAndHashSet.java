package basicExample3;

import java.util.HashSet;
import java.util.Set;

public class CompareArrayListAndHashSet {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 50; i++) {
			Integer number = (int) (Math.random() * 999);
			set.add(number);
		}
		System.out.println(set);
	}

}
