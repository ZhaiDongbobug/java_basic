package basicExample3;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		Set<Character> set = new LinkedHashSet<>();
		String str = String.valueOf(Math.PI);
		char[] numbers = str.toCharArray();
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == '.') {
				continue;
			}
			set.add(numbers[i]);
		}
		System.out.println(set);

	}

}
