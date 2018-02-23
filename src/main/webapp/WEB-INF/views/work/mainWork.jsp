<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<link rel="stylesheet" type="text/css" href="/future/css/work.css"/>

<title>工作日志主页</title>
</head>
<body>
	<div class="face">
		<div class="headtitle">今日工作</div>
		<div class="worktext">	
			<form method="post" style="text-align:center" action="<c:url value="/work/saverecord.html"/>">	
                <textarea style="width:98%;height:200px;color:blue;" id="comment" name="comment"></textarea>	
				<button type="submit" >保存</button>
			</form>	
		</div>
	</div>
</body>
</html>