package numberAndString;

public class intervalUpLowMode {

	public static void main(String[] args) {
		String sentence = "lengendary";
		System.out.println(sentence);
		char[] ch = sentence.toCharArray();
		for(int i=0;i<ch.length;i++) {
			char c = ch[i];
			if(i%2==0) {
				ch[i] = Character.toUpperCase(c);
			}
		}
		String newSentence = new String(ch);
		System.out.println(newSentence);
	}

}
