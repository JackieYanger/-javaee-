package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class RegisterDAO {
     public void insert(String name,String password,String securecode,String address,String phone) {
    	  try {
              Class.forName("oracle.jdbc.driver.OracleDriver");
   
              Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
               "super", "594SHENG");
              Random ran = new Random();
              int id=ran.nextInt(20)+5;
              String sql = "insert into user_web values(default,?,?,?,?,?)";
   
              PreparedStatement ps = c.prepareStatement(sql);
   
        
              ps.setString(1, name);
              ps.setString(2, password);
              ps.setString(3, securecode);
              ps.setString(4, address);
              ps.setString(5,phone);
             // ps.setString(5, phone);
              ps.execute();
   
          
   
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
     public static void main(String[] args) {
		RegisterDAO r = new RegisterDAO();
		//r.insert(2, "Bob","111" ); ≤‚ ‘Õ®π˝
	}
}
