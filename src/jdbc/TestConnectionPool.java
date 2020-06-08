package jdbc;

import java.util.ArrayList;
import java.util.List;

public class TestConnectionPool {

	public static void main(String[] args) {
		List<Thread> list = new ArrayList<>();
        long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
            Thread t = new WorkingThread1();
            t.start();
            list.add(t);
        }
		for(Thread t:list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("传统方式耗费时间："+(end-start)+"毫秒");
		
		start = System.currentTimeMillis();
		List<Thread> list2 = new ArrayList<>();
		ConnectionPool cp = new ConnectionPool(10);
        for (int i = 0; i < 100; i++) {
            Thread t = new WorkingThread2(cp);
            t.start();
            list2.add(t);
        }
        for(Thread t:list2) {
        	try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        end = System.currentTimeMillis();
        System.out.println("数据库连接池的方式耗费时间："+(end-start)+"毫秒");
    }
}
