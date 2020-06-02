package multithreading;


public class ThreadTest {

	public static void main(String[] args) {
		NewMyStack stack = new NewMyStack();
		final Producer producer = new Producer(stack);
		final Consumer consumer = new Consumer(stack); 

		Thread producer1 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("producer1 压入：" 
				+ producer.randomUpCaseToStack());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		producer1.start();
		Thread producer2 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("producer2 压入：" 
				+ producer.randomUpCaseToStack());

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		producer2.start();
		Thread consumer1 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("consumer1 弹出：" 
				+ consumer.pullCharacter());

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		consumer1.start();
		Thread consumer2 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("consumer2 弹出：" 
				+ consumer.pullCharacter());

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		consumer2.start();
		Thread consumer3 = new Thread() {
			public void run() {
				while (true) {
					System.out.println("consumer3 弹出：" 
				+ consumer.pullCharacter());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		consumer3.start();
	}
}
