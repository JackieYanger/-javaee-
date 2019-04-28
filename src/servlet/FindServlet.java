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
//	        	 response.getWriter().print("�����������벻һ��!(3�����ת��ע��ҳ��)");
	        	response.setHeader("refresh", "3;url=find.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("�����������벻һ�£�3�����ת�ظղŵ�ҳ�棬���û����ת������<a href='find.jsp'>����</a>");
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
		           			response.getWriter().write("��ȫ�����������޴��û���������ת�ظղŵ�ҳ�棬���û����ת������<a href='find.jsp'>����</a>");
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
   			response.getWriter().write("�˺��һسɹ���������ת�ص�¼ҳ�棬���û����ת������<a href='login.jsp'>����</a>");
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
	        
	   

	    }
}
