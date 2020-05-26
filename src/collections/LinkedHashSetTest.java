package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<>();
		String str = String.valueOf(Math.PI);
		//去掉点
		str.replace(".","");
		char[] numbers = str.toCharArray();
		for (char c: numbers) {
			int number = Integer.parseInt(String.valueOf(c));
			set.add(number);
		}
		System.out.println(Math.PI);
		System.out.println(set);

	}

}
