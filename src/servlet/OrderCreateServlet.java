package servlet;

 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import entity.Order;
import entity.OrderItem;
import entity.User;
 

 
public class OrderCreateServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        User u = (User) request.getSession().getAttribute("user");
        /*
         * 一般在登录是应用 比如登录输入了用户名和密码
             TSecurityUser user = new TSecurityUser();
             user.setUserName('hyw');
             user.setUserPwd('008');
             HttpSession session=request.getSession();
             session.setAttribute("user",user); 
             //把登录的信息存到session里面 这才有了你的那些代码来接受
         */
        if(null==u){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //跳转，response的sendRedirect方法用于地址重定向，
            //request的getContextPath用于绝对地址
            return;
        }
         
        Order o = new Order();
        o.setUser(u);
 
        new OrderDAO().insert(o);
 
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
         
        ois.clear();
         
       // response.setContentType("text/html; charset=UTF-8");
        //将浏览器编码设置为utf-8,解决中文显示出现乱码情况
      
       // response.getWriter().println("订单创建成功");
    	response.setHeader("refresh", "3;url=listProduct");
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("订单创建成功，马上跳转回购物车页面，如果没有跳转，请点击<a href='	listProduct'>这里</a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
}