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
	<form method="POST" name="myform" action="${contextPath}/item/template/updateSelective.do">
		<input type="hidden" name="id" value="${model.id }"/>
		<div class="user-info">
			<span>当前用户: ${cuser.userName }</span>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
		
			
		<div class="opt_type">
			<button onclick="document.myform.submit()">提交</button>
			<button onclick="window.close()">关闭</button>
		</div>
		
		<table class="table table-bordered search-table" id="search-table">
			<tr>
				<td align="center" class="td_normal_title">模版标题</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="templateName" value="${model.templateName }"/>
				</td>
				<td align="center" class="td_normal_title">创建者</td>
				<td class="td_normal_body">${model.docCreatorName }</td>
				<td align="center" class="td_normal_title">创建时间</td>
				<td class="td_normal_body">
					<fmt:formatDate value="${model.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>