package multithreading;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class NewMyStack<T>{

	LinkedList<T> list = new LinkedList<T>();	
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	boolean locked = false;
	
	public void push(T t) {
		try {
			locked = lock.tryLock(10, TimeUnit.SECONDS);
			if(locked) {
				while(list.size()>=200) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				condition.signalAll();
				list.addLast(t);
			}
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {			
			if(locked) {
				lock.unlock();
			}
		}
	}

	public T pull() {
		T t = null;
		try {
			locked = lock.tryLock(10, TimeUnit.SECONDS);
			if(locked) {
				while(list.isEmpty()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				condition.signalAll();
				t = list.removeLast();
			}
			
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		} finally {			
			if(locked) {
				lock.unlock();
			}
		}
		return t;			
	}

	public T peek() {
		T t = null;
		try {
			locked = lock.tryLock(10, TimeUnit.SECONDS);
			if(locked) {
				while(list.isEmpty()) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				condition.signalAll();
				t = list.getLast();
			}
			
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		} finally {			
			if(locked) {
				lock.unlock();
			}
		}
		return t;
	}

}
