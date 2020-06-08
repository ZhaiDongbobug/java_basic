package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class WorkingThread2 extends Thread {
    private ConnectionPool cp;
   
    public WorkingThread2(ConnectionPool cp) {
        this.cp = cp;
    }
   
    public void run() {
        Connection c = cp.getConnection();
        Item item = new Item();
	    item.name = "钢笔";
	    item.price = 200; 
	    String sql = "insert into item values(null,?,?)"; 
        try (PreparedStatement ps = c.prepareStatement(sql)){
        	
        	ps.setString(1, item.name);
			ps.setInt(2, item.price);
            ps.execute();
   
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
