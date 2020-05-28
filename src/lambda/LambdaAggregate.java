package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaAggregate {

	public static void main(String[] args) {
		int length = 10;
		List<Hero> heros = new ArrayList<>(length);
		for (int i = 0; i < length; i++) {
			Hero hero = new Hero("hero-" + i);
			hero.damage = (int) (Math.random() * 100 + 50);
			hero.hp = (int) (Math.random() * 1000 + 500);
			heros.add(hero);
		}
		System.out.println("用传统方式打印hp第三高的英雄名称");
		// 在Hero类中，compareHero方法以hp的从小到大排列
		List<Hero> heros1 = new ArrayList<>(Arrays.asList(new Hero[heros.size()]));
		Collections.copy(heros1, heros);
		heros1.sort(Hero::compareHero);
		System.out.println("--------------");
		System.out.println("第三高的英雄：" + heros1.get(length - 4).name);
		System.out.println("用聚合操作打印hp第三高的英雄名称");
		List<Hero> heros2 = new ArrayList<>(Arrays.asList(new Hero[heros.size()]));
		Collections.copy(heros2, heros);
		System.out.println("--------------");
		Hero hero = heros2.stream().sorted(Hero::compareHero).filter(predicate);
		System.out.println(hero.name);
	}
}
