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
			<span>当前用户: ${cuser.userName }</span>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
    
		<div class="opt_type">
			<button>新建</button>
			<button onclick="document.myform.submit()">搜索</button>
		</div>
		
		<form method="POST" name="myform" action="${contextPath }/item/sysInfo/getSysInfoPage.do">
			<table class="table table-bordered search-table" id="search-table">
				<tr>
					<td align="center" class="td_normal_title">标题</td>
					<td class="td_normal_body"><input type="text" name="docSubject" value="${model.docSubject }" class="inputsgl"></td>
					<td align="center" class="td_normal_title">阅读状态</td>
					<td class="td_normal_body">
						<input type="radio" name="readFlag" value="0" <c:if test="${model.readFlag == '0' }">checked</c:if> /> 未读 
						<input type="radio" name="readFlag" value="1" <c:if test="${model.readFlag == '1' }">checked</c:if> /> 已读
					</td>
					<c:if test="${cuser.userType == 'admin' }">
						<td align="center" class="td_normal_title" class="inputsgl">通知人员</td>
						<td class="td_normal_body">
							<input type="text" name="docCreatorName" value="${model.docCreatorName }" class="inputsgl">
						</td>
					</c:if>
				</tr>
			</table>
			<table class="table table-striped table-hover table-bordered result-table" id="result-table" ng-app="indexApp" ng-controller='indexController'>
				<tr>
					<td align="center">序号</td>
					<td align="center">标题</td>
					<td align="center">内容</td>
					<td align="center">通知人</td>
					<td align="center">阅读状态</td>
					<td align="center">创建时间</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach items="${page.list }" var="sysInfo" varStatus="status">
					<tr>
						<td align="center"><input type="hidden" name="listed" value="${sysInfo.id }">${status.index + 1}</td>
						<td align="center">${sysInfo.docSubject }</td>
						<td align="center">${sysInfo.docContent }</td>
						<td align="center">${sysInfo.docCreatorName }</td>
						<td align="center">
							<c:if test="${sysInfo.readFlag == '0'}">
								未读
							</c:if>
							<c:if test="${sysInfo.readFlag == '1'}">
								已读
							</c:if>
						</td>
						<td align="center">
							<fmt:formatDate value="${sysInfo.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
						</td>
						<td align="center">
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/sysInfo/view.do?id=${sysInfo.id }')">查看</a>
							<%-- <a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/sysInfo/edit.do?id=${sysInfo.id }')">编辑</a> --%>
							<a class="btn btn-primary btn-xs" onclick="_delete('/item/sysInfo','${sysInfo.id}')">删除</a>
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