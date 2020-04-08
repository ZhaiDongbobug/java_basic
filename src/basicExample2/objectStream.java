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
		for(int i=0;i<10;i++) {
			hero h = new hero(i);
			ho[i] = h;
		}
		File f = new File("heros.lol");
		try(FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(ho);
			hero[] Ho = new hero[10];
			ois.readObject(Ho);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
