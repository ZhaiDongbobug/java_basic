package multithreading;

public class Consumer {

	NewMyStack stack = new NewMyStack();
	public Consumer(NewMyStack stack) {
		this.stack = stack;
	}
	public synchronized Character pullCharacter() {
		while(stack.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		char character = (char) stack.peek();
		stack.pull();
		this.notifyAll();
		return character;
	}
}
	
