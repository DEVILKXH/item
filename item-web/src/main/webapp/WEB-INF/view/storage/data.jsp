<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择人员</title>
<link rel="stylesheet" type="text/css"
	href="${resources }/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
<style>
::-webkit-scrollbar { width: 12px; height: 10px;}
::-webkit-scrollbar-thumb { height: 30px; background-color: #999; -webkit-border-radius: 7px; outline: 2px solid #fff; outline-offset: -2px;border: 2px solid #fff;}
::-webkit-scrollbar-track-piece { background-color: #fff;-webkit-border-radius: 3px;}

</style>
</head>
<body>
	<form name="myform" action="${contextPath }/item/storage/selectStoragePage.do">
		<table class="table table-striped table-hover table-bordered" id="search-table" >
			<tr>
				<td align="center"><input type="checkbox" class="selectAll"></td>
				<td align="center">序号</td>
				<td align="center">物品名称</td>
				<td align="center">库存量</td>
				<td align="center">是否可用</td>
			</tr>
			<c:forEach items="${page.list }" var="storage" varStatus="status">
				<tr>
					<td align="center"><input type="checkbox" name="listed" value="${storage.id }"></td>
					<td align="center">${status.index + 1}</td>
					<td align="center">${storage.itemName }</td>
					<td align="center">${storage.itemStorage}</td>
					<td align="center">
						<span>
							<c:if test="${storage.itemStaus == 1 }">
								可用
							</c:if>
							<c:if test="${storage.itemStaus == 0 }">
								禁用
							</c:if>
						</span>
					</td>
				</tr>
				
			</c:forEach>
			
			<tr>
				<td colspan="5" style="background: white; height: 50px;">
					<c:import url="/common/page.jsp">
						<c:param name="form" value="myform"/>
					</c:import>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>