package numberAndString;

public class MyStringBuffer implements IStringBuffer{

	int capacity = 16;
	int length = 0;
	char[] value;
	public MyStringBuffer() {
		value = new char[capacity];
	}
	public MyStringBuffer(String str) {
		if(null != str) {
			value = str.toCharArray();
		}
		length = value.length;
		if(capacity<value.length) {
			capacity = value.length*2;
		}
	}
	public void append(String str) {
		if(null != str) {
			char[] newValue = str.toCharArray();
			if(capacity<newValue.length) {
				capacity = newValue.length*2;
			}
			length = newValue.length;
			System.arraycopy(newValue, 0, value, 0, length);
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
		// TODO Auto-generated method stub
		
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
		char temp;
		for(int i=0;i<length;i++) {
			temp = value[i];
			value[i] = value[length-i-1];
			value[length-i-1] = temp;
		}
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
}
