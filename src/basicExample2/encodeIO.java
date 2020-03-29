package basicExample2;

import java.io.UnsupportedEncodingException;

public class encodeIO {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		byte[] bs = new byte[3];
		bs[0] = (byte) 0xE5;
		bs[1] = (byte) 0xB1;
		bs[2] = (byte) 0x8C;
		String str = new String(bs,"UTF-8");
		System.out.println("E5 B1 8C 对应的字符是："+str);
	}

}
