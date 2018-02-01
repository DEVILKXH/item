<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">

<title></title>
<script type="text/javascript">
	function checkSubmit(){
		if(!getTemplateInfo()){
			return false;
		};
		document.myform.submit();
	}
	
	function getTemplateInfo(){
		var $hand = $(".hanlerInfo");
		var info = [];
		var flag = true;
		for(var i = 0; i < $hand.length; i++){
			var $handleName = $hand.eq(i).find(".handleName");
			var $nodeName = $hand.eq(i).find("input[name=nodeName]");
			var $handleId = $hand.eq(i).find(".handleId");
			if(isNull($handleName.val()) || isNull($nodeName.val()) || isNull($handleId.val())){
				flag = false;
				alert("节点信息不能为空");
				break;
			}
			var data = {};
			data["step"] = i + 1;
			data["node"] = {nodeName: $nodeName.val(),handleName: $handleName.val(),handleId: $handleId.val()};
			info.push(data);
		}
		if(!flag){
			return false;
		}
		$(".templateInfo").val(JSON.stringify(info))
		return true;
	}
</script>
</head>
<body>
	<c:if test="${method == 'add'}">
		<form method="POST" name="myform" action="${contextPath}/item/template/insertSelective.do">
	</c:if>
	<c:if test="${method == 'edit'}">
		<form method="POST" name="myform" action="${contextPath}/item/template/updateSelective.do">
	</c:if>
		<input type="hidden" name="id" value="${model.id }"/>
		<input type="hidden" name="templateInfo" class="templateInfo" value="${model.templateInfo }"/>
		<div class="user-info">
			<span>当前用户: ${cuser.nickName }</span>
			<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="glyphicon glyphicon-bell sys-info" ></a>
			<c:if test="${unReadNum != 0}">
				<a href="${contextPath }/item/sysInfo/getSysInfoPage.do" class="sys-info read-num" aria-hidden="true" >${unReadNum }</a>
			</c:if>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
		
			
		<div class="opt_type">
			<a href="javascript:checkSubmit()">提交</a>
			<button onclick="window.close()">关闭</button>
		</div>
		
		<table class="table table-bordered search-table" id="search-table">
			<tr>
				<td colspan="6" align="center">基本信息</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">模版标题</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="templateName" value="${model.templateName }"/>
				</td>
				<td align="center" class="td_normal_title">创建者</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" readonly name="docCreatorName" value="${model.docCreatorName }"/>
					<input type="hidden" name="docCreatorId" value="${model.docCreatorId }"/>
				</td>
				<td align="center" class="td_normal_title">创建时间</td>
				<td class="td_normal_body">
					<fmt:formatDate value="${model.docCreatime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</table>
		
		<table class="table table-bordered search-table" id="result-table">
			<tr>
				<td colspan="4" align="center">流程信息</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">
					序号
				</td>
				<td align="center" class="td_normal_title">
					节点名称
				</td>
				<td align="center" class="td_normal_title">
					处理人
				</td>
				<td align="center" class="td_normal_title">
					<img src="${resources }/images/add.gif" style="cursor: pointer" onclick="addRow('result-table');">
				</td>
			</tr>
			<tr id="template">
				<td align="center" class="td_normal_body hand-index">
					{index}
				</td>
				<td align="center" class="td_normal_body">
					<input type="text" class="inputsgl"  name="nodeName" placeholder="请输入节点名称"/>
				</td>
				<td align="center" class="td_normal_body">
					<input type="text" class="inputsgl handleName" readonly name="handleName[{fIndex}]" placeholder="请选择节点名称" onclick="selectUser('handleName[{fIndex}]','handleId[{fIndex}]')"/>
					<input type="hidden"  name="handleId[{fIndex}]" class="handleId" placeholder="请输入节点名称"/>
				</td>
				<td align="center">
					<img src="${resources }/images/delete.gif" style="cursor: pointer" onclick="deleteRow(this);">
				</td>
			</tr>
			<c:forEach items="${tStep }" var="tn" varStatus="status">
				<tr class="hanlerInfo">
				<td align="center" class="td_normal_body hand-index">
					${status.index + 1 }
				</td>
				<td align="center" class="td_normal_body">
					<input type="text" class="inputsgl"  name="nodeName"  value="${tn.node.nodeName }" placeholder="请输入节点名称"/>
				</td>
				<td align="center" class="td_normal_body">
					<input type="text" class="inputsgl handleName" readonly value="${tn.node.handleName }" name="handleName[${status.index}]" placeholder="请选择节点名称" onclick="selectUser('handleName[${status.index}]','handleId[${status.index}]')"/>
					<input type="hidden"  name="handleId[${status.index}]" value="${tn.node.handleId }" class="handleId" placeholder="请输入节点名称"/>
				</td>
				<td align="center">
					<img src="${resources }/images/delete.gif" style="cursor: pointer" onclick="deleteRow(this);">
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>