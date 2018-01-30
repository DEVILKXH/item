<%@ page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	if(request.getAttribute("contextPath")==null){
		String contextPath = request.getContextPath();
		request.setAttribute("contextPath", contextPath);
		request.setAttribute("resources", contextPath+"/resources");
		request.setAttribute("cuser",session.getAttribute("user"));
	}
	
%>
<link rel="stylesheet" type="text/css" href="${resources }/css/common/common.css">
<script type="text/javascript" src="${resources }/js/config.js"></script>
<script type="text/javascript" src="${resources }/js/angular.min.js"></script>
<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
<script type="text/javascript" src="${resources }/js/util.js"></script>

