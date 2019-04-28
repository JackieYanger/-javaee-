package servlet;

 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import entity.Product;
 
 
public class ProductListServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        List<Product> products = new ProductDAO().ListProduct();
 
        request.setAttribute("products", products);
 
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);
 /*
  *  һ��response.sendRedirect(url)-����������url���͸����������������ٸ�����url����
            Request.getRequestDispatcher(url).forward(request,response);
         ����ת����ָ��url���������ڲ���תurlȻ�󽫽��������������
     ����response.sendRedirect(url)--�ͻ�����ת
            Request.getRequestDispatcher(url).forward(request,response)--��������ת
     ����response.sendRedirect(url)--��ת��ָ��url��ַ��
     �ϸ�ҳ�������������request��������������ݻ�������
           Request.getRequestDispatcher(url).forward(request,response)--�ڲ���ת��
           request����һֱ����
     �ġ�response.sendRedirect(url)--��ַ��ı�
            Request.getRequestDispatcher(url).forward(request,response)--���������Ƕ�������
          ��ֻ�Ƿ���һ��requestȻ���յ�һ��response,����url����
       �塢response.sendRedirect(url)--��������Ҫ��url��Ӳ�����
        Request.getRequestDispatcher(url).forward(request,response)-
        ���������Բ���request���󷽷�setAttribute(��name��,value)
       ����response.sendRedirect(url)-���Զ�λ���������ַ
       Request.getRequestDispatcher(url).forward(request,response)-ֻ�ܶ�λ����������Դ
       �ߡ�response.sendRedirect(url)--�����ض�����frame��jsp�ļ�
        Resquest.getRequestDispatcher(url).forward(request,response)-
        �������ض�����frame��jsp�ļ������Զ�����frame��html�ļ���
        ֻ���ڿͻ���û�����ʱ�ſ��Ե���forward�����������ǰҳ�滺�������ǿյģ�
        ��ô�þ���ܲ������ã����������ύ����ı�url��ַ��ˢ�»��ظ��ύ��
  */
    }
}