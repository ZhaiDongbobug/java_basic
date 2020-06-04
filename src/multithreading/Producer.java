package multithreading;

public class Producer extends Thread{
	
	private NewMyStack<Character> stack;
	public Producer(NewMyStack<Character> stack,String name) {
		super(name);
		this.stack = stack;
	}
	

	public void run() {
		while(true) {
			char c = randomUpCase();
			stack.push(c);
			System.out.println(this.getName()+"压入："+c);
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public char randomUpCase() {
		return (char) (Math.random()*('Z'+1-'A')+'A');
	}
	
	
}
