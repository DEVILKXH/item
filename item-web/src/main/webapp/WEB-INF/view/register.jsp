<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
	<link href="${resources }/css/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${resources }/js/config.js"></script>
	<script type="text/javascript" src="${resources }/js/util.js"></script>
	<script type="text/javascript" src="${resources }/js/angular.min.js"></script>
	<script type="text/javascript" src="${resources }/js/loginController/loginController.js"></script>
</head>
<body>
	<div class="login_box">
		<div class="login_l_img">
			<img src="${resources }/images/login-img.png" />
		</div>
		<div class="login">
			<div class="login_logo">
				<a href="javascript: void(0)"><img src="${resources }/images/login_logo.png" /></a>
			</div>
			<form method="post" ng-app="myApp" name='myform' ng-controller="registerController" novalidate class="myform registerform">
				<input name="userName" ng-model="userName" type="text" placeholder="用户名" required /> 
				<span ng-show="myform.userName.$dirty && myform.userName.$invalid">
					<span ng-show="myform.userName.$error.required" class="ng-show">用户名不能为空</span> 
				</span>
				<input name="passWord" ng-model="password" type="password" id="password" placeholder="密码" required />
				<span ng-show="myform.passWord.$dirty && myform.passWord.$invalid">
					<span ng-show="myform.passWord.$error.required" class="ng-show">密码不能为空</span> 
				</span>
				<input name="password2" ng-model="password2" type="password" id="password2" placeholder="确认密码" required />
				<span ng-show="myform.password2.$dirty && myform.password2.$invalid">
					<span ng-show="myform.password2.$error.required" class="ng-show">确认密码不能为空</span> 
				</span>
				<br />
				<input value="注册" style="width: 45%; margin-right: 6%" type="button" ng-click="doRegister()">
				<input value="登录" style="width: 45%;" type="button" onclick="window.location.href = '${contextPath}/login.do'">
			</form>
		</div>
		<div class="copyright">版权所有©2018</div>
	</div>
</body>
</body>
</html>