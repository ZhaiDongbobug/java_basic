package multithreading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lambda.Hero;

public class MyStack implements Stack {

	LinkedList<Hero> heros = new LinkedList<Hero>();
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void push(Hero h) {
		try {
			lock.lock();
			heros.addLast(h);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Hero pull() {
		try {
			lock.lock();
			return heros.removeLast();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Hero peek() {
		return heros.getLast();
	}

}
