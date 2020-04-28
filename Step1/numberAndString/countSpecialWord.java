package numberAndString;

public class countSpecialWord {

	public static void main(String[] args) {
		String sentence = "peter piper picked a "
				+ "peck of pickled peppers";
		int count = 0;
		String[] words = sentence.split(" ");
		for(String word:words) {
			if(word.charAt(0) == 'p') {
				count++;
			}
		}
		System.out.printf("此绕口令中以p开头的单词有%d个",count);
	}

}
