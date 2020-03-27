package basicExample2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("D:\\eclipseworkspace\\"
				+ "Zdb190131\\src\\text1\\ReferenceArrayTest.java");
		File f2 = new File("D:\\eclipseworkspace\\"
				+ "Zdb190131\\src\\text2\\TwoDimensionTest.java");
		decodeFile(f1,f2);
	}
	public static void decodeFile(File decodingFile, File decodedFile) {
		try(FileReader fr = new FileReader(decodingFile);
				FileWriter fw = new FileWriter(decodedFile)){
			char[] fileContent = new char[(int) decodingFile.length()];
			fr.read(fileContent);
			System.out.println("解密前的内容：");
			System.out.println(new String(fileContent));
			decode(fileContent);
			System.out.println("解密后的内容：");
			System.out.println(new String(fileContent));
			fw.write(fileContent);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void decode(char[] fileContent) {
		for(int i=0; i<fileContent.length; i++) {
			char c = fileContent[i];
			if(isLetterOrDigit(c)) {
				switch(c) {
				case'0':
					c='9';
					break;
				case'a':
					c='z';
					break;
				case'A':
					c='Z';
					break;
				default:
					c--;
					break;		
				}
			}			
			fileContent[i] = c;
		}
	}
	public static Boolean isLetterOrDigit(char c) {
		String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTU"
				+ "VWXYZabcdefghijklmnopqrstuvwxyz";
		return -1 == letterOrDigital.indexOf(c)? false:true;
	}

}
