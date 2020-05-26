package collections;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		double total = 1000 * 1000;
		double count = 0;
		for (int i = 0; i < total; i++) {
			Collections.shuffle(list);
			if (list.get(0) == 3 && list.get(1) == 1 && list.get(2) == 4) {
				count++;
			}
		}
		String result = accuracy(count, total, 3);
		System.out.println(result);

	}

	public static String accuracy(double num, double total, int scale) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		// 可以设置精确几位小数
		df.setMaximumFractionDigits(scale);
		// 模式 例如四舍五入
		df.setRoundingMode(RoundingMode.HALF_UP);
		double accuracy_num = num / total * 100;
		return df.format(accuracy_num) + "%";
	}
}
