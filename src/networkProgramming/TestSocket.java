package networkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSocket {

	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println(ip);
		String ipRange = ip.substring(0, ip.lastIndexOf("."));
		System.out.println("网段是:" + ipRange);
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		AtomicInteger number = new AtomicInteger();
		for (int i = 1; i < 256; i++) {
			String strIp = ipRange + "." + i;
			threadPool.execute(new Runnable() {
				public void run() {
					boolean reachable = isReachable(strIp);
					if (reachable) {
						list.add(strIp);
					}
					synchronized (number) {
						System.out.println("已经完成：" + number.incrementAndGet() + "个ip测试");
					}

				}
			});
		}
		threadPool.shutdown();
		if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
			System.out.println("如下ip地址可以连接");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

	}

	private static boolean isReachable(String strIp) {
		boolean reachable = false;
		try {
			Process p = Runtime.getRuntime().exec("ping -n 1 " + strIp);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				if (line.length() != 0)
					sb.append(line + "\r\n");
			}
			// System.out.println(sb.toString());
			reachable = sb.toString().contains("TTL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reachable;
	}
}
