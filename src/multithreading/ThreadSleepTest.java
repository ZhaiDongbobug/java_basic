package multithreading;

public class ThreadSleepTest {

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			public void run() {
				int totalTime = 3;
				while (true) {
					for (int i = 0; i < totalTime; i++) {
						System.out.printf("波动拳第%d发%n", i);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("开始为时5秒的充能");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
	}
}
