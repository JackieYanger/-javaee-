package servlet;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.OrderItem;


 
public class OrderItemDeleteServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int pid = Integer.parseInt(request.getParameter("pid"));
 
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        List<OrderItem> ois4Delete =new ArrayList<>();
        if(null!=ois){
        	for (OrderItem io : ois) {
				if(io.getProduct().getId()==pid){
					ois4Delete.add(io);
				}
			}
        }
        ois.removeAll(ois4Delete);
        //Clear方法和RemoveAll方法的区别是：Clear方法会清空所有元素，
        //RemoveAll方法会清空满足指定条件的元素，当将条件设置为恒成立时，也会删除所有元素。
        response.sendRedirect(request.getContextPath()+"/listOrderItem");
    }
}