<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${resources }/css/nav.css">
<link rel="stylesheet" type="text/css" href="${resources }/font/iconfont.css">
<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
<script type="text/javascript" src="${resources }/js/nav.js"></script>
<script type="text/javascript" src="${resources }/js/index/index.js"></script>

<title></title>
</head>
<body>
	<c:import url="/common/nav.jsp" >
		<c:param name="type" value="app" />
	</c:import>
	
    <div class="nav-right">
    	<div class="user-info">
			<span>当前用户: ${cuser.nickName }</span>
			<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="glyphicon glyphicon-bell sys-info" ></a>
			<c:if test="${unReadNum != 0}">
				<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="sys-info read-num" aria-hidden="true" >${unReadNum }</a>
			</c:if>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
    
		<div class="opt_type">
			<button onclick="window.open('${contextPath}/item/template/add.do')">新建</button>
			<button onclick="document.myform.submit()">搜索</button>
		</div>
		
		<form method="POST" name="myform" action="${contextPath }/item/template/getTemplatePage.do">
			<table class="table table-bordered search-table" id="search-table">
				<tr>
					<td align="center" class="td_normal_title">模版标题</td>
					<td class="td_normal_body"><input type="text" name="templateName" value="${model.templateName }" class="inputsgl"></td>
				</tr>
			</table>
			<table class="table table-striped table-hover table-bordered result-table" id="result-table" ng-app="indexApp" ng-controller='indexController'>
				<tr>
					<td align="center">序号</td>
					<td align="center">模版标题</td>
					<td align="center">创建者</td>
					<td align="center">创建时间</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach items="${page.list }" var="template" varStatus="status">
					<tr>
						<td align="center"><input type="hidden" name="listed" value="${template.id }">${status.index + 1}</td>
						<td align="center">${template.templateName }</td>
						<td align="center">${template.docCreatorName }</td>
						<td align="center">
							<fmt:formatDate value="${template.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
						</td>
						<td align="center">
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/template/view.do?id=${template.id }')">查看</a>
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/template/edit.do?id=${template.id }')">编辑</a>
							<a class="btn btn-primary btn-xs" onclick="_delete('/item/template','${template.id}')">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:import url="/common/page.jsp">
				<c:param name="form" value="myform"/>
			</c:import>
		</form>
	</div>
</body>
</html>