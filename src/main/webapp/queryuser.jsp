<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="/future/css/queryuser.css"/>
<script type="text/javascript" src="/future/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
</script>
<title>注册用户查询</title>
</head>
<body>
<div class="regdiv">
	<div>
		<form method="post" action="<c:url value="/user/queryuser.html"/>">
			<label for="userName">用户名</label>
			<input id="userName" name="userName" type="text" >
	        <button type="submit" class="btn" >查询</button>
		</form>
	</div>	
	<div>
	<table>
		<tr>
		 <td>用 户 名</td>
		 <td>邮 箱</td>
		</tr>
		<c:forEach items="${userList}" var="item">  
         <tr>  
             <td>${item.userName}</td>  
             <td>${item.email}</td>
         </tr>  
        </c:forEach> 
	</table>
	</div>	
</div>

</body>
</html>