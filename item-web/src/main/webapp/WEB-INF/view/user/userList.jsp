<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">
<title></title>
</head>
<body>
	<div class="opt_type">
		<button>新建</button>
		<button onclick="document.myform.submit()">搜索</button>
	</div>
	
	<form method="post" name="myform" action="${contextPath }/item/user/getUserPage.do">
		<table class="table table-bordered search-table" id="search-table">
			<tr>
				<td align="center" class="td_normal_title">用户名</td>
				<td class="td_normal_body"><input type="text" name="userName" value="${user.userName }" class="inputsgl"></td>
				<td align="center" class="td_normal_title">昵称</td>
				<td class="td_normal_body"><input type="text" name="nickName" value="${user.nickName }" class="inputsgl"></td>
				<td align="center" class="td_normal_title" class="inputsgl">类型</td>
				<td class="td_normal_body">
					<select name="userType" class="selectsgl">
						<option value=>==请选择==</option>
						<option value="admin" <c:if test="${user.userType == 'admin' }">selected</c:if> >管理员</option>
						<option value="normal" <c:if test="${user.userType == 'normal' }">selected</c:if>>普通用户</option>
					</select>
				</td>
				<td align="center" class="td_normal_title">状态</td>
				<td class="td_normal_body">
					<select name="userStatus" class="selectsgl"> 
						<option value=>==请选择==</option>
						<option value="working" <c:if test="${user.userStatus == 'working' }">selected</c:if>>在职</option>
						<option value="worked" <c:if test="${user.userStatus == 'worked' }">selected</c:if>>离职</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<table class="table table-striped table-bordered result-table" id="result-table">
		<tr>
			<td align="center">序号</td>
			<td align="center">用户名</td>
			<td align="center">昵称</td>
			<td align="center">类型</td>
			<td align="center">状态</td>
			<td align="center">创建时间</td>
			<td align="center">操作</td>
		</tr>
		<c:forEach items="${page.list }" var="user" varStatus="status">
			<tr>
				<td align="center"><input type="hidden" name="listed" value="${user.id }">${status.index + 1}</td>
				<td align="center">${user.userName }</td>
				<td align="center">${user.nickName }</td>
				<td align="center">
					<c:if test="${user.userType == 'admin'}">
						管理员
					</c:if>
					<c:if test="${user.userType == 'normal'}">
						普通用户
					</c:if>
				</td>
				<td align="center">
					<c:if test="${user.userStatus == 'working'}">
						在职
					</c:if>
					<c:if test="${user.userStatus == 'worked'}">
						离职
					</c:if>
				</td>
				<td align="center">
					<fmt:formatDate value="${user.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
				</td>
				<td align="center">
					<a href="javascript: void(0)">删除</a>
					<a href="javascript: void(0)">编辑</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>