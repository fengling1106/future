<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<title>登录成功</title>
</head>
<body>
<div class="main">
<div class="vote">
      <p style="font-size:22pt; color:#6600FF; margin-left:auto;margin-right:auto;" >用户“${user.userName}”登录成功</p>
      <p style="font-size:22pt; color:#6600FF; margin-left:auto;margin-right:auto;" >请选择业委会组建方式：</p>
      <p style="height:50px"/>
<div class="content"> 
 <form method="post" action="<c:url value="/user/vote.html"/>">
  		<div class="item"><input type="radio" name="voteResult" value="addorg" checked/>
  		<label style="vertical-align:middle;height:60px;font-size:24pt;color:red">1、增选业委会成员</label></div>  	
  		<div class="item"><input type="radio" name="voteResult" value="reorg"/>
  		<label style="vertical-align:middle;height:60px;font-size:24pt;color:yellow">2、重新组建业委会</label></div>
  		<div class="item"><input type="radio" name="voteResult" value="noorg">
  		<label style="vertical-align:middle;height:60px;font-size:24pt;color:blue">3、不需要业委会</label></div>	
	  	<div class="item"><button type="submit" class="btn2">请提交</button></div>
  </form> 
</div> 
 </div>    
 </div>      
</body>
</html>