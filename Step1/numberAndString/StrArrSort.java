package numberAndString;

public class StrArrSort {

	public static void main(String[] args) {
		String[] strArr = new String[8];
		for(int i=0;i<strArr.length;i++) {
			strArr[i] = getString();
		}
		short cr;
		for(int i=1;i<strArr.length;i++) {
			char chr = strArr[i+1].charAt(0);
			Character.isUpperCase(chr)
			if(strArr[i+1].charAt(0)<strArr[i].charAt(0)) {
				cr = (short) strArr[i+1].charAt(0);				
				String med = strArr[i];
				strArr[i] = strArr[i+1];
				strArr[i+1] = med;
			}
			
		}
		

	}

	private static String getString() {
		char[] cs = new char[5];
		short start = 'A';
		short end = 'z' + 1;
		for (int i = 0; i < cs.length; i++) {
			while (true) {
				char c = (char) (Math.random() * (end - start) + start);
				if (Character.isLetter(c)) {
					cs[i] = c;
					break;
				}
			}
		}
		String result = new String(cs);
		return result;
	}

}
