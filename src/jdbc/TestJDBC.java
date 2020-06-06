package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String sql = "insert into hero values(null," + "'英雄'" + "," + 161.0f + "," + 500 + ")";
//		executeByStatement(sql);
//		long endTime = System.currentTimeMillis();
//		System.out.printf("使用Statement花费时间%d毫秒", endTime - startTime);
//		startTime = System.currentTimeMillis();
//		executeByPreparedStatement(sql);
//		endTime = System.currentTimeMillis();
//		System.out.printf("使用PrepareStatement花费时间%d毫秒", endTime - startTime);
		//list(0,5);
		deleteForwardDate();
	}

	public static void executeByStatement(String sql) {
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

			s.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void executeByPreparedStatement(String sql) {
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
				PreparedStatement ps = c.prepareStatement(sql);) {

			ps.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void list(int start, int count) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement s = c.createStatement();) {

			String sql = "select * from hero limit " + start + "," + count;

			// 执行查询语句，并把结果集返回给ResultSet
//			ResultSet rs = s.executeQuery(sql);
//			while (rs.next()) {
//				int id = rs.getInt("id");// 可以使用字段名
//				String name = rs.getString(2);// 也可以使用字段的顺序
//				float hp = rs.getFloat("hp");
//				int damage = rs.getInt(4);
//				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
//			}
			boolean isQuery = s.execute(sql);
			if(isQuery) {
				ResultSet rs = s.getResultSet();
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString(2);
					float hp = rs.getFloat(3);
					int damage = rs.getInt(4);
					System.out.printf("%d\t%s\t%f\t%d%n",id,name,hp,damage);
				}
			}
			// 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
			// rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteForwardDate() {
		String sql1 = "insert into hero values(null,?,?,?)";
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
				PreparedStatement ps = c.prepareStatement(sql1);) {
			ps.setString(1, "盖伦");
			ps.setFloat(2, 616);
			ps.setInt(3, 100);
			int id = -1;
			ps.execute();
			ResultSet rs1 = ps.getGeneratedKeys();
			if (rs1.next()) {
				id = rs1.getInt(1);
				System.out.println("刚插入的数据id是：" + id);
			}
			for (int i = id - 1; i > 0; i--) {
				int targetId = i;
				ResultSet rs2 = ps.executeQuery("select id from hero where id = " + targetId);
				if (rs2.next()) {
					System.out.println("id=" + targetId + "的数据存在，删除该数据");
					String deleteSql = "delete from hero where id = " + targetId;
					ps.execute(deleteSql);
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
