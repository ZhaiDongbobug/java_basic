
package basicExample3;

public class Hero {
			private String name;
			private int hp;
			public Hero(String name) {
				this.name = name;
			}
			public String toString() {
				return this.name;
			}
			public int getHp() {
				return hp;
			}
			public void setHp(int hp) {
				this.hp = hp;
			}
}
