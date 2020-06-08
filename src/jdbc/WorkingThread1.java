package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class WorkingThread1 extends Thread{


	public WorkingThread1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public void run() {
			try (
				// 建立与数据库的Connection连接
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/"
								+ "how2java?characterEncoding=UTF-8", "root", "admin"); 
				Statement st = c.createStatement()) {
				String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
                st.execute(sql);
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
