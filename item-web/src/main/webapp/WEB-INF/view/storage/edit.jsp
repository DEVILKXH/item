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
	<c:if test="${method == 'add'}">
		<form method="POST" name="myform" action="${contextPath}/item/storage/insertSelective.do">
	</c:if>
	<c:if test="${method == 'edit'}">
		<form method="POST" name="myform" action="${contextPath}/item/storage/updateSelective.do">
	</c:if>
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
				<td colspan="6" align="center">基本信息</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">物品名称</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="itemName" value="${model.itemName }"/>
				</td>
				<td align="center" class="td_normal_title">库存量</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="itemStorage" value="${model.itemStorage }"/>
				</td>
				<td align="center" class="td_normal_title">状态</td>
				<td class="td_normal_body">
					<input type="radio" name="itemStaus" value="0" <c:if test="${model.itemStaus == '0' }">checked</c:if> />禁用
					<input type="radio" name="itemStaus" value="1" <c:if test="${model.itemStaus == '1' }">checked</c:if>/>可用
				</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">创建者</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" readonly name="docCreateName" value="${model.docCreateName }"/>
					<input type="hidden" name="docCreateId" value="${model.docCreateId }"/>
				</td>
				<td align="center" class="td_normal_title">创建时间</td>
				<td class="td_normal_body">
					<fmt:formatDate value="${model.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td align="center" class="td_normal_title">&nbsp;</td>
				<td class="td_normal_body">
					&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>