package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {

		try {
			// Class.forName是把这个类加载到JVM中，
			// 加载的时候，就会执行其中的静态初始化块，
			// 完成驱动的初始化的相关工作。
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (
				// 建立与数据库的Connection连接
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				// Statement是用于执行SQL语句的，比如增加，删除
				Statement s = c.createStatement();) {
			for (int i = 0; i < 100; i++) {
				// 原来在数据库中给字段动态赋值需要以‘“+···+”’的方式来完成
				String sql = "insert into hero values(null," + "'英雄-" + i + "'" + "," + 313.0f + "," + 50 + ")";
				s.execute(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}