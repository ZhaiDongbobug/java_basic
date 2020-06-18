package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestThird {
	
	public static void main(String[] args) {
		String fileName = "hero.config"+"file.txt";
		//创建文件
		File file = new File
				("C:/Eclipsejee/java_basic/src/reflection/" + fileName);
		try {
			BufferedReader br = new BufferedReader
					(new FileReader(file));
			//读取文本文件的内容
			String className1 = br.readLine();
			String name1 = br.readLine();
			String className2 = br.readLine();
			String name2 = br.readLine();
			//打印获取的字符串
			System.out.println(className1);
			System.out.println(name1);
			System.out.println(className2);
			System.out.println(name2);
			//用反射创建APHero的对象
			Class pClass1 = Class.forName(className1);
			Constructor c1 = pClass1.getConstructor();
			APHero aph = (APHero) c1.newInstance();
			//用反射创建ADHero的对象
			Class pClass2 = Class.forName(className2);
			Constructor c2 = pClass2.getConstructor();
			ADHero adh = (ADHero) c2.newInstance();
			//用反射调用的方法给两个英雄设置名称
			Method m1 = aph.getClass().getMethod("setName", String.class);
			m1.invoke(aph, name1);
			Method m2 = adh.getClass().getMethod("setName", String.class);
			m2.invoke(adh, name2);
			//用反射调用的方法攻击第二个英雄
			Method m = aph.getClass().getMethod("attackHero", Hero.class);
			m.invoke(aph, adh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
