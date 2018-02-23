<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="/future/css/mainpage.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
var userName="<%=session.getAttribute("userName")%>";
if(null != userName)
{
	$(function(){
		$("#userlogin").val(userName);
	});
}
</script>
<title>首页</title>
</head>
<body>
	<div class="face">
	    <div class="login">
			<input id="userlogin" type="text" value=""/>
			<div id="wwe" style="display: inline"></div>
        </div>
		<div class="module">
			<form method="post" action="<c:url value="/user/reguser.htm"/>">
				<button >我的项目</button>
			</form>
		</div>
		<div class="module">任务分派</div>
		<div class="module">
			<form method="post" action="<c:url value="/work/open.htm"/>">
				<button >工作日志</button>
			</form>
		</div>
		<div class="module">员工管理</div>
	</div>
</body>

</html>