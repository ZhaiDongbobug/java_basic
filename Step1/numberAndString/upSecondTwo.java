package numberAndString;

public class upSecondTwo {

	public static void main(String[] args) {
		int count = 0;
		String sentence = "Nature has given us that two ears, "
				+ "two eyes, and but one tongue, to the "
				+ "end that we should hear and see more "
				+ "than we speak";
		String[] words = sentence.split(" ");
		for(int i=0;i<words.length;i++) {
			if("two".equals(words[i])) {
				count++;
				System.out.println(count);
			}
			if(count == 2) {
				words[i] = "Two";
				System.out.println(words[i]);
				break;			
			}
		}
		String result = "";
		for(String word:words) {
			word += " ";
			result += word;
		}
		result.trim();
		System.out.println(result);
	}

}
