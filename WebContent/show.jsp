<%@ page contentType="text/html; charset=gbk" %> 
<%@ page import="java.io.*"%> 
<%@ page import="java.sql.*, javax.sql.*" %> 
<%@ page import="java.util.*"%> 
<%@ page import="java.math.*"%> 
<% 
String photo_no = request.getParameter("photo_no"); 
//mysql连接 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 
//String URL=; 
Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/supermarket? characterEncoding=UTF-8","root",
		"594SHENG"); 
//oracle连接 
//String URL="jdbc:oracle:thin@localhost:1521:orcl2"; 
//user="system"; 
//password="manager"; 
//Connection con = DriverManager.getConnection(URL,user,password); 
try{ 
// 准备语句执行对象 
Statement stmt = con.createStatement(); 
String sql = " SELECT * FROM PHOTO WHERE photo_no = "+ photo_no; 
ResultSet rs = stmt.executeQuery(sql); 
if (rs.next()) { 
Blob b = rs.getBlob("photo_image"); 
long size = b.length(); 
//out.print(size); 
byte[] bs = b.getBytes(1, (int)size); 
response.setContentType("image/jpeg"); 
OutputStream outs = response.getOutputStream(); 
outs.write(bs); 
outs.flush(); 
rs.close(); 
} 
else { 
rs.close(); 
response.sendRedirect("./images/error.gif"); 
} 
} 
finally{ 
con.close(); 
} 
%>