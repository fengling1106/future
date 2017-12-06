<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>远大生态业主注册</title>
	<link rel="stylesheet" type="text/css" href="/king/css/form.css">
</head>
<body>
<script>
function KeyUp() {
            var a = document.getElementById("password").value;
            var b = document.getElementById("repassword").value;
            if (a == b) {
            	document.getElementByIdx("btn").disable=false;
            	return true;
            }
            else {
            	alert("输入密码不一致，请重新设置密码");
            	//document.getElementByIdx("btn").disable=false;
            	document.getElementById("password").value='';
            	document.getElementById("repassword").value='';
            	if(event.preventDefault) {
            		event.preventDefault(); 
            		   } 
            	else { 
            		 event.returnValue = false; 
            		 }
            	return false;
            }
        }
</script>

	<div class="main">
		<div class="top">业主注册</div>
		<div class="content">
			<form id="reg" method="post" action="<c:url value="/user/reguser.html"/>">
				<div><span>手机号码</span><input  name="phoneId" type="number" min=13000000000 max=19000000000 size="11" maxlength="11" required> <i>必填</i></div>
				<div><span>业主名</span><input type="text" name="userName" required min="2" max="12" required> <i>必填</i></div>
				<div><span>密码</span><input id="password" type="password" name="passWord" required min="3" max="18"> <i>必填</i></div>
				<div><span>确认密码</span><input id="repassword" type="password" name="passwordtwo" required min="3" max="18"  required> <i>必填</i></div>
				<div><span>几期</span><input list="sregion" name="region" required min="2">
									<datalist id="sregion">
   										<option value="1期">
   										<option value="2期">
  										 <option value="3期">
									</datalist> <i>请选择</i>
				</div>
				<div><span>楼栋</span><input  name="house" type="number" min=1 max=30 maxlength="2" required> <i>填写数字</i></div>
				<div><span>单元</span><input  name="cell" type="number" min=1 max=4 maxlength="1" required> <i>填写数字</i></div>
				<div><span>楼层</span><input  name="layer" type="number" min=1 max=35 maxlength="2" required> <i>填写数字</i></div>
				<div><span>房号</span><input  name="homeNumber" type="number" min=1 max=8 maxlength="1" required> <i>填写数字</i></div>
				<div style="text-align: center; width: 350px;">
					<input id="btn" type="submit" name="nav1"  onclick="KeyUp(event)"  style="font-weight:bold;	font-style:宋体;"value="立即注册">
				</div>
			</form>
		</div>
	</div>
</body>
</html>