<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<!DOCTYPE html>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
注册页面
</title>
<style>
div.yidong{
    margin:auto;
    width:700px;
    height:600px;
    padding:20px
}
.red{
    color:red;
    font-size:12px;
    font-family:"宋体";
}
div.background{
       width:586px;
       heigth:480px;
       border:2px solid lightblue;
       
}
span.titles{
       background-color:lightblue;
       width:610px;
       heigth:45px;
       font-size:14px;
       font-weight:bold;
       color:steelblue; 
       padding-right:463px;
       padding-left:5px
}
.titles_2{
       background-color:lightblue;
       width:590px;
       heigth:50px;
       font-size:13px;
       color:steelblue; 
       font-weight:normal;
       padding-right:275px
}
.normal{
       font-size:12px;
       font-family:"微软雅黑";       
       
}
td.greyback{
      background-color:whitesmoke;
      width:300px;
}
 .ps{
      font-size:12px;
      letter-spacing:1px;
}


</style>
<script>
function checkpsd1(){    
	psd1=form1.yourpass.value;  
	var flagZM=false ;
	var flagSZ=false ; 
	var flagQT=false ;
	if(psd1.length<6 || psd1.length>12){   
		divpassword1.innerHTML='<font class="tips_false">长度错误</font>';
	}else
		{   
		  for(i=0;i < psd1.length;i++)   
			{    
				if((psd1.charAt(i) >= 'A' && psd1.charAt(i)<='Z') || (psd1.charAt(i)>='a' && psd1.charAt(i)<='z')) 
				{   
					flagZM=true;
				}
				else if(psd1.charAt(i)>='0' && psd1.charAt(i)<='9')    
				{ 
					flagSZ=true;
				}else    
				{ 
					flagQT=true;
				}   
			}   
			if(!flagZM||!flagSZ||flagQT){
			divpassword1.innerHTML='<font class="tips_false">密码必须是字母数字的组合</font>'; 
			 
			}else{
				
			divpassword1.innerHTML='<font class="tips_true">输入正确</font>';
			 
			}  
		 
		}	
}
//验证确认密码 
function checkpsd2(){ 
		if(form1.yourpass.value!=form1.yourpass2.value) { 
		     divpassword2.innerHTML='<font class="tips_false">您两次输入的密码不一样</font>';
		} else { 
		     divpassword2.innerHTML='<font class="tips_true">输入正确</font>';
		}
}
function checkmail(){
	apos=form1.youremail.value.indexOf("@");
	dotpos=form1.youremail.value.lastIndexOf(".");
	if (apos<1||dotpos-apos<2) 
	  {
	  	divmail.innerHTML='<font class="tips_false">输入错误</font>' ;
	  }
	else {
		divmail.innerHTML='<font class="tips_true">输入正确</font>' ;
	}
}
</script>
<body>
<form action="register" method="post" >

<div class="yidong">
<div class="ps red">请注意：带有“*”的项目必须填写</div>
<div class="background">
<div >
<span class="titles">请填写您的用户名:</span>
</div>
<table style="margin-top:20px;margin-left:5px">
<tr class="normal">
<td><a style="color:red">*</a>通行证用户名：</td>
<td><span><input style="background-color:ghostwhite ; color:lightgray" type="text"   name="name" onfocus="if(value=='请输入用户名') value='' "onblur="if(value=='') value='请输入用户名'"></span>
<br><a style="color:blue" href="#">查看用户名是否被占用</a></td>
<td class="greyback">用户名由a~z的英文字母(不区分大小写)，0~9的<strong>数字</strong>、<strong>点</strong>、<strong>减号</strong>或<strong>下划线</strong>组成，长度为3~18个字符，只能以数字或者字母开头和结尾，例如:kyzy_001.</td>
</tr>
</table>
<div style="border-top-style:solid; border-color:lightblue;border-width:1; margin-bottom:5px;margin-top: 30px"> </div>
<div class="background">
<span class="titles_2"><a style="font-size:14px;font-weight:bold;">请填写安全设置:</a>(安全设置用于验证账号和找回密码)</span>
</div>
<span class="red">以下信息对保证您账号的安全极为重要，请您务必认真填写</span>
<table style="margin-top:20px;margin-left:5px">
<tr class="normal">
<td><a style="color:red">*</a>输入登录密码：<br>
          <a style="color:red">*</a>登录密码确认：
</td>
<td><span><input style="background-color:ghostwhite ; color:lightgray" type="password"  name="password"  onBlur="checkpsd1()"></span>
<br><span><input style="background-color:ghostwhite ; color:lightgray" type="password"  name="ensurepassword"   onBlur="checkpsd2()"></span></td>
<td class="greyback">密码长度为6~16位，区分字母大小写，登录密码可以由字母、数字、字符组成。<a style="color:blue" href="#">更多说明</a></td>
</tr>
</table>
<div style="border-top-style:solid; border-color:lightblue;border-width:1; margin-bottom:10px;margin-top: 10px"> </div>
<table style="margin-top:20px;margin-left:5px">
<tr class="normal">
<td><a style="color:red">*</a>收货地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
          <a style="color:red">*</a>联系电话：
</td>
<td><span><input style="background-color:ghostwhite ; color:lightgray" type="text" name="address"></span>
<br><span><input style="background-color:ghostwhite ; color:lightgray" type="text" name="phone"></span></td>
<td class="greyback">用于为您配送所购物品。<strong>（我们将保证您的个人信息安全）</strong>电话号码格式，例如：+8615661251509<a style="color:blue" href="#">更多说明</a></td>
</tr>
</table>
<div style="border-top-style:solid; border-color:lightblue;border-width:1; margin-bottom:10px;margin-top: 10px"> </div>
<table style="margin-top:20px;margin-left:5px">
<tr class="normal">
<td><a style="color:red">*</a><a style="padding-right:12px">输入安全码：</a><br>
          <a style="color:red">*</a><a style="padding-right:12px">确认安全码：</a>
</td>
<td><span><input style="background-color:ghostwhite ; color:lightgray" type="text" name="securecode" onBlur="checkmail()"></span>
<br><span><input style="background-color:ghostwhite ; color:lightgray" type="text" name="ensuresecurecode" onBlur="checkmail()"></span>
</td>
<td class="greyback">安全码是您找回密码的重要途径，请认真填写.<a style="color:red">特别提醒，安全码一旦设定，将不可自行修改.</a><a style="color:blue" href="#">更多说明</a></td>
</tr>
</table>
<div style="border-top-style:solid; border-color:lightblue;border-width:1; margin-bottom:10px;margin-top: 10px"> </div>
 <center></span><input style="margin:10px;" type="submit" value="提交注册">
                    <a href="login.jsp">已有账号？点击返回</a>
 </center>
</div>
</div>




</form>
</body>