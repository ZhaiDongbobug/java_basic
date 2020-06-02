package multithreading;

public class Consumer extends Thread{

	NewMyStack<Character> stack;
	public Consumer(NewMyStack<Character> stack,String name) {
		super(name);
		this.stack = stack;
	}
	public void run() {
		while(true) {
			char c = stack.peek();
			System.out.println(this.getName()+"弹出："+c);
			stack.pull();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	
