package multithreading;


import lambda.Hero;

public class ThreadTest {

	public static void main(String[] args) {
		final Hero a = new Hero();
		final Hero b = new Hero();
		final Hero c = new Hero();

		Thread t1 = new Thread() {
			public void run() {
				// 占有对象a
				synchronized (a) {
					System.out.println("t1 已占有九尾妖狐");
					try {
						// 停顿1000毫秒，另一个线程有足够的时间占有安妮
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("t1 试图占有对象b");
					System.out.println("t1 等待中 。。。。");
					synchronized (b) {
						System.out.println("do something");
					}
				}

			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				// 占有对象b
				synchronized (b) {
					System.out.println("t2 已占有对象b");
					try {

						// 停顿1000毫秒，另一个线程有足够的时间占有暂用九尾妖狐
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2 试图占有对象c");
					System.out.println("t2 等待中 。。。。");
					synchronized (c) {
						System.out.println("do something");
					}
				}

			}
		};
		t2.start();
		Thread t3 = new Thread() {
			public void run() {
				// 占有对象b
				synchronized (c) {
					System.out.println("t2 已占有对象c");
					try {

						// 停顿1000毫秒，另一个线程有足够的时间占有暂用九尾妖狐
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2 试图占有对象a");
					System.out.println("t2 等待中 。。。。");
					synchronized (a) {
						System.out.println("do something");
					}
				}

			}
		};
		t3.start();
	}
}
