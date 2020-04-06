package basicExample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class dateStreamExample {

	static int x = 31;
	static int y = 15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		File f = new File("d:/lol2.txt");
		try(
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		   ){
			pw.println(x+"@"+y);
			pw.flush();
			String str = br.readLine();
			String[] ss = str.split("@");
			int x = Integer.parseInt(ss[0]);
			int y = Integer.parseInt(ss[1]);
			System.out.printf("使用缓存流读取的x是%d y是%d%n",x,y);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

}
