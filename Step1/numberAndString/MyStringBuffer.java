package numberAndString;

public class MyStringBuffer implements IStringBuffer{

	int capacity = 16;
	int length = 0;
	char[] value;
	
	public MyStringBuffer() {
		value = new char[capacity];
	}
	public MyStringBuffer(String str) {
		this();
		if(null == str) {
			return;
		}	
		if(capacity<str.length()) {
			capacity = value.length*2;
			value = new char[capacity];
		}
		if(capacity>=str.length())
			System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
		length = str.length();
	}
	public void append(String str) {
		if(null != str) {
			char[] newValue = str.toCharArray();
			if(capacity-length < newValue.length) {
				capacity += newValue.length*2;
			}
			System.arraycopy(newValue, 0, value, 0, newValue.length);
			length = value.length;
		}	
	}
	@Override
	public void append(char c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(int pos, char b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insert(int pos, String b) {
		if(pos<0)
			return;
		if(b == null)
			return;
		if(b.length()>(capacity-length)) {
			capacity += b.length()*2;
			char[] value = new char[capacity];
		}
		if(pos<length) {
			for(int i=0;i<length-pos;i++) {
				char temp = value[length-1-i];
				value[length-1-i] = value[b.length()+length-1-i];
				value[b.length()+length-1-i] = temp;
			}
		}
		System.arraycopy(b.toCharArray(),0, value, pos, b.toCharArray().length);
		length += b.length(); 
	}
	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int start, int end) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reverse() {
		for(int i=0;i<length/2;i++) {
			char temp = value[i];
			value[i] = value[length-i-1];
			value[length-i-1] = temp;
		}
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		char[] realValue = new char[length];
		System.arraycopy(value, 0, realValue, 0, length);
		return new String(realValue);
	}
	
	public static void main(String[] args) {
		MyStringBuffer sb = new MyStringBuffer("there light");
		sb.insert(12, "000");
		System.out.println(sb);
	}
}
