package multithreading;


public class ThreadTest {

	public static void main(String[] args) {
		NewMyStack<Character> stack = new NewMyStack<>();
		new Producer(stack,"producer1").start();
		new Producer(stack,"producer2").start();
		new Consumer(stack,"consumer1").start();
		new Consumer(stack,"consumer2").start();
		new Consumer(stack,"consumer3").start();
	}
}
