package collections;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if (i1 <= i2)
					return 1;
				else
					return -1;
			}
		};
		TreeSet<Integer> treeSet = new TreeSet<Integer>(comparator);
		for (int i = 0; i < 10; i++) {
			treeSet.add(i);
		}
		System.out.println(treeSet);

	}

}
