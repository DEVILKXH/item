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
			<button onclick="selectTemplate()">新建</button>
			<button onclick="document.myform.submit()">搜索</button>
		</div>
		
		<form method="POST" name="myform" action="${contextPath }/item/main/getMainPage.do">
			<table class="table table-bordered search-table" id="search-table">
				<tr>
					<td align="center" class="td_normal_title">标题</td>
					<td class="td_normal_body"><input type="text" name="docSubject" value="${model.docSubject }" class="inputsgl"></td>
					<td align="center" class="td_normal_title">状态</td>
					<td class="td_normal_body">
						<input type="radio" name="docStatus" value="20" <c:if test="${model.docStatus == '20' }">checked</c:if> />待审
						<input type="radio" name="docStatus" value="30" <c:if test="${model.docStatus == '30' }">checked</c:if>/>发布
					</td>
					<td align="center" class="td_normal_title">申请者</td>
					<td class="td_normal_body">
						<input type="text" class="inputsgl" readonly value="${model.docCreateName }" name="docCreatorName" placeholder="请选择申请人" onclick="selectUser('docCreatorName','docCreatorId')"/>
						<input type="hidden"  name="docCreatorId" value="${model.docCreatorId }"/>
					</td>
				</tr>
			</table>
			<table class="table table-striped table-hover table-bordered result-table" id="result-table" ng-app="indexApp" ng-controller='indexController'>
				<tr>
					<td align="center">序号</td>
					<td align="center">标题</td>
					<td align="center">状态</td>
					<td align="center">创建者</td>
					<td align="center">创建时间</td>
					<td align="center">当前节点</td>
					<td align="center">审批人</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach items="${page.list }" var="main" varStatus="status">
					<tr>
						<td align="center"><input type="hidden" name="listed" value="${main.id }">${status.index + 1}</td>
						<td align="center">${main.docSubject }</td>
						<td align="center">
							<c:if test="${main.docStatus == '20' }">
								待审
							</c:if>
							<c:if test="${main.docStatus == '30' }">
								发布
							</c:if>
						</td>
						<td align="center">${main.docCreateName }</td>
						<td align="center">
							<fmt:formatDate value="${main.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
						</td>
						<td align="center">
							<c:if test="${empty main.tempInfo.stepName }">
								<span style="color: #ccc">&lt;结束节点&gt;</span>
							</c:if>
							${main.tempInfo.stepName }
						</td>
						<td align="center">
							<c:if test="${empty main.tempInfo.stepName }">
								<span style="color: #ccc">无</span>
							</c:if>
							${main.tempInfo.handlerName }
						</td>
						<td align="center">
							<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/main/view.do?id=${main.id }')">查看</a>
							<c:if test="${cuser.id == main.tempInfo.handlerId && main.docStatus == '20'}">
								<a class="btn btn-primary btn-xs" onclick="window.open('${contextPath}/item/main/edit.do?id=${main.id }')">编辑</a>
							</c:if>
							<c:if test="${cuser.id == model.docCreatorId && main.docStatus == '20' }">
								<a class="btn btn-primary btn-xs" onclick="_delete('/item/main','${main.id}')">删除</a>
							</c:if>
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