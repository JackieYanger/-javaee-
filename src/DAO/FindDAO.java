package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class FindDAO {
	 public User find(String securecode,String password) throws ClassNotFoundException, SQLException {
		 User fs = null;
   	
   		     
             Class.forName("oracle.jdbc.driver.OracleDriver");
  
             Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
              "super", "594SHENG");
  
             String sql = "update user_web set  password =? where code = " +"'"+securecode+"'";
  
             PreparedStatement ps = c.prepareStatement(sql);
  
             
             ps.setString(1,password);
             //ps.setString(2, password);
    		  ps.execute();		
    		  
    		  String sql2 = "select name,password from user_web where code = " +"'"+securecode+"'";
    		  PreparedStatement ps2 = c.prepareStatement(sql2);
    		  ResultSet rs = ps2.executeQuery(sql2);		
    		 if(rs.next()) {
    			 fs = new User();
    			 fs.setName(rs.getString(1));
    			 fs.setPassword(rs.getString(2));   			 
    		 }
    	                
             ps.close(); 
             c.close();   
   	  return fs;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		 
//    	FindDAO fs = new FindDAO();
//    	User u = fs.find("JKL8","123");
//    	if(u==null) {
//    		System.out.println("null");
//    		return;
//    	}
//    	System.out.println(u.getName()+" "+u.getPassword());  //≤‚ ‘Õ®π˝
	}
}
