package lambda;

public class Hero {

	public String name;
	public float hp;

	public int damage;

	public Hero() {
		
	}

	public Hero(String name) {

		this.name = name;
		hp = 1000;
		damage = 2;
	}

	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}

	public Hero(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	public int compareHero(Hero h2) {
		// 按照hp进行排序
		if (this.hp >= h2.hp)
			return 1; // 正数表示h1比h2要大
		else
			return -1;
	}

	//
	public synchronized void recover() {
		while (hp >= 1000) {
			try {
				// 让占有this的减血线程，暂时释放对this的占有，并等待
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp = hp + 1;
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
		this.notifyAll();
	}

	public synchronized void hurt() {
		while (hp <= 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp = hp - 1;
		System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
		// 通知那些等待在this对象上的线程，可以醒过来了
		this.notifyAll();
	}

}
