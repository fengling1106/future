<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<title>投票失败</title>
</head>
<body>   
<div class="main">
	<div class="login">
   		<p style="font-size:20pt;color:red""> 用户"${vote.phoneId}"已投票过，重复投票无效。</p>
	</div>
</div>     
</body>
</html>