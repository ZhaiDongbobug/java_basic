package basicExample2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class dateStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("d:/lol2.txt");
		try(
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
		   ){
			pw.println("31|15");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try(FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);){
			String str = br.toString();
			str.split("\\|");
			int i=Integer.parseInt("str[0]");
			int j=Integer.valueOf("str[1]").intValue();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
