package basicExample3;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {

	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero value;
	public static void main(String[] args) {
		List<Hero> hs = new ArrayList<>();
		for(int i=0;i<10;i++) {
			Hero hero = new Hero();
			hero.name = "hero "+i;
			hero.hp = (float) (Math.random()*900+100);
			hs.add(hero);
		}
		System.out.println("初始化10个Hero");
		System.out.println(hs);
		
		
		HeroNode heroTree = new HeroNode();
		for(Hero hero:hs) {
			heroTree.add(hero);
		}
		System.out.println("根据血量倒排序后的Hero");
		System.out.println(heroTree.values());
	}

	
	
	public void add(Hero v) {
		if(null == value)
			value = v;
		else {
			if(v.hp > value.hp) {
				if(null == leftNode)
					leftNode = new HeroNode();
				leftNode.add(v);
			}
			else {
				if(null == rightNode)
					rightNode = new HeroNode();
				rightNode.add(v);
			}
		}
	}
	// 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
  
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());
  
        // 当前节点
        values.add(value);
  
        // 右节点的遍历结果
        if (null != rightNode)
  
            values.addAll(rightNode.values());
  
        return values;
    }
}
