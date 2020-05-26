package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class automaticCreateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("请输入类的名称：");
		String className = s.nextLine();
		System.out.println("请输入属性的类型：");
		String type = s.nextLine();
		System.out.println("请输入属性的名称：");
		String property = s.nextLine();
		String Uproperty = toUpperFirstLetter(property);
		File modelFile = new File("d:/test");
		String modelContent = null;
		try(FileReader fr = new FileReader(modelFile)){
			char cs[] = new char[(int) modelFile.length()];
			fr.read(cs);
			modelContent = new String(cs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileContent = modelContent.replace("@class@", className);
		fileContent = modelContent.replace("@type@", type);
		fileContent = modelContent.replace("@property@", property);
		fileContent = fileContent.replace("@Uproperty", Uproperty);
		String fileName = className + ".java";
		
		System.out.println("替换后的内容：");
		System.out.println(fileContent);
		File file = new File("d:\\project",fileName);
		try(FileWriter fw = new FileWriter(file);){
			fw.write(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("文件保存在：" + file.getAbsolutePath());
		
	}

	private static String toUpperFirstLetter(String str) {
		// TODO Auto-generated method stub
		char upperCaseFirst = Character.toUpperCase(str.charAt(0));
		String rest = str.substring(1);
		return upperCaseFirst + rest;
	}

}
