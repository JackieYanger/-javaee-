package servlet;


import java.io.IOException;
 
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        String name = request.getParameter("name");
	        String password = request.getParameter("password");
	        String ensure_password = request.getParameter("ensurepassword");
	        String secure_code = request.getParameter("securecode");
	        String ensure_secure_code = request.getParameter("ensuresecurecode");
	        String address = request.getParameter("address");
	        String phone = request.getParameter("phone");
	        if(name==""||password==""||ensure_password==""||secure_code==""||ensure_secure_code=="") {
	        	response.setHeader("refresh", "3;url=register.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("必填项不能为空！3秒后跳转回注册页面，如果没有跳转，请点击<a href='register.jsp'>这里</a>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        	return;
	        }
	        if(!password.equals(ensure_password)) {
//    			 response.setContentType("text/html; charset=UTF-8");
//	        	 response.getWriter().print("两次输入密码不一致!(3秒后跳转至注册页面)");
	        	response.setHeader("refresh", "3;url=register.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("两次密码输入不一致，3秒后跳转回注册页面，如果没有跳转，请点击<a href='register.jsp'>这里</a>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	 	  	        	 return ;
	        }
	        if(!secure_code.equals(ensure_secure_code)) {
	        	response.setHeader("refresh", "3;url=register.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("两次安全码输入不一致，3秒后跳转回注册页面，如果没有跳转，请点击<a href='register.jsp'>这里</a>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        	return;
	        }
	        RegisterDAO user = new RegisterDAO();
	        user.insert(name, password,secure_code,address,phone);
	        System.out.println("ddd");
	        response.setHeader("refresh", "3;url=login.jsp");
    		try {
    			response.setContentType("text/html; charset=UTF-8");
    			response.getWriter().write("注册成功，马上跳转回登录页面，如果没有跳转，请点击<a href='login.jsp'>这里</a>");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	        
	   

	    }
}
