<%@ page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="nav">
    <div class="nav-top">
        <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><img src="${resources }/images/mini.png" ></div>
    </div>
    <ul>
        <li class="nav-item <c:if test="${param.type == 'sys' }">nav-show</c:if>">
            <a href="javascript:;"><i class="my-icon nav-icon icon_1"></i><span>系统设置</span><i class="my-icon nav-more"></i></a>
            <ul>
            	<li><a href="${contextPath }/item/index.do"><span>个人信息</span></a></li>
                <c:if test="${cuser.userType == 'admin' }">
                 	<li><a href="${contextPath }/item/user/getUserPage.do"><span>人员管理</span></a></li>
	                <li><a href="${contextPath }/item/template/getTemplatePage.do"><span>模版设置</span></a></li>
                </c:if>
            </ul>
        </li>
        <li class="nav-item <c:if test="${param.type == 'app' }">nav-show</c:if>">
            <a href="javascript:;"><i class="my-icon nav-icon icon_2"></i><span>内容管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="${contextPath }/item/main/getMainPage.do?myDoc=self"><span>我的申请</span></a></li>
                <li><a href="${contextPath }/item/main/getMyDocMainPage.do?myDoc=approl"><span>待我审的</span></a></li>
                <li><a href="${contextPath }/item/main/getMyDocMainPage.do?myDoc=approved"><span>我已审的</span></a></li>
                <c:if test="${cuser.userType == 'admin' }">
                	<li><a href="${contextPath }/item/main/getMainPage.do"><span>所有申请</span></a></li>
                </c:if>
                <li><a href="${contextPath }/item/sysInfo/getSysInfoPage.do"><span>我的消息</span></a></li>
            </ul>
        </li>
        <li class="nav-item <c:if test="${param.type == 'storage' }">nav-show</c:if>">
            <a href="javascript:;"><i class="my-icon nav-icon icon_3"></i><span>库存管理</span><i class="my-icon nav-more"></i></a>
            <ul>
                <li><a href="${contextPath }/item/storage/getStoragePage.do"><span>库存列表</span></a></li>
            </ul>
        </li>
    </ul>
</div>