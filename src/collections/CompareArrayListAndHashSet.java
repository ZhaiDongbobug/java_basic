package collections;

import java.util.HashSet;
import java.util.Set;

public class CompareArrayListAndHashSet {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		while (set.size() < 50) {
			Integer number = (int) (Math.random() * 999);
			set.add(number);
		}
		System.out.println(set);
	}

}
