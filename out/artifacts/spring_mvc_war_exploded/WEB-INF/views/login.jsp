<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>

</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<c:if test="${param.incorrectAccount != null}">
				<div class="fadeIn first">
					<div class="alert alert-danger">
				    	<strong>UserName or Password incorrect</strong> 
				 	</div>
				 </div>
			</c:if> 
			<c:if test="${param.accessDenied != null}">
				<div class="fadeIn first">
					<div class="alert alert-danger">
				    	<strong>You Not Authorize</strong> 
				 	</div>
				 </div>
			</c:if>
			
			<!-- Login Form -->
			<form action="j_spring_security_check" id="formLogin" method="POST">
					<input type="text" id="login" class="fadeIn second" name="j_username" placeholder="login"> 
					<input type="password" id="password" class="fadeIn third" name="j_password" placeholder="password"> 
					<input type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>

		</div>
	</div>
</body>
</html>