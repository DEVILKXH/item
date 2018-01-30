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

</head>
<body>
	<style>
.halfTree {
	float: left;
	width: 98%;
	border: 1px solid #ccc;
	border-radius: 6px;
	height: 350px;
	overflow: auto;
	margin-bottom: 10px;
}

.halfTree:FIRST-CHILD {
	margin-right: 2%;
}

.center span {
	height: 30px;
	line-height: 18px;
	display: inline-block;
	margin-top: 185px;
}

.person {
	list-style: none;
	padding-left: 0px;
}

.person li {
	border-bottom: 1px solid #ccc;
	padding: 5px;
	height: 30px;
	cursor: pointer;
}

.person li:hover {
	background: #dfdfdf
}

.person-choose {
	padding: 5px 10px 0;
	list-style: none;
	margin-bottom: 5px
}

.person-choose li {
	position: relative;
	width: 10%;
	height: 60px;
	display: inline-block;
	margin: 0 10px;
}

.user-name-choose {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.select-del {
	position: absolute;
	width: 15px;
	height: 15px;
	background: url(${resources}/images/icon_del.png) no-repeat;
	display: none;
	z-index: 999;
	left: 50%;
	margin-left: 7px;
	cursor: pointer
}

.check {
	float: left;
	width: 13px;
	height: 13px;
	margin-top: 20px;
	margin-right: 10px;
	background: url(${resources}/images/checkbox_s.png)
}

.check-active {
	background: url(${resources}/images/checkbox_s_on.png)
}

#template, #template-choose {
	display: none;
}

.radius {
	float: left;
	width: 30px;
	height: 30px;
	border: 1px solid #ccc;
	border-radius: 30px;
	margin-top: 10px;
	background: url(${resources}/images/readUserIcon.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size: 30px;
}

.radius-choose {
	width: 30px;
	height: 30px;
	border: 1px solid #ccc;
	border-radius: 30px;
	margin: 5px auto 2px;
	background: url(${resources}/images/readUserIcon.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size: 30px;
}

.radius-active {
	border: 0px solid #ccc;
	background: orange;
}

.user-name {
	float: left;
	margin-left: 10px;
	height: 30px;
	margin-top: 5px;
}

.user-name-choose {
	text-align: center;
}

::-webkit-scrollbar {
	width: 12px;
	height: 10px;
}

::-webkit-scrollbar-thumb {
	height: 30px;
	background-color: #999;
	-webkit-border-radius: 7px;
	outline: 2px solid #fff;
	outline-offset: -2px;
	border: 2px solid #fff;
}

::-webkit-scrollbar-track-piece {
	background-color: #fff;
	-webkit-border-radius: 3px;
}

.address {
	clear: both;
	width: 100%;
	min-height: 70px;
	border: 1px solid #ccc;
	margin-bottom: 5px;
	border-radius: 5px;
	position: relative;
}

.delete-all {
	width: 24px;
	height: 20px;
	background: url(${resources}/images/delAll.png) no-repeat 50%;
	transition: background .3s ease-in-out;
	position: absolute;
	right: 0;
	top: 0;
	cursor: pointer;
	z-index: 1000;
}

.delete-all:hover {
	background: url(${resources}/images/delAll_hover.png) no-repeat 50%;
}

.panel-body, .panel, .content {
	margin-bottom: 0;
}

.panel-body {
	padding-bottom: 5px;
}

.content {
	padding-bottom: 0;
	padding-top: 10px;
}

.row {
	padding: 10px;
	margin: 0;
}
</style>
	<div class="row">
		<div class="halfTree">
			<div class="panel panel-inverse">
				<div class="panel-body" id="treeDiv">
					<div class="dTreeNode">
						<ul class="person">
							<c:forEach items="${list}" varStatus="status" var="temp">
								<li><span>${temp.templateName }</span> <input type="hidden"
									value="${temp.id }" /></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
	<script type="text/javascript">

		$(".dTreeNode").on('dblclick', 'li', function() {
			var fdId = $(this).find("input").val();
			var fdName = $(this).find("span").text();
			var $obj = $("#" + fdId);
			if (null != $obj && "undefined" != $obj && $obj.length > 0) {
				return false;
			}
			window.opener.window.open('/item-web/item/main/add.do?templateId='+ fdId +'');
			window.close();
		});
	</script>
</body>
</html>