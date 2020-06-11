package networkProgramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DictionaryDAO {
	public DictionaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8", "root",
				"admin");
	}
	
	public Dictionary getResponse(String receive) {
		Dictionary realdictionary = null;
		String sql = "select * from dictionary where receive = ?";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, receive);
			ResultSet rs = ps.executeQuery();
			List<Dictionary> list = new ArrayList<>();
			while (rs.next()) {
				Dictionary dictionary = new Dictionary();
				int id = rs.getInt(1);
				String response = rs.getString(3);
				dictionary.id = id;
				dictionary.response = response;
				list.add(dictionary);
			}
			realdictionary =  list.get((int)(Math.random()*(list.size()-1)));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return realdictionary;
	}
	
	public Dictionary getReceive(String response) {
		Dictionary dictionary = null;
		try (Connection c = getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from dictionary where response = " + response;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				dictionary = new Dictionary();
				int id = rs.getInt(1);
				String receive = rs.getString(2);
				dictionary.id = id;
				dictionary.receive = receive;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dictionary;
	}
	
	public void add(Dictionary dictionary) {
		String sql = "insert into dictionary values(null,?,?)";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, dictionary.receive);
			ps.setString(2, dictionary.response);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				dictionary.id = id;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
