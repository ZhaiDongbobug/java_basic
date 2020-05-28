package lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaConstructor {

	public static void main(String[] args) {
		// List<Integer> l;
		// l = new ArrayList<>();
		insertFirst(ArrayList::new, "ArrayList");

		// l = new LinkedList<>();
		insertFirst(LinkedList::new, "LinkedList");

	}

	private static void insertFirst(Supplier<List> l, String type) {
		if (l instanceof ArrayList) {
			ArrayList st = (ArrayList) l;
		} else if (l instanceof LinkedList) {
			LinkedList st = (LinkedList) l;
		}
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			st.add(0, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
}
