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
         * һ���ڵ�¼��Ӧ�� �����¼�������û���������
             TSecurityUser user = new TSecurityUser();
             user.setUserName('hyw');
             user.setUserPwd('008');
             HttpSession session=request.getSession();
             session.setAttribute("user",user); 
             //�ѵ�¼����Ϣ�浽session���� ������������Щ����������
         */
        if(null==u){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //��ת��response��sendRedirect�������ڵ�ַ�ض���
            //request��getContextPath���ھ��Ե�ַ
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
        //���������������Ϊutf-8,���������ʾ�����������
      
       // response.getWriter().println("���������ɹ�");
    	response.setHeader("refresh", "3;url=listProduct");
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write("���������ɹ���������ת�ع��ﳵҳ�棬���û����ת������<a href='	listProduct'>����</a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
}