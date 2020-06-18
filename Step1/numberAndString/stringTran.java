package numberAndString;

public class stringTran {

	public static void main(String[] args) {
		float f = 3.14f;
		//String str = String.valueOf(f);
		Float F = f;
		String str = F.toString();
		float f1 = Float.parseFloat(str);
		String str1 = new String("3.1a4");
		float f2 = Float.parseFloat(str1);
		System.out.println(f2);//不合法，抛出异常，应该输入数字
		Float.parseFloat("3.1a4");//如果字符串内容不是合法的数字表达，
		//那么转换就会报错(抛出异常)
	}

}
