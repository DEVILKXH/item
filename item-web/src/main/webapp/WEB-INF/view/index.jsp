<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="nav">
        <div class="nav-top">
            <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><img src="${resources }/images/mini.png" ></div>
        </div>
        <ul>
            <li class="nav-item nav-show">
                <a href="javascript:;"><i class="my-icon nav-icon icon_1"></i><span>系统设置</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="javascript:;"><span>人员管理</span></a></li>
                    <li><a href="javascript:;"><span>模版设置</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="my-icon nav-icon icon_2"></i><span>内容管理</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="javascript:;"><span>我的申请</span></a></li>
                    <li><a href="javascript:;"><span>所有申请</span></a></li>
                    <li><a href="javascript:;"><span>我的消息</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="my-icon nav-icon icon_3"></i><span>库存管理</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="javascript:;"><span>库存列表</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="nav-right">
    	<c:import url="/item/user/getUserPage1.do" />
    </div>
</body>
</html>