package DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Order;
 

 
public class OrderDAO {
   public static int select() throws ClassNotFoundException, SQLException {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    int index=0;
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
                "super", "594SHENG");
        String sql = "select id from order_";
        
		PreparedStatement getinsql = c.prepareStatement(sql);
		ResultSet rs = getinsql.executeQuery(sql);
		while(rs.next()){
//			System.out.println(rs.getInt("id"));
			index++;
		}	
		return index;
   }
    public void insert(Order o) {
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "super", "594SHENG");
 
            String sql = "insert into order_ values(default,?) ";
            
       //     PreparedStatement ps = c.prepareStatement(sql);
 
         
            PreparedStatement ps = c.prepareStatement(sql);
         
            ps.setInt(1, o.getUser().getId());
            ps.executeUpdate();
         
         
                o.setId(select());
            
 
            ps.close();
 
            c.close();
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	select();
}
}