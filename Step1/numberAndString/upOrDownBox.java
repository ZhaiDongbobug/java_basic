package numberAndString;

public class upOrDownBox {

	public static void main(String[] args) {
		byte b = 12;
		Byte B = b;
		b = B;
		
		short s = 63;
		Short S = s;
		s = S;
		
		float f = 2^16-1;
		Float F = f;
		f = F;
		
		double d = 2^32-1;
		Double D = d;
		d = D;
		
		Integer I = (int) b;
		int i = 16;
		B = (byte) i;
		
		b = B.MAX_VALUE;
		
	}

}
