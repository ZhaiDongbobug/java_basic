package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LambdaTest {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			// 通过随机值实例化hero的hp和damage
			heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);
		Collections.sort(heros, (h1, h2) -> h1.hp >= h2.hp ? 1 : -1);
		System.out.println("按照血量排序后的集合：");
		System.out.println(heros);
	}
}
