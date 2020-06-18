package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class TestSecond {

	public static void main(String[] args) {
		String fileName = "hero.config"+"file.txt";
		//创建文件
		File file = new File("C:/Eclipsejee/java_basic/src/reflection/" + fileName);
		if(file.exists()) {
			System.out.println("文件已存在");
		}else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		//向文件中写入
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("reflection.APHero");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//创建对象
		
		try {
			BufferedReader br = new BufferedReader
					(new FileReader(file));
			String className = br.readLine();
			System.out.println(className);
			//用反射创建APHero的对象
			Class pClass = Class.forName(className);
			Constructor c = pClass.getConstructor();
			APHero aph = (APHero) c.newInstance();
			aph.magicAttack();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
