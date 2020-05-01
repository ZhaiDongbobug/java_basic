package numberAndString;

public class endWordToUp {

	public static void main(String[] args) {
		String sentence = "lengendary";
		int endIndex = sentence.length();
		char c = Character.
				toUpperCase(sentence.charAt
						(endIndex-1));
		String rest = sentence.substring(0, endIndex-2);
		String result = rest + c;
		System.out.println(result);
	}
}
