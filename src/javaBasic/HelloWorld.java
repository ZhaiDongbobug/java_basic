package javaBasic;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		boolean b = !(i++ == 3) ^ (i++ ==2) && (i++==3);
		//异或^ 不同返回真，相同返回假
		//长路与&和短路与&& 都为真时，才为真 任意为假，就为假
		//长路与& 两侧，都会被运算
		//短路与&& 只要第一个是false，第二个就不进行运算了
		//i++是先取值再运算的！！！
		System.out.println(b);
		System.out.println(i);
	}

}
