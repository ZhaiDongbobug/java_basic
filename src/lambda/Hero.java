package lambda;

public class Hero {

	public String name;
    public float hp;
  
    public int damage;
  
    public Hero() {
  
    }
  
    public Hero(String name) {
 
        this.name = name;
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
}
