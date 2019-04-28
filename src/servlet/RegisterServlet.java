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
	    			response.getWriter().write("�������Ϊ�գ�3�����ת��ע��ҳ�棬���û����ת������<a href='register.jsp'>����</a>");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        	return;
	        }
	        if(!password.equals(ensure_password)) {
//    			 response.setContentType("text/html; charset=UTF-8");
//	        	 response.getWriter().print("�����������벻һ��!(3�����ת��ע��ҳ��)");
	        	response.setHeader("refresh", "3;url=register.jsp");
	    		try {
	    			response.setContentType("text/html; charset=UTF-8");
	    			response.getWriter().write("�����������벻һ�£�3�����ת��ע��ҳ�棬���û����ת������<a href='register.jsp'>����</a>");
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
	    			response.getWriter().write("���ΰ�ȫ�����벻һ�£�3�����ת��ע��ҳ�棬���û����ת������<a href='register.jsp'>����</a>");
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
    			response.getWriter().write("ע��ɹ���������ת�ص�¼ҳ�棬���û����ת������<a href='login.jsp'>����</a>");
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	        
	   

	    }
}
