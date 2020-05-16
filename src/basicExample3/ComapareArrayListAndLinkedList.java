package basicExample3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComapareArrayListAndLinkedList {

	public static void main(String[] args) {

		ArrayList value1 = new ArrayList();
		value1.add(5);
		value1.add(6);
		LinkedList value2 = new LinkedList();
		value2.add(5);
		value2.add(6);
		compareList(value1, "ArrayList");
		compareList(value2, "LinkedList");
	}

	public static void compareList(List list, String type) {
		int total = 100000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(1, i);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s中间添加数据耗费时间%d毫秒%n", type, (end - start));
	}

}
