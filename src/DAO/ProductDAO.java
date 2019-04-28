package DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
 

 
public class ProductDAO {
 
    public static void main(String[] args) {
 
        System.out.println(new ProductDAO().getProduct(1).getName());
 
    }
 
    public Product getProduct(int id) {
        Product result = null;
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
                    "super", "594SHENG");
 
            String sql = "select * from product where id = ? order by id";
 
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                result = new Product();
                result.setId(id);
                
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                result.setName(name);
                result.setPrice(price);
                result.setInfor(infor);
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
 
    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<Product>();
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@188.131.140.28:1521:orcl",
                    "super", "594SHENG");
 
            String sql = "select * from product order by id";
 
            PreparedStatement ps = c.prepareStatement(sql);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                String infor = rs.getString(4);
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setInfor(infor);
                products.add(product);
 
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
        return products;
    }
}