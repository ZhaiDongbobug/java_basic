package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class WorkingThread1 extends Thread{


	public WorkingThread1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void run() {
		 Item item = new Item();
		 item.name = "铅笔";
		 item.price = 100;
		 String sql = "insert into item values(null,?,?)";
			try (
				// 建立与数据库的Connection连接
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/"
								+ "how2java?characterEncoding=UTF-8", "root", "admin"); 
				PreparedStatement ps = c.prepareStatement(sql)) {
				ps.setString(1, item.name);
				ps.setInt(2, item.price);
	            ps.execute();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
