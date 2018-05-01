<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" id="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no"/>
<title>远大意见征集</title>
<link rel="stylesheet" type="text/css" href="/future/css/option.css"/>
<script type="text/javascript" src="/future/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#ok2").click(function(){
		var v_name=$("#name").val();
		if(v_name.length==0){
			alert("名字为空");
			return false;		
			}
		
		var v_phoneId=$("#phoneId").val();
		if(v_phoneId.length >11 || v_phoneId.length <11){
			alert("电话长度不等于11位");
			return false;
			}
		});
	});
</script>

</head>
<body>
	<div class="regdiv">
		<form class="regform" id="tbl1"  method="post" action="<c:url value="/option/addoption.html"/>">
			<table class="regtable">
				<tr>
					<td><div>姓名:</div></td>
					<td><input id="name" type="text" name="name" maxlength="10" style="width:90px" required>
						<div id="div1" style="display: inline"></div></td>
					<td><div>电话:</div></td>
					<td><input id="phoneId" type="text"name="phoneId" maxlength="11" style="width:150px" required>
						<div id="div1" style="display: inline"></div></td>
				</tr>
				<tr>
					<td><div>几期:</div></td>
					<td><input id="region" list="sregion" type="text" name="region" required min="2">
						<datalist id="sregion">
   						<option value="1期">
   						<option value="2期">
  						<option value="3期">
						</datalist> 
						<div id="div1" style="display: inline"></div></td>
					<td><div>楼栋:</div></td>
					<td><input  name="house" type="number" min=1 max=40 maxlength="2" required> 
						<div id="div1" style="display: inline"></div></td>
						
				</tr>		
				<tr>
					<td><div>单元:</div></td>
					<td><input  name="cell" type="number" min=1 max=6 maxlength="1" required> 
						<div id="div1" style="display: inline"></div></td>
					<td><div>房号:</div></td>
					<td><input  name="homeNumber" type="number" min=3 max=4000 maxlength="4" required> 
						<div id="div1" style="display: inline"></div></td>
				</tr>
			</table> 
			 <div style="margin-top:20px;">填写意见</div>
			                <textarea style="width:95%;height:280px;color:blue;" id="info" name="info"></textarea>	
		 <div class="regbutton">
          <button id="ok2" type="submit" class="btn" >提交</button>
        </div>					
		</form>	
	</div>
</body>
</html>