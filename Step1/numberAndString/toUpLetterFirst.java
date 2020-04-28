package numberAndString;

public class toUpLetterFirst {

	public static void main(String[] args) {
		String sentence = "let there be light";
		String[] word = sentence.split(" ");
		for(String w:word) {
			char m = Character.toUpperCase(w.charAt(0));
			w.replace(w.charAt(0), m);
			w = w + " ";
		}
		String str = new String(word);
		System.out.println(word.toString());
		

	}

}
