<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">
<title></title>
</head>
<body>
	<c:if test="${method == 'add'}">
		<form method="POST" name="myform" action="${contextPath}/item/user/insertSelective.do">
	</c:if>
	<c:if test="${method == 'edit'}">
		<form method="POST" name="myform" action="${contextPath}/item/user/updateSelective.do">
	</c:if>
		<input type="hidden" name="id" value="${model.id }"/>
		<div class="user-info">
			<span>当前用户: ${cuser.nickName }</span>
			<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="glyphicon glyphicon-bell sys-info" ></a>
			<c:if test="${unReadNum != 0}">
				<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="sys-info read-num" aria-hidden="true" >${unReadNum }</a>
			</c:if>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
		
		<div class="opt_type">
			<button onclick="document.myform.submit()">提交</button>
			<button onclick="window.close()">关闭</button>
		</div>
		
		<table class="table table-bordered search-table" id="search-table">
			<tr>
				<td align="center" class="td_normal_title">用户名</td>
				<td class="td_normal_body">
					${model.userName}
				</td>
				<td align="center" class="td_normal_title">昵称</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="nickName" value="${model.nickName }"/>
				</td>
				<td align="center" class="td_normal_title" class="inputsgl">类型</td>
				<td class="td_normal_body">
					<c:choose>
						<c:when test="${cuser.userType == 'admin' }">
							<select name="userType" class="selectsgl">
								<option value=>==请选择==</option>
								<option value="admin" <c:if test="${model.userType == 'admin' }">selected</c:if> >管理员</option>
								<option value="normal" <c:if test="${model.userType == 'normal' }">selected</c:if>>普通用户</option>
							</select>
						</c:when>
						<c:otherwise>
							普通用户
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">状态</td>
				<td class="td_normal_body">
					<c:choose>
						<c:when test="${cuser.userType == 'admin' }">
							<select name="userStatus" class="selectsgl"> 
								<option value=>==请选择==</option>
								<option value="working" <c:if test="${model.userStatus == 'working' }">selected</c:if>>在职</option>
								<option value="worked" <c:if test="${model.userStatus == 'worked' }">selected</c:if>>离职</option>
							</select>
						</c:when>
						<c:otherwise>
							<c:if test="${model.userStatus == 'working' }">在职</c:if>
							<c:if test="${model.userStatus == 'worked' }">离职</c:if>
						</c:otherwise>
					</c:choose>
				</td>
				<td align="center" class="td_normal_title">入职时间</td>
				<td class="td_normal_body">
					<fmt:formatDate value="${model.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td align="center" class="td_normal_title">
					密码
				</td>
				<td class="td_normal_body">
					<input type="password" class="inputsgl" name="passWord" value="${model.passWord }"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>