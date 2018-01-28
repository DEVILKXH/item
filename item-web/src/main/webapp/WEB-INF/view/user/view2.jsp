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
	<div class="user-info">
		<span>当前用户: ${user.userName }</span>
		<a href="${contextPath}/logout.do">退出</a>
	</div>
	
		
	<div class="opt_type">
		<button onclick="window.open('${contextPath}/item/user/edit.do?id=${user.id }')">编辑</button>
	</div>
	
	<table class="table table-bordered search-table" id="search-table">
		<tr>
			<td align="center" class="td_normal_title">用户名</td>
			<td class="td_normal_body">${user.userName}</td>
			<td align="center" class="td_normal_title">昵称</td>
			<td class="td_normal_body">${user.nickName }</td>
			<td align="center" class="td_normal_title" class="inputsgl">类型</td>
			<td class="td_normal_body">
				<c:if test="${user.userType == 'admin' }">管理员</c:if>
				<c:if test="${user.userType == 'normal' }">普通用户</c:if>
			</td>
		</tr>
		<tr>
			<td align="center" class="td_normal_title">状态</td>
			<td class="td_normal_body">
				<c:if test="${user.userStatus == 'working' }">在职</c:if>
				<c:if test="${user.userStatus == 'worked' }">离职</c:if>
			</td>
			<td align="center" class="td_normal_title">入职时间</td>
			<td class="td_normal_body">
				<fmt:formatDate value="${user.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td align="center" class="td_normal_title">&nbsp;</td>
			<td class="td_normal_body">
				&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>