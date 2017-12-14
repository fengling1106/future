<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<title>新用户注册</title>
<link rel="stylesheet" type="text/css" href="/future/css/register.css"/>
<script type="text/javascript" src="/future/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#userName").focus(function(){
		if($(this).val()=="请输入用户名"){
			$(this).val("");		
		}
		$(this).css("background-color","#FFFFCC");
	});	
	
	$("#userName").blur(function(){
		$(this).css("background-color","#D6D6FF");
		var v_username=$(this).val();
		
		if("" == v_username){
			$(this).val("请输入用户名");
			$("#div1").text("姓名不能为空");
			}	
		else if (v_username.length < 4 || v_username.length > 20){
			$("#div1").text("姓名输入的长度4-20个字符！") ;
		  }
		else if(!checkname(v_username)){
			$("#div1").text("输入中含有非法字符");	
			}		
		else{
			$("#div1").text("符合要求！") ;
		}
			
	});
	
	$("#userPasswd").blur(function(){
		var v_pwd=$(this).val();
		if(v_pwd.length<6 || v_pwd.length>30){
			$("#div2").text("密码长度太短！") ;
		}
	});
	
	$("#repwd").blur(function(){
		var v_repwd=$(this).val();
		var v_pwd=$("#userPasswd").val();
		if(v_repwd != v_pwd){
			alert(v_repwd);
			alert(v_pwd);
			$("#div3").text("输入密码不一致！") ;
			$(this).val("");
		}
	});	
	
	$("#email").blur(function(){
		var v_email=$(this).val();
		if("" == v_email){
			$("#div4").text("邮件不能为空");
			}			
	});
});

function checkname(username){
    var v_name = username.toLowerCase();
	for (var i = 0; i < v_name.length; i++) { 
		var charname = v_name.charAt(i); 
		if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) { 
			return false; 
		} 
	}
	return true;
	}
</script>


</head>
<body>
	<div class="regdiv">
		<form class="regform"  method="post" action="<c:url value="/user/register.html"/>">
			<table class="regtable">
				<tr>
					<td><div>用&nbsp&nbsp户&nbsp&nbsp名:</div></td>
					<td><input id="userName" type="text" name="userName">
						<div id="div1" style="display: inline"></div></td>
				</tr>
				<tr>
					<td ><div>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码:</div></td>
					<td><input id="userPasswd" type="password" name="userPasswd">
						<div id="div2" style="display: inline"></div></td>
				</tr>
				<tr>
					<td ><div>确认密码:</div></td>
					<td><input id="repwd" type="password" name="repwd">
						<div id="div3" style="display: inline"></div></td>
				</tr>		
				<tr>
					<td ><div>电子邮箱:</div></td>
					<td><input id="email" type="text" name="email">
						<div id="div4" style="display: inline"></div></td>
				</tr>						
			</table> 
		<div class="regbutton">
          <button type="submit" class="btn" >提交注册</button>
        </div>					
		</form>	
	</div>
</body>
</html>