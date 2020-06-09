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

public class TestSocket {

	public static void main(String[] args) throws UnknownHostException {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println(ip);
		String[] strArry = ip.split("\\.");
		System.out.println(strArry.length);
		String str = "";
		for (int i = 0; i < 3; i++) {
			str = str + strArry[i] + ".";
		}
		List<String> list = (List<String>) Collections.synchronizedList(new ArrayList<String>());
		for (int i = 1; i < 256; i++) {
			String strIp = str + i;
			threadPool.execute(new Runnable() {
				public void run() {
					Process p;
					try {
						p = Runtime.getRuntime().exec("ping " + strIp);
						BufferedReader br;
						try {
							br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
							String line = null;
							StringBuilder sb = new StringBuilder();
							while ((line = br.readLine()) != null) {
								if (line.length() != 0)
									sb.append(line + "\r\n");
							}
							String print = sb.toString();
							System.out.println(print);
							String error = "请求超时。";

							if (!print.contains(error)) {
								list.add(strIp);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
			System.out.println("已经完成：" + i + "个ip测试");
		}
		System.out.println("如下ip地址可以连接");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
