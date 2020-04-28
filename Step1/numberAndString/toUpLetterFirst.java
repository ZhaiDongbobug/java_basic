package numberAndString;

public class toUpLetterFirst {

	public static void main(String[] args) {
		String sentence = "let there be light";
		System.out.println(sentence);
		String[] words = sentence.split(" ");
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			char upperCaseFirstWord = Character.toUpperCase(word.charAt(0));
			String rest = word.substring(1);
			String capitalizedWord = upperCaseFirstWord + rest;
			words[i] = capitalizedWord;
		}
		String result = "";
		for(String word:words) {
			result+=word+' ';
		}
		result = result.trim();
		System.out.println(result);
	}

}
