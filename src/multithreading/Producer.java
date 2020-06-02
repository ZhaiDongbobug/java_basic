package multithreading;

public class Producer{

	char[] pool;
	NewMyStack stack;
	public Producer(NewMyStack stack) {		
		int index = 0;
		pool = new char[26];
		for(short i='A';i<'Z';i++) {
			char c = (char) i;
			pool[index] = c;
			index++;
		}
		this.stack = stack;
	}
	
	public synchronized char randomUpCaseToStack() {		
		while(stack.size() == 200) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		char randomUpCase = pool[(int) (Math.random()*25)];
		stack.push(randomUpCase);
		this.notifyAll();
		return randomUpCase;		
	}
	
	
	
}
