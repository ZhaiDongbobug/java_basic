package basicExample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class objectStream {

	public static void main(String[] args) {
		hero[] ho = new hero[10];
		for(int i=0;i<ho.length;i++) {
			ho[i] = new hero("hero:"+i);
		}
		File f = new File("heros.lol");
		try(FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(ho);
			hero[] hs = (hero[]) ois.readObject();
			System.out.println("查看中文件中反序列化出来的数组中的每一个元素：");
			for(hero hr:hs) {
				System.out.println(hr.name);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
