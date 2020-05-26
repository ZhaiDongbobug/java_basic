package collections;

import java.util.Arrays;
import java.util.List;

public class CompareArithmetic {

	public static void main(String[] args) {
		int total = 40000;
		System.out.println("初始化一个长度是" + total + "的随机数字的数组");
		int[] originalNumbers = new int[total];
		for (int i = 0; i < total; i++) {
			originalNumbers[i] = (int) (Math.random() * total);
		}
		System.out.println("初始化完毕");
		System.out.println("接下来分别用3种算法");
		int[] use4sort;
		use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
		int[] sortedNumbersBySelection = performance(new SelectionSort(use4sort), "选择法");

		use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
		int[] sortedNumbersByBubbling = performance(new BubblingSort(use4sort), "冒泡法");

		use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
		int[] sortedNumbersByTree = performance(new TreeSort(use4sort), "二叉树");

		System.out.println("查看排序结果，是否是不同的数组对象");
		System.out.println(sortedNumbersBySelection);
		System.out.println(sortedNumbersByBubbling);
		System.out.println(sortedNumbersByTree);

		System.out.println("查看排序结果，内容是否相同");
		System.out.println("比较 选择法 和 冒泡法  排序结果：");
		System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByBubbling));
		System.out.println("比较 选择法 和 二叉树  排序结果：");
		System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByTree));

	}

	interface Sort {
		void sort();

		int[] values();
	}

	static class SelectionSort implements Sort {
		int[] numbers;

		SelectionSort(int[] numbers) {
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[i] > numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}

		}

		@Override
		public int[] values() {
			// TODO Auto-generated method stub
			return numbers;
		}

	}

	static class BubblingSort implements Sort {
		int[] numbers;

		BubblingSort(int[] numbers) {
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers.length - i - 1; j++) {
					if (numbers[j] > numbers[j + 1]) {
						int temp = numbers[j];
						numbers[j] = numbers[j + 1];
						numbers[j + 1] = temp;
					}
				}
			}

		}

		@Override
		public int[] values() {
			// TODO Auto-generated method stub
			return numbers;
		}

	}

	static class TreeSort implements Sort {
		int[] numbers;
		Node n;

		TreeSort(int[] numbers) {
			n = new Node();
			this.numbers = numbers;
		}

		@Override
		public void sort() {
			for (int number : numbers) {
				n.add(number);
			}
		}

		@Override
		public int[] values() {
			List<Object> list = n.values();
			int sortedNumbers[] = new int[list.size()];
			for (int i = 0; i < sortedNumbers.length; i++) {
				sortedNumbers[i] = (int) list.get(i);
				// 因为这是向下转型，所以Object可以强转为int类型
			}
			return sortedNumbers;
		}
	}

	private static int[] performance(Sort algorithm, String type) {
		long start = System.currentTimeMillis();
		algorithm.sort();
		int sortedNumbers[] = algorithm.values();
		long end = System.currentTimeMillis();
		System.out.printf("%s排序，一共耗时%d毫秒%n", type, end - start);
		return sortedNumbers;
	}
}
