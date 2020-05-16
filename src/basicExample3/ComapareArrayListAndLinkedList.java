package basicExample3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComapareArrayListAndLinkedList {

	public static void main(String[] args) {

		ArrayList value1 = new ArrayList();
		LinkedList value2 = new LinkedList();
		compareList(value1, "ArrayList");
		compareList(value2, "LinkedList");
	}

	public static void compareList(List list, String type) {
		int total = 100000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s添加数据耗费时间%d毫秒%n", type, (end - start));
	}

}
