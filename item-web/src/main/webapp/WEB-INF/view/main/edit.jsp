<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">
<title>新增</title>
<script type="text/javascript">
function addItem(id){
	var height=400;
    var width=400;
	window.open('/item-web/item/storage/storagePage.do','sdf','height=750,width=976,top=200,left=400,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}
function checkSubmit(){
	var datas = [];
	var $tr = $(".detail");
	for(var i = 0; i < $tr.length; i++){
		var data = {};
		var id = $tr.eq(i).find("input[name=detailId]").val();
		var itemName = $tr.eq(i).find(".itemName").val();
		var itemStorage = $tr.eq(i).find(".itemStorage").val();
		var itemNumber = $tr.eq(i).find(".itemNumber").val();

		data["id"] = id;
		data["itemName"] = itemName;
		data["itemStorage"] = itemStorage;
		data["itemNumber"] = itemNumber;
		datas.push(data);
	}
	$(".itemDetailData").val(JSON.stringify(datas));
	document.myform.submit();
	
}
</script>
</head>
<body>
	<c:if test="${method == 'add'}">
		<form method="POST" name="myform" action="${contextPath}/item/main/addMain.do">
	</c:if>
	<c:if test="${method == 'edit'}">
		<form method="POST" name="myform" action="${contextPath}/item/main/updateMain.do">
	</c:if>
		<input type="hidden" name="id" value="${model.id }"/>
		<div class="user-info">
			<span>当前用户: ${cuser.nickName }</span>
			<a href="${contextPath}/logout.do">退出</a>
		</div>
		
			
		<div class="opt_type">
			<c:if test="${cuser.id == model.tempInfo.handlerId }">
				<a onclick="checkSubmit()" >提交</a>
			</c:if>
			<button onclick="window.close()">关闭</button>
		</div>
		
		<table class="table table-bordered search-table" id="search-table">
			<tr>
				<td colspan="6" align="center" style="color: #178fe6">基本信息</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">标题</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" name="docSubject" value="${model.docSubject }" required />
				</td>
				<td align="center" class="td_normal_title">状态</td>
				<td class="td_normal_body">
					<input type="radio" name="docStatus" value="20" <c:if test="${model.docStatus == '20' }">checked</c:if> />待审
					<input type="radio" name="docStatus" value="30" <c:if test="${model.docStatus == '30' }">checked</c:if>/>发布
				</td>
				<td align="center" class="td_normal_title">创建者</td>
				<td class="td_normal_body">
					<input type="text" class="inputsgl" readonly name="docCreateName" value="${model.docCreateName }"/>
					<input type="hidden" name="docCreatorId" value="${model.docCreatorId }"/>
				</td>
			</tr>
			<tr>
				<td align="center" style="line-height: 50px" class="td_normal_title">创建时间</td>
				<td class="td_normal_body" style="line-height: 50px">
					<fmt:formatDate value="${model.docCreateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td align="center" style="line-height: 50px" class="td_normal_title">备注</td>
				<td class="td_normal_body" colspan="3">
					<textarea rows="2" style="width: 85%" name="docRemark">${model.docRemark }</textarea>
				</td>
			</tr>
		</table>
		<input type='hidden' name='itemDetailData' class='itemDetailData' value=''>
		<table class="table table-bordered search-table" id="result-table">
			<tr>
				<td colspan="5" align="center" style="color: #178fe6">物品申请表单</td>
			</tr>
			<tr>
				<td align="center" class="td_normal_title">序号</td>
				<td align="center" class="td_normal_title">名称</td>
				<td align="center" class="td_normal_title">数量</td>
				<td align="center" class="td_normal_title">库存</td>
				<td align="center" class="td_normal_title">
					<img src="${resources }/images/add.gif" style="cursor: pointer" onclick="addItem('template');">
				</td>
			</tr>
			<tr id="template">
				<td align="center" class="hand-index">
					{{index}}
				</td>
				<td align="center">
					<input type="hidden" name="detailId"  value="{{id}}" />
					<input type="hidden" name="docMainId" value="${detail.docMainId }" />
					<input type="text" class="inputsgl itemName" name="itemName" value="{{itemName}}" />
				</td>
				<td align="center">
					<input type="text" class="inputsgl itemNumber" name="itemNumber" value="{{itemNumber}}" />
				</td>
				<td align="center">
					<input type="text" class="inputsgl itemStorage" readonly name="itemStorage" value="{{itemStorage}}" />
				</td>
				<td align="center">
					<img src="${resources }/images/delete.gif" style="cursor: pointer" onclick="deleteRow(this);">
				</td>
			</tr>
			<c:forEach items="${model.fdItems }" var="detail" varStatus="status">
				<tr class="detail hanlerInfo">
					<td align="center" class="hand-index">
						${status.index + 1 }
					</td>
					<td align="center">
						<input type="hidden" name="detailId" value="${detail.id }" />
						<input type="hidden" name="docMainId" value="${detail.docMainId }" />
						<input type="text" class="inputsgl itemName" readonly name="itemName" value="${detail.itemName }" />
					</td>
					<td align="center">
						<input type="text" class="inputsgl itemNumber" name="itemNumber" value="${detail.itemNumber }" />
					</td>
					<td align="center">
						<input type="text" class="inputsgl itemStorage" readonly name="itemStorage" value="${detail.itemStorage }" />
					</td>
					<td align="center">
						<img src="${resources }/images/delete.gif" style="cursor: pointer" onclick="deleteRow(this);">
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<table class="table table-bordered result-table" id="temp-table">
			<tr>
				<td colspan="3" align="center" style="color: #178fe6">
					流程信息
					<input type="hidden" name="tempInfoJSON" value='${model.tempInfoJSON }'>
				</td>
			</tr>
			<tr>
				<td align="center">当前处理人</td>
				<td colspan="4" >${model.tempInfo.handlerName }</td>
			</tr>
			<tr>
				<td align="center">即将流向</td>
				<td colspan="4" >${model.tempInfo.nextStepName} : ${model.tempInfo.nextHandlerName }</td>
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
			</tr>
			<c:forEach items="${model.tempInfo.tn }" var="tn" varStatus="status">
				<tr class="hanlerInfo">
				<td align="center" class="td_normal_body hand-index">
					${status.index + 1 }
				</td>
				<td align="center" class="td_normal_body">
					${tn.node.nodeName }
				</td>
				<td align="center" class="td_normal_body">
					${tn.node.handleName }
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>