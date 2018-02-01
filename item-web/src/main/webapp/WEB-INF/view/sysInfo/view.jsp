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
		<span>当前用户: ${cuser.nickName }</span>
			<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="glyphicon glyphicon-bell sys-info" ></a>
			<c:if test="${unReadNum != 0}">
				<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="sys-info read-num" aria-hidden="true" >${unReadNum }</a>
			</c:if>
		<a href="${contextPath}/logout.do">退出</a>
	</div>
	
		
	<div class="opt_type">
		<%-- <button onclick="window.open('${contextPath}/item/sysInfo/edit.do?id=${model.id }')">编辑</button> --%>
		<button onclick="window.close()">关闭</button>
	</div>
	
	<table class="table table-bordered search-table" id="search-table">
		<tr>
			<td align="center" class="td_normal_title">标题</td>
			<td class="td_normal_body">${model.docSubject}</td>
			<td align="center" class="td_normal_title">创建时间</td>
			<td class="td_normal_body">
				<fmt:formatDate value="${model.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td align="center" class="td_normal_title" class="inputsgl">阅读状态</td>
			<td class="td_normal_body">
				<c:if test="${model.readFlag == '1' }">已读</c:if>
				<c:if test="${model.readFlag == '0' }">未读</c:if>
			</td>
		</tr>
		<tr>
			<td align="center" class="td_normal_title">通知人</td>
			<td class="td_normal_body">${model.docCreatorName }</td>
			<td align="center" class="td_normal_title">内容</td>
			<td class="td_normal_body" colspan="3">
				${model.docContent }
			</td>
		</tr>
	</table>
</body>
</html>