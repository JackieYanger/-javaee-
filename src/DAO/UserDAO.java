package DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
 

 
public class UserDAO {
 
    public static void main(String[] args) {
 
        System.out.println(new UserDAO().getUser("Tom", "111").getId());
 
    }
 
    public User getUser(String name, String password) {
        User result = null;
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
             "super", "594SHENG");
 
            String sql = "select * from user_web where name = ? and password = ?";
 
            PreparedStatement ps = c.prepareStatement(sql);
 
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()){
                result = new User();
                result.setId(rs.getInt(1));
                result.setPassword(password);
                result.setName(name);
            }
 
            ps.close();
 
            c.close();
 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}