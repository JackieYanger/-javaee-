package servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FindDAO;
import entity.User;

public class FindServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	 protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        String code = request.getParameter("securecode");
	        String password = request.getParameter("code");
	        String ensure_password = request.getParameter("ensurecode");
	        
	        if(!password.equals(ensure_password)) {
//   			 response.setContentType("text/html; charset=UTF-8");
//	        	 response.getWriter().print("两次输入密码不一致!(3秒后跳转至注册页面)");
	        	response.setHeader("refresh", "3;url=find.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("两次密码输入不一致，3秒后跳转回刚才的页面，如果没有跳转，请点击<a href='find.jsp'>这里</a>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	 	  	        	 return ;
	        }
	        FindDAO fd = new FindDAO();
	        User user;
			try {
				user = fd.find(code,password);
				   if(user==null) {
		        	    response.setHeader("refresh", "3;url=find.jsp");
		           		try {
		           			response.setContentType("text/html; charset=UTF-8");
		           			response.getWriter().write("安全码输入错误或无此用户，马上跳转回刚才的页面，如果没有跳转，请点击<a href='find.jsp'>这里</a>");
		           		} catch (IOException e) {
		           			// TODO Auto-generated catch block
		           			e.printStackTrace();
		           		}
		           		return ;
		         }
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	        response.setHeader("refresh", "3;url=login.jsp");
   		try {
   			response.setContentType("text/html; charset=UTF-8");
   			response.getWriter().write("账号找回成功，马上跳转回登录页面，如果没有跳转，请点击<a href='login.jsp'>这里</a>");
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
	        
	   

	    }
}
