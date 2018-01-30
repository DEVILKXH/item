/**
 * 
 */
var app = angular.module('myApp',[]);

app.factory('mainServiceImpl',function($http){
	var factory = {};
	factory.doAction = function(url,data,fn){
		var callback = fn || function (){};
		$http.post(url,data).then(callback);
	}
	return factory;
});

app.service('mainService', function(mainServiceImpl){
	this.doLogin = function(data,fn){
		var url = context + "doLogin.do";
		return mainServiceImpl.doAction(url,data,fn);
	}
	this.doRegister = function(data,fn){
		var url = context + "doRegister.do";
		return mainServiceImpl.doAction(url,data,fn);
	}
});

/**
 * 登录
 */
app.controller('loginController', function($scope,mainService){
	$scope.userName = '';
	$scope.password = '';
	$scope.doLogin = function(){
		if(isNull($scope.userName)){
			alert("帐号不能为空");
		}else if(isNull($scope.password)){
			alert("密码不能为空");
		}else{
			var data = {
				userName: $scope.userName,
				passWord: $scope.password
			}
			mainService.doLogin(data,function(ajax){
				alert(ajax.data.message);
				if(ajax.data.status == '200'){
					window.location.href= context + "item/index.do";
				}
			});
		}
	}
});

/**
 * 注册
 * 
 */
app.controller('registerController', function($scope,mainService){
	$scope.userName = '';
	$scope.password = '';
	$scope.password2 = '';
	$scope.doRegister = function(){
		if(isNull($scope.userName)){
			alert("帐号不能为空");
		}else if(isNull($scope.password)){
			alert("密码不能为空");
		}else if(isNull($scope.password2)){
			alert("确认密码不能为空");
		}else{
			var data = {
				userName: $scope.userName,
				passWord: $scope.password,
				password2: $scope.password2
			}
			mainService.doRegister(data,function(ajax){
				alert(ajax.data.message);
				if(ajax.data.status == '200'){
					window.location.href= context + "login.do";
				}
			});
		}
	}
});