<%@ page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="page-footer clearfix ng-isolate-scope page-foot">
	<div class="page-total form-inline">
		每页<select class="form-control ng-pristine ng-valid ng-touched" name="pageSize" onchange="${param.form}.submit()">
			<option value="10" label="10" selected="selected">10</option>
			<option value="15" label="15">15</option>
			<option value="20" label="20">20</option>
			<option value="30" label="30">30</option>
			<option value="50" label="50">50</option></select>条 / 共<strong
			class="ng-binding">${page.count }</strong>条
			
	</div>
	<nav aria-label="Page navigation" class="pagenav">
		<ul class="pagination" id="mypage">
			<c:if test="${page.pageResultCount > 8 }">
				<li>
					<a href="javascript:void(0)" class="<c:if test="${page.page == 1 }">disabled </c:if>PreviewPage" onclick="getPage(this,-1,${param.form})">&laquo;</a>
				</li>
			</c:if>
			<c:if test="${page.pageResultCount > 1 }">
				<c:forEach begin="${page.start }" end="${page.end }" var="i" >
					<c:if test="${page.start != 0 }">
						<li <c:if test="${page.page ==  i}">class="active"</c:if> >
							<a href="javascript: void(0)"  onclick="getPage2(${i },${param.form})">${i }</a>
						</li>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${page.pageResultCount > 8 }">
				<li>
					<a href="javascript:void(0)" class="<c:if test="${page.page == page.pageResultCount }">disabled </c:if>NextPage" onclick="getPage(this,1,${param.form})">&raquo;</a>
				</li>
			</c:if>
		</ul>
	</nav>
	<input type="hidden" name="page" id="pages" value="${page.page }"/>
</div>