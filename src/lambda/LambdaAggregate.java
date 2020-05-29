package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class LambdaAggregate {

	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero-" + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("用传统方式打印hp第三高的英雄名称");
		// 在Hero类中，compareHero方法以hp的从小到大排列

		Collections.sort(heros, new Comparator<Hero>() {
			public int compare(Hero h1, Hero h2) {
				return (int) (h2.hp - h1.hp);
			}
		});
		System.out.println(heros.toString());
		System.out.println("--------------");
		System.out.println("第三高的英雄：" + heros.get(2).name);
		System.out.println("用聚合操作打印hp第三高的英雄名称");
		System.out.println("--------------");
		String name = heros.stream().sorted((h1, h2) -> h2.hp > h1.hp ? 1 : -1).skip(2).map(h -> h.name).findFirst()
				.get();
		System.out.println("第三高的英雄：" + name);
	}
}
