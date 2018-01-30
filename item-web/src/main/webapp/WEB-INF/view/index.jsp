<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="${resources }/css/nav.css">
    <link rel="stylesheet" type="text/css" href="${resources }/font/iconfont.css">
    <script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
    <script type="text/javascript" src="${resources }/js/nav.js"></script>
</head>
<body>
	<c:import url="/common/nav.jsp" >
		<c:param name="type" value="sys" />
	</c:import>
    <div class="nav-right">
    	<c:import url="/item/user/view2.do" />
    </div>
</body>
</html>