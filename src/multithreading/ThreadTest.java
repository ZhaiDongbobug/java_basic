package multithreading;

import lambda.Hero;

public class ThreadTest {

	public static void main(String[] args) {
		final Hero gareen = new Hero();
		// final Hero b = new Hero();
		// final Hero c = new Hero();

		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					gareen.hurt();

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					gareen.recover();

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}
}
