package basicExample3;

public class CompareArithmetic {

	public static void main(String[] args) {
		System.out.println("初始化一个长度是40000的随机数字的数组");
		long start = System.currentTimeMillis();
		CompareArithmetic sort = new CompareArithmetic();
		int[] value1 = sort.initalizeArray(40000);
		sort.selectSort(value1);
		long end = System.currentTimeMillis();
		System.out.printf("选择排序，一共耗时%d毫秒\n", end - start);
		start = System.currentTimeMillis();
		int[] value2 = sort.initalizeArray(40000);
		sort.bubbSort(value2);
		end = System.currentTimeMillis();
		System.out.printf("冒泡排序，一共耗时%d毫秒\n", end - start);
		start = System.currentTimeMillis();
		int[] value3 = sort.initalizeArray(40000);
		sort.treeSort(value3);
		end = System.currentTimeMillis();
		System.out.printf("二叉树排序，一共耗时%d毫秒\n", end - start);
	}

	private int[] initalizeArray(int length) {
		int[] sct = new int[length];
		for (int i = 0; i < sct.length; i++) {
			sct[i] = (int) (Math.random() * length);
		}
		return sct;
	}

	private void treeSort(int[] value3) {
		TreeNode intTree = new TreeNode();
		for (int value : value3) {
			intTree.add(Integer.valueOf(value));
		}
	}

	private void bubbSort(int[] sct) {
		for (int i = 0; i < sct.length; i++) {
			for (int j = 0; j < sct.length - i - 1; j++) {
				if (sct[j] > sct[j + 1]) {
					int temp = sct[j];
					sct[j] = sct[j + 1];
					sct[j + 1] = temp;
				}
			}
		}
	}

	private void selectSort(int[] sct) {
		for (int i = 0; i < sct.length; i++) {
			for (int j = i + 1; j < sct.length; j++) {
				if (sct[i] > sct[j]) {
					int temp = sct[i];
					sct[i] = sct[j];
					sct[j] = temp;
				}
			}
		}
	}

}
