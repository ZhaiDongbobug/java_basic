package basicExample3;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {

	public static void main(String[] args) {
		Hero[] heros = new Hero[10];
		HeroNode roots = new HeroNode();
		for(int i=0;i<10;i++) {
			heros[i] = new Hero("hero "+i);
			heros[i].setHp((int) (Math.random()*1000));
			roots.add(heros[i]);
		}
		System.out.println(roots.values());
	}

	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero value;
	
	public void add(Hero v) {
		if(null == value)
			value = v;
		else {
			if(v.getHp() > value.getHp()) {
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
