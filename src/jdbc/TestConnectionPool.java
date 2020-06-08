package jdbc;


public class TestConnectionPool {

	public static void main(String[] args) {
        long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
            new WorkingThread1().start();
        }
		long end = System.currentTimeMillis();
		System.out.println("传统方式耗费时间："+(end-start)+"毫秒");
		
		start = System.currentTimeMillis();
		ConnectionPool cp = new ConnectionPool(10);
        for (int i = 0; i < 100; i++) {
            new WorkingThread2(cp).start();
        }
        end = System.currentTimeMillis();
        System.out.println("数据库连接池的方式耗费时间："+(end-start)+"毫秒");
    }
}
