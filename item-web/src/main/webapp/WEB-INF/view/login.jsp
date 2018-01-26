<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
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
		<div class="login loginform">
			<div class="login_logo">
				<a href="javascript: void(0)"><img src="${resources }/images/login_logo.png" /></a>
			</div>
			<form method="post" name="myform" class="myform" ng-app="myApp" ng-controller="loginController" novalidate>
				<input name="userName" type="text" placeholder="请输入用户名" ng-model="userName" required />
				<span ng-show="myform.userName.$dirty && myform.userName.$invalid">
					<span ng-show="myform.userName.$error.required" class="ng-show">用户名不能为空</span> 
				</span>
				<input name="passWord" type="password" id="password" placeholder="请输入密码" ng-model="password" required/>
				<span ng-show="myform.passWord.$dirty && myform.passWord.$invalid">
					<span ng-show="myform.passWord.$error.required" class="ng-show">密码不能为空</span> 
				</span>
				<br />
				<input value="登录" style="width: 45%; margin-right: 6%" type="button" ng-click="doLogin()">
				<input value="注册" style="width: 45%;" type="button" onclick="window.location.href = '${contextPath}/register.do'">
			</form>
		</div>
		<div class="copyright">版权所有©2018</div>
	</div>
</body>
</body>
</html>