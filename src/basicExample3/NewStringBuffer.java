package basicExample3;

import java.util.ArrayList;

import numberAndString.IStringBuffer;

public class NewStringBuffer implements IStringBuffer{

	public static void main(String[] args) {
		NewStringBuffer nsbf = new NewStringBuffer();
		String str = "asd";
		nsbf.append(str);
		System.out.println(nsbf);
		nsbf.reverse();
		System.out.println(nsbf);
		nsbf.append('8');
		System.out.println(nsbf);
		System.out.println(nsbf.value.size());
		nsbf.insert(2, ",.,");
		System.out.println(nsbf);
		System.out.println(nsbf.value.size());
		nsbf.delete(5);
		System.out.println(nsbf);		
	}
	ArrayList value;
	public NewStringBuffer() {
		value = new ArrayList();
	}
	public NewStringBuffer(String str) {		
		this();
		if(str == null)
			return;
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++) {
			char c = cs[i];
			value.add(c);
		}
	}

	@Override
	public void append(String str) {
		insert(value.size(),str);
	}

	@Override
	public void append(char c) {
		append(String.valueOf(c));
	}

	@Override
	public void insert(int pos, char b) {
		insert(pos,String.valueOf(b));
	}

	@Override
	public void insert(int pos, String str) {
		if(pos<0)
			return;
		if(pos>value.size())
			return;
		if(str == null)
			return;
		char[] cs = str.toCharArray();
		for(int i=0;i<cs.length;i++) {
			char c = cs[i];
			value.add(pos+i, c);	
		}
	}

	@Override
	public void delete(int start) {
		delete(start,value.size());
	}

	@Override
	public void delete(int start, int end) {
		if(start<0)
			return;
		if(start>value.size())
			return;
		if(end<0)
			return;
		if(end>value.size())
			return;
		if(start>=end)
			return;
		for(int i=0;i<end-start;i++) {		
			value.remove(start);
		}
	}
	@Override
	public void reverse() {
		int length = value.size();
		for(int i=0;i<length/2;i++) {
			char temp = (char) value.get(length-i-1);
			value.set(length-i-1, value.get(i));
			value.set(i, temp);
		}
	}
	@Override
	public int length() {
		return value.size();
	}

	public String toString() {
		char[] cs = new char[value.size()];
		for(int i=0;i<value.size();i++) {
			cs[i] = (char) value.get(i);
		}
		return new String(cs);
	}
}
