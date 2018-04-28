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
			$("#div1").text("长度4-20个字符！") ;
		  }
		else if(!checkname(v_username)){
			$("#div1").text("含有非法字符");	
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
		else{
			$("#div2").text("符合要求！") ;
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
		else{
			$("#div3").text("符合要求！") ;
		}
	});	
	
	$("#email").blur(function(){
		var v_email=$(this).val();
		if("" == v_email){
			$("#div4").text("邮件不能为空");
		}
		else{
			$("#div4").text("符合要求！") ;
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
					<td><div class="txtjustify" >用 户 名<span></span></div></td>
					<td><input id="userName" type="text" name="userName" placeholder="请输入用户名" required>
						<div id="div1" class="tip" style="display: inline"></div></td>
				</tr>
				<tr>
					<td ><div class="txtjustify">新 密 码<span></span></div></td>
					<td><input id="userPasswd" type="password" name="userPasswd" placeholder="请输入密码" required>
						<div id="div2" class="tip"  style="display: inline"></div></td>
				</tr>
				<tr>
					<td ><div class="txtjustify">确 认 密 码<span></span></div></td>
					<td><input id="repwd" type="password" name="repwd" placeholder="请输入密码" required>
						<div id="div3" class="tip"  style="display: inline"></div></td>
				</tr>		
				<tr>
					<td ><div class="txtjustify">电 子 邮 箱<span></span></div></td>
					<td><input id="email" type="text" name="email" placeholder="请输入邮箱" required>
						<div id="div4" class="tip"  style="display: inline"></div></td>
				</tr>						
			</table> 
		<div class="regbutton">
          <button type="submit" class="btn" >提交注册</button>
        </div>					
		</form>	
	</div>
	<p class="foot">&copy 2018 lejujia.top Inc All Rights Reserved. </p>
</body>

</html>