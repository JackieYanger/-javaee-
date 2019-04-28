package DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.OrderItem;

 
public class OrderItemDAO {
 
    public static void main(String[] args) {
 
    }
     
    public void insert(OrderItem oi) {
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
                    "super", "594SHENG");
 
            String sql = "insert into orderitem values(default,?,?,?)";
 
            PreparedStatement ps = c.prepareStatement(sql);
 
            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            
            ps.setInt(3,oi.getOrder().getId());
             
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
 
}