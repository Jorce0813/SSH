<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>用户登录</title>
		<!-- 登录检查，用户名和密码不能为空 -->
		<script type="text/javascript">
			function onCheck(theForm){
				if(theForm.username.value==""){
					alert("请输入用户名!");
					theForm.username.focus();
					return false;
				}
				if(theForm.password.value==""){
					alert("请输入密码!");
					theForm.password.focus();
					return false;
				}
				return true;
			}
		</script>
	</head>
<body>
	<form name="loginform"  action="ulogin.action" method="post" onsubmit="return onCheck(this)">
		<div align="center">
		<b>用户登录</b>
		<br><br>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name="username" type="text"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" type="password"></td>
			</tr>
		</table>
		<br><br>
		<input name="denglu" type="submit" value="登录">
		<input name="chongzhi" type="reset" value="重置">
	</div>
	</form>
</body>
</html>