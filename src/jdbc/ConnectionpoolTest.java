package jdbc;

import java.util.ArrayList;
import java.util.List;

public class ConnectionpoolTest {
	private static int threadNumber = 100;
    public static int insertTime = 1;
 
    public static void main(String[] args) {
        traditionalWay();
        connectionPoolWay();
    }

	private static void connectionPoolWay() {
		ConnectionPool cp = new ConnectionPool(10);
		
		System.out.println("开始连接池方式插入数据测试：");
        long start = System.currentTimeMillis();
		List<Thread> list = new ArrayList<>();
		for(int i=0;i<threadNumber;i++) {
			Thread t = new ConnectionpoolWorkingThread(cp);
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
        
        System.out.printf("使用连接池方式，启动%d条线程，"
        		+ "每个线程插入%d条数据，一共耗时%d 毫秒%n",
        		threadNumber,insertTime,end-start);
	}

	private static void traditionalWay() {
		System.out.println("开始传统方式插入数据测试：");
        long start = System.currentTimeMillis();
		List<Thread> list = new ArrayList<>();
		for(int i=0;i<threadNumber;i++) {
			Thread t = new TraditionalWorkingThread();
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
        
        System.out.printf("使用传统方式，启动%d条线程，"
        		+ "每个线程插入%d条数据，一共耗时%d 毫秒%n",
        		threadNumber,insertTime,end-start);
	}
}
