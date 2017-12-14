<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="/future/css/register.css" />
<script type="text/javascript" src="/future/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
<%
String path = request.getContextPath();
String  basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
var basePath="<%=basePath%>";
var url=basePath+"/login.jsp";
$(function(){
	$("#loginpage").attr("href",url);
});

</script>
<title>用户注册</title>
</head>
<body>
<div class=regdiv>
	<div class="login">
   		<p style="font-size:20pt;color:#6600FF;"> 用户"${user.userName}"注册成功</p>
   		<p style="font-size:20pt"><a id="loginpage" >请点击登录</a></p>
	</div>
</div>     
</body>
</html>