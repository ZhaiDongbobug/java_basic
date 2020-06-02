package multithreading;


import java.util.LinkedList;


public class NewMyStack<T>{

	LinkedList<T> list = new LinkedList<T>();	
	public synchronized void push(T t) {
		while(list.size()>=200) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		list.addLast(t);		
	}

	public synchronized T pull() {
		while(list.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		this.notifyAll();
		return list.removeLast();	
	}

	public T peek() {	
		return list.getLast();
	}

}
