package numberAndString;

public class upOrDownBox {

	public static void main(String[] args) {
		byte b = 1;
		short s = 2;
		float f = 3.14f;
		double d = 6.18;
		
		//自动装箱
		Byte b1 = b;
		Short s1 = s;
		Float f1 = f;
		Double d1 = d;
		//自动拆箱
		b=b1;
		s=s1;
		f=f1;
		d=d1;
		
		//2.byte和Integer之间能否进行自动拆箱和自动装箱
		Integer i1 = b;//不能把byte自动装箱成Integer
		b = new Integer(1);//不能把Integer自动拆箱成byte
		
		//3. 通过Byte获取byte的最大值
		System.out.println(Byte.MAX_VALUE);
		
	}

}
