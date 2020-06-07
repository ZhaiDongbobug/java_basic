package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

	public static void main(String[] args) {
		total();
		System.out.println("新加一条数据");
		Hero hero1 = new Hero();
		hero1.id = 101;
		hero1.name = "英雄杀";
		hero1.hp = 300;
		hero1.damage = 200;
		add(hero1);
		total();
		System.out.println("取出id=101的数据，它的name是：");
		String sql = "select * from hero where id = " + 101;
		Hero hero = select(sql);
		System.out.println(hero.name);
		System.out.println("把名字改为英雄101，并且更新到数据库");
		hero.name = "英雄101";
		update(hero);
		System.out.println("取出id=101的数据，它的name是：");
		hero = select(sql);
		System.out.println(hero.name);
		System.out.println("删除id=101的数据");
		delete(hero);
		total();
	}

	public static Hero select(String sql) {
		Hero h = new Hero();
		try {
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
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				h.id = rs.getInt(1);
				h.name = rs.getString(2);
				h.hp = rs.getFloat(3);
				h.damage = rs.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

	public static void initDate(Hero h, String sql) {
		try {
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
			ps.setInt(1, h.id);
			ps.setString(2, h.name);
			ps.setFloat(3, h.hp);
			ps.setInt(4, h.damage);
			int count = ps.executeUpdate();
			System.out.println("有" + count + "数据受到影响");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void add(Hero h) {
		String sql = "insert into hero values(?,?,?,?)";
		initDate(h, sql);
	}

	public static void delete(Hero h) {
		String sql = "delete from hero where id = " + h.id;
		try {
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
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void update(Hero h) {
		String sql = "update hero set name=?,hp=?,damage=? where id=?";
		try {
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
			ps.setInt(4, h.id);
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			int count = ps.executeUpdate();
			System.out.println("有" + count + "数据受到影响");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Hero> list() {
		List<Hero> heros = new ArrayList<>();
		String sql = "select * from hero values(?,?,?,?)";
		try {
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
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hero h = new Hero();
				h.id = rs.getInt(1);
				h.name = rs.getString(2);
				h.hp = rs.getFloat(3);
				h.damage = rs.getInt(4);
				heros.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}

	public static void total() {
		String sql = "select count(*) from hero";
		try {
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
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			System.out.println("数据库中总共有" + count + " 条数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
