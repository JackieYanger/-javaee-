<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,javax.swing.ImageIcon,
    javax.swing.JLabel,javax.swing.JFrame" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
</head>
<style>
div.dark{
      background-color:#11141B;
      width:260px;
}
.fond{
    backgroud-color:grey;
    width:800px;
    height:550px;
}
.option{
  margin-right:15px;
  font-size:10px;
}
div.boldwhite{
   font:"宋体" bold;
   color: #F4F4F4;
   font-style:bold;
   text-align:center;
   font-size:15px;
   margin:10px;
}
.white{
   font:"宋体" bold;
   color: #F4F4F4;
   font-size:10px;
   margin-top:8px;
   margin-bottom:5px;
   margin-left:5px;
}

.floatleft{
    float:left;
}

.gold{
    color:#FF9100;
    font-style:bold;
    font-size:10px;
    text-align:left;
}
div.gold1{
color:#FF9100;
text-align:center;
font-size:20px;
font-style:bold;
}
.tr{
       background-color:#333333;
       width:850px;
       height:582px;
}
</style>
<body>
<div class="tr">
<div style="padding-bottom:20px;padding-right:20px" class="dark floatleft" >
<div style="margin-top:15px"class="boldwhite">参考图片</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>
<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>
<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>
<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>


<div style="border-top-style:dashed; border-color:#666666;border-width:1; margin-

bottom:10px;margin-top: 10px"> </div>
<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>
<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>


<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>

<div style="margin-left:10px" class="white" align="center">
<img src="D:\Documents\Downloads\vivo.jpg">
</div>


</div>

<table  style="background-color:#11141B; margin-right:5px;" class="table1 floatleft">

 <tr>
        
        <td><div class="gold1">id</div></td>
        <td><div class="gold1">名称</div></td>
        <td><div class="gold1">价格</div></td>
        <td><div class="gold1">购买</div></td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr >
            <td ><div class="gold1">${product.id}</div></td>
            <td><div class="gold1">${product.name}</div></td>
            <td><div class="gold1">${product.price}</div></td>
            <td>
             
            <form action="addOrderItem" method="post">
             
            <div class="gold1">数量</div><input type="text" value="1" name="num">
            <input type="hidden" name="pid" value="${product.id}">
            <input type="submit" value="购买">
            </form>
              
        </tr>
    </c:forEach>

</table>
</div>














</body>
