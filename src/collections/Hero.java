
package collections;

public class Hero {
			public String name;
			public float hp;
			public Hero() {
				
			}
			public Hero(String name) {
				this();
				this.name = name;
			}
			public String toString() {
				return String.format("[name:%s hp:%.0f]%n", name,hp);
			}
}
