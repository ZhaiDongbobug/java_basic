package InterfaceAndExtends;

public class Hero {

	public static void main(String[] args) {
		Hero hero = new Hero();
		Mortal AD = new ADHero();
		Mortal AP = new APHero();
		Mortal ADAP = new ADAPHero();
		hero.kill(AD);
		hero.kill(AP);
		hero.kill(ADAP);
	}
	
	public void kill(Mortal m) {
		m.die();
	}


}
