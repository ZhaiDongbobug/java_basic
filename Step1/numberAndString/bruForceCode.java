package numberAndString;

import java.util.ArrayList;

public class bruForceCode {

	static String code;
	static int index = 0;
	public static void main(String[] args) {
		code = getString(3);
		String recode = "";
		ArrayList<String> strArry = strpool();
		searchRecode(recode,strArry);
	}
	
	private static ArrayList<String> strpool() {
		ArrayList<String> str = new ArrayList<String>();
		for (int i = '0'; i < 'z' + 1; i++) {				
			for (int j = '0'; j < 'z' + 1; j++) {
				for (int k = '0'; k < 'z' + 1; k++) {	
					char[] recode = new char[3];
					recode[0] = (char)i;
					recode[1] = (char)j;
					recode[2] = (char)k;
					StringBuffer sbf = new StringBuffer();
					sbf.append(recode);
					String s = sbf.toString();
					str.add(s);
				}
			}
		}
		return str;
	}
	private static String getStr
	(int index,ArrayList<String> strArry) {	
		return strArry.get(index);
	}
	private static void searchRecode
	(String recode,ArrayList<String> strArry) {
		if(recode.equals(code)) {
			System.out.println("解码成功，密码：" + recode);
		}else {
			recode = getStr(index,strArry);
			index++;
			System.out.println(recode);
			searchRecode(recode,strArry);
		}
			
		
	}

	private static String getString(int length) {
		String pool = "";
		for (int i = '0'; i < '9' + 1; i++) {
			pool += (char) i;
		}
		for (int i = 'A'; i < 'Z' + 1; i++) {
			pool += (char) i;
		}
		for (int i = 'a'; i < 'z' + 1; i++) {
			pool += (char) i;
		}
		char[] cs = new char[length];

		for (int i = 0; i < cs.length; i++) {
			int index = (int) (Math.random() * pool.length());
			cs[i] = pool.charAt(index);
		}
		String result = new String(cs);
		return result;
	}

}
