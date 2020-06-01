package multithreading;

import lambda.Hero;

public class ThreadTest {

	public static void main(String[] args) {
		final Hero gareen = new Hero("gareen");
		// final Hero b = new Hero();
		// final Hero c = new Hero();

		//减血线程t1,t2,t3,t4,t5
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
		t2.start();
		Thread t3 = new Thread() {
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
		t3.start();
		Thread t4 = new Thread() {
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
		t4.start();
		Thread t5 = new Thread() {
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
		t5.start();
		//加血线程2条t6,t7
		Thread t6 = new Thread() {
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
		t6.start();
		Thread t7 = new Thread() {
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
		t7.start();
	}
}
