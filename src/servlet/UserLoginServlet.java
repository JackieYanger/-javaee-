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
//            response.getWriter().print("���������������������");
        	response.setHeader("refresh", "3;url=login.jsp");
    		try {
    			response.setContentType("text/html; charset=UTF-8");
    			response.getWriter().write("�˺Ż������������3�����ת�ص�¼ҳ�棬���û����ת������<a href='login.jsp'>����</a>");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
         }

    }
}
