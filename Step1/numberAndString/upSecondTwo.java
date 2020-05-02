package numberAndString;

public class upSecondTwo {

	public static void main(String[] args) {
		String sentence = "Nature has given us that two ears, "
				+ "two eyes, and but one tongue, to the "
				+ "end that we should hear and see more "
				+ "than we speak";
		int index = sentence.lastIndexOf(" two ");
		char[] senArry = sentence.toCharArray();
		senArry[index + 1] = Character.toUpperCase(senArry[index+1]);
		String result = new String(senArry);
		System.out.println(result);
	}
}
