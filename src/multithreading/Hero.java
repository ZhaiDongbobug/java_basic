package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Hero {

	public String name;
	public int damage;
	private AtomicInteger atomicHp = new AtomicInteger();

	public static void main(String[] args) {
		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.atomicHp.set(10000);
		int n = 10000;

		Thread[] addThreads = new Thread[n];
		Thread[] reduceThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {

					// recover自带synchronized
					gareen.recover();

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i] = t;

		}

		for (int i = 0; i < n; i++) {
			Thread t = new Thread() {
				public void run() {
					// hurt自带synchronized
					gareen.hurt();

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			reduceThreads[i] = t;
		}

		for (Thread t : addThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (Thread t : reduceThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n, n, gareen.atomicHp.floatValue());
	}

	public void attackHero(Hero hero) {
		hero.atomicHp.addAndGet(0 - damage);
		System.out.format("%s正在攻击%s,%s的血变成了%。0f%n", name);
		if (hero.isDead()) {
			System.out.println(hero.name + "死了！");
		}
	}

	public void recover() {
		atomicHp.incrementAndGet();
	}

	public void hurt() {
		atomicHp.decrementAndGet();
	}

	public boolean isDead() {
		return 0 >= atomicHp.intValue() ? true : false;
	}
}
