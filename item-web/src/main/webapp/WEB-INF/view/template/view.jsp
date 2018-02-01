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
		<button onclick="window.open('${contextPath}/item/template/edit.do?id=${model.id }')">编辑</button>
		<button onclick="window.close()">关闭</button>
	</div>
	
	<table class="table table-bordered search-table" id="search-table">
		<tr>
			<td align="center" class="td_normal_title">模版标题</td>
			<td class="td_normal_body">${model.templateName}</td>
			<td align="center" class="td_normal_title">创建者</td>
			<td class="td_normal_body">${model.docCreatorName }</td>
			<td align="center" class="td_normal_title">创建时间</td>
			<td class="td_normal_body">
				<fmt:formatDate value="${model.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
	</table>
	
	<table class="table table-bordered search-table" id="result-table">
			<tr>
				<td colspan="4" align="center">流程信息</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">
					序号
				</td>
				<td align="center" class="td_normal_title">
					节点名称
				</td>
				<td align="center" class="td_normal_title">
					处理人
				</td>
			</tr>
			<c:forEach items="${tStep }" var="tn" varStatus="status">
				<tr class="hanlerInfo">
				<td align="center" class="td_normal_body hand-index">
					${status.index + 1 }
				</td>
				<td align="center" class="td_normal_body">
					${tn.node.nodeName }
				</td>
				<td align="center" class="td_normal_body">
					${tn.node.handleName }
				</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>