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
		<c:param name="type" value="storage" />
	</c:import>
	
    <div class="nav-right">
    	<div class="user-info">
			<span>当前用户: ${cuser.userName }</span>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
    
		<div class="opt_type">
			<button onclick="window.open('${contextPath}/item/storage/add.do')">新建</button>
			<button onclick="document.myform.submit()">搜索</button>
		</div>
		
		<form method="POST" name="myform" action="${contextPath }/item/storage/getStoragePage.do">
			<table class="table table-bordered search-table" id="search-table">
				<tr>
					<td align="center" class="td_normal_title">物品名称</td>
					<td class="td_normal_body"><input type="text" name="itemName" value="${model.itemName }" class="inputsgl"></td>
					<td align="center" class="td_normal_title">是否可用</td>
					<td class="td_normal_body">
						<input type="radio" name="itemStaus" value="0" <c:if test="${model.itemStaus == '0' }">checked</c:if> />禁用
						<input type="radio" name="itemStaus" value="1" <c:if test="${model.itemStaus == '1' }">checked</c:if>/>可用
					</td>
				</tr>
			</table>
			<table class="table table-striped table-hover table-bordered result-table" id="result-table" ng-app="indexApp" ng-controller='indexController'>
				<tr>
					<td align="center">序号</td>
					<td align="center">物品名称</td>
					<td align="center">库存量</td>
					<td align="center">是否可用</td>
					<td align="center">创建者</td>
					<td align="center">创建时间</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach items="${page.list }" var="storage" varStatus="status">
					<tr>
						<td align="center"><input type="hidden" name="listed" value="${storage.id }">${status.index + 1}</td>
						<td align="center">${storage.itemName }</td>
						<td align="center">${storage.itemStorage }</td>
						<td align="center">${storage.itemStaus }</td>
						<td align="center">${storage.docCreateName }</td>
						<td align="center">
							<fmt:formatDate value="${storage.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
						</td>
						<td align="center">
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/storage/view.do?id=${storage.id }')">查看</a>
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/storage/edit.do?id=${storage.id }')">编辑</a>
							<a class="btn btn-primary btn-xs" onclick="_delete('/item/storage','${template.id}')">删除</a>
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