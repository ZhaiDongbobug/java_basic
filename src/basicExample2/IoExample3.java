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
		encodeFile(f1,f2);
	}
	public static void encodeFile(File encodingFile, File encodedFile) {
		try(FileReader fr = new FileReader(encodingFile)){
			char[] firstFile = new char[(int) encodingFile.length()];
			fr.read(firstFile);
			for(char b:firstFile) {
				System.out.println("加密前的内容："+ b);
				if(b>='0'&&b<='9') {
					if(b == '9')
						b = '0';
					else
						b = (char) (b + 1);
				}
				if(b>='a'&&b<='z'||b>='A'&&b<='Z') {
					if(b=='z'||b=='Z')
						b = (char) (b - 25);
					else
						b = (char) (b + 1);
				}
				System.out.println("加密后的内容："+ b);
			}
			try(FileWriter fw = new FileWriter(encodedFile)){
				fw.write(firstFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
