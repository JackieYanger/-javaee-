package servlet;

 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import entity.User;
 

 
public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDAO().getUser(name, password);
        
        
        if (null != user) {
        	 request.getSession().setAttribute("user", user);
             response.sendRedirect(request.getContextPath()+"/listProduct");
        	 
                    
        } 
        else {
			//response.sendRedirect(request.getContextPath()+"/login.jsp");
//            response.getWriter().print("密码输入错误，请重新输入");
        	response.setHeader("refresh", "3;url=login.jsp");
    		try {
    			response.setContentType("text/html; charset=UTF-8");
    			response.getWriter().write("账号或密码输入错误，3秒后跳转回登录页面，如果没有跳转，请点击<a href='login.jsp'>这里</a>");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
         }

    }
}
