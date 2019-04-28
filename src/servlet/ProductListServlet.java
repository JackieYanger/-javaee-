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
  *  一、response.sendRedirect(url)-服务器将新url发送给游览器，游览器再根据新url请求
            Request.getRequestDispatcher(url).forward(request,response);
         请求转发到指定url（服务器内部跳转url然后将结果发给游览器）
     二、response.sendRedirect(url)--客户端跳转
            Request.getRequestDispatcher(url).forward(request,response)--服务器跳转
     三、response.sendRedirect(url)--跳转到指定url地址后，
     上个页面的请求会结束，request对象会消亡，数据会消亡。
           Request.getRequestDispatcher(url).forward(request,response)--内部跳转，
           request对象一直存在
     四、response.sendRedirect(url)--网址会改变
            Request.getRequestDispatcher(url).forward(request,response)--以游览器角度来看，
          他只是发送一个request然后收到一个response,所以url不变
       五、response.sendRedirect(url)--传参数需要在url后加参数。
        Request.getRequestDispatcher(url).forward(request,response)-
        传参数可以操作request对象方法setAttribute(“name”,value)
       六、response.sendRedirect(url)-可以定位到任意的网址
       Request.getRequestDispatcher(url).forward(request,response)-只能定位到服务器资源
       七、response.sendRedirect(url)--可以重定向有frame的jsp文件
        Resquest.getRequestDispatcher(url).forward(request,response)-
        不可以重定向有frame的jsp文件，可以定向到有frame的html文件，
        只有在客户端没有输出时才可以调用forward方法，如果当前页面缓冲区不是空的，
        那么该句可能不起作用，由于这种提交不会改变url地址，刷新会重复提交。
  */
    }
}