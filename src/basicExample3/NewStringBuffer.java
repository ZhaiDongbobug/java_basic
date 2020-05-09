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
		System.out.println(nsbf.length);
		nsbf.insert(2, ",.,");
		System.out.println(nsbf);
		System.out.println(nsbf.length);
		nsbf.delete(5);
		System.out.println(nsbf);		
	}
	int length = 0;
	ArrayList<Character> arl = new ArrayList<Character>();
	public NewStringBuffer() {

	}
	public NewStringBuffer(String str) {		
		for(int i=0;i<str.length();i++) {
			arl.add(0,str.charAt(i));
		}
		length = arl.size();
	}

	@Override
	public void append(String str) {
		insert(length,str);
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
		if(pos>length)
			return;
		if(str == null)
			return;
		for(int i=0;i<str.length();i++) {
			arl.add(pos+i, str.charAt(i));	
		}
		length = arl.size();
	}

	@Override
	public void delete(int start) {
		delete(start,length);
	}

	@Override
	public void delete(int start, int end) {
		if(start<0)
			return;
		if(start>length)
			return;
		if(end<0)
			return;
		if(end>length)
			return;
		if(start>end)
			return;
		int count = end-start;
		while(count>0) {		
			arl.remove(start);
			count--;
		}
		length -= end-start; 
	}

	@Override
	public void reverse() {
		if(arl == null)
			return;
		ArrayList<Character> arl2 = new ArrayList<Character>();
		for(int i=arl.size()-1;i>=0;i--) {
			arl2.add(length-i-1, arl.get(i));
		}
		arl = arl2;
	}
	@Override
	public int length() {
		return length;
	}

	public String toString() {
		String result = "";
		for(int i=0;i<length;i++) {
			result += Character.toString((char)arl.get(i));
		}
		return result;
	}
}
