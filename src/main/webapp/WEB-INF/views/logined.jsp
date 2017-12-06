<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="/future/css/login.css"/>
<script type="text/javascript">
var userName=<%=session.getAttribute("userName")%>;
if(null != userName)
{
	$(function(){
		$("#user_login").text("已登录:"+userName);
	});

}
</script>
<title>用户登录</title>
</head>
<body>
<div class="main">
  <div>
		<input id="user_login" type="text"/>
  </div>
  <div class="face"></div>
  <div class="login">
        <form method="post" action="<c:url value="/user/login.html"/>">
        <p>
          <input type="text" name="userName" required type="text" min="6" max="30" />
          <label alt="请输入用户名" placeholder="用户名"></label>
        </p>
        <p>
          <input type="password" name="uesrPasswd" required />
          <label alt="请输入密码" placeholder="密码"></label>
        </p>
        <div class="regbutton">
          <button  class="btn" type="submit">登录</button>
          <button  class="btn" onClick="location.href='/future/register.jsp'">注册</button>        
        </div>  
        </form> 
   </div>

    <ul class="square">
      <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    </ul>
   </div> 
  
</body>
</html>