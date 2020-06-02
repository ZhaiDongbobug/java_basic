package multithreading;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class NewMyStack implements NewStack{

	List<Character> list = (List<Character>) Collections.
	synchronizedList(new LinkedList<Character>());
	
	public void push(Character h) {
		
		list.add(h);
		
	}

	@Override
	public Character pull() {
		return list.remove(list.size() - 1);	
	}

	@Override
	public Character peek() {	
		return list.get(list.size() - 1);
	}

	public int size() {
		return list.size();
	}
}
