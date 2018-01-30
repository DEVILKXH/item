<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择人员</title>
<link rel="stylesheet" type="text/css" href="${resources }/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>

</head>
<body>
	<style>
		.halfTree{ float: left; width: 98%; border: 1px solid #ccc; border-radius: 6px; height: 350px; overflow: auto; margin-bottom: 10px;}
		.halfTree:FIRST-CHILD{ margin-right: 2%; }
		.center span{ height: 30px; line-height: 18px; display: inline-block; margin-top: 185px; }
		.person{ list-style: none; padding-left: 0px; }
		.person li{ border-bottom: 1px solid #ccc; padding: 5px; height: 30px; cursor: pointer; }
		.person li:hover{ background: #dfdfdf }
		.person-choose{ padding: 5px 10px 0; list-style: none; margin-bottom: 5px}
		.person-choose li{ position: relative; width: 10%;  height: 60px; display: inline-block; margin: 0 10px;}
		.user-name-choose{overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
		.select-del{ position: absolute; width: 15px; height: 15px; background: url(${resources}/images/icon_del.png) no-repeat; display: none;  z-index: 999;  left: 50%;  margin-left: 7px; cursor: pointer}
		.check{ float: left; width: 13px; height: 13px; margin-top: 20px; margin-right: 10px; background: url(${resources}/images/checkbox_s.png) }
		.check-active{ background: url(${resources}/images/checkbox_s_on.png) }
		#template,#template-choose{ display: none; }
		.radius{ float: left; width: 30px; height: 30px; border: 1px solid #ccc; border-radius: 30px; margin-top: 10px; background: url(${resources}/images/readUserIcon.jpg); background-position: 0px 0px; background-repeat: no-repeat; background-size: 30px; }
		.radius-choose{ width: 30px; height: 30px; border: 1px solid #ccc; border-radius: 30px; margin: 5px auto 2px; background: url(${resources}/images/readUserIcon.jpg); background-position: 0px 0px; background-repeat: no-repeat; background-size: 30px; }
		.radius-active{ border: 0px solid #ccc; background: orange; }
		.user-name{ float: left; margin-left: 10px; height: 30px; margin-top: 5px; }
		.user-name-choose{ text-align: center; }
		::-webkit-scrollbar { width: 12px; height: 10px; }
		::-webkit-scrollbar-thumb { height: 30px; background-color: #999; -webkit-border-radius: 7px; outline: 2px solid #fff; outline-offset: -2px; border: 2px solid #fff; }
		::-webkit-scrollbar-track-piece { background-color: #fff; -webkit-border-radius: 3px; }
		.address{ clear:both; width: 100%; min-height: 70px;  border: 1px solid #ccc; margin-bottom: 5px; border-radius: 5px; position: relative; }
		.delete-all{ width: 24px; height: 20px; background: url(${resources}/images/delAll.png) no-repeat 50%; transition: background .3s ease-in-out; position: absolute; right: 0; top: 0; cursor: pointer; z-index: 1000; }
		.delete-all:hover{ background: url(${resources}/images/delAll_hover.png) no-repeat 50%; }
		.panel-body,.panel,.content{ margin-bottom: 0; }
		.panel-body{ padding-bottom: 5px; }
		.content{ padding-bottom: 0; padding-top: 10px; }
		.row{padding: 10px; margin: 0;}
	</style>
	<div class="row">
		<div class="halfTree">
			<div class="panel panel-inverse">
				<div class="panel-body" id="treeDiv">
					<div class="dTreeNode">
						<ul class="person">
							<c:forEach items="${list}" varStatus="status" var="user">
								<li>
									<span>${user.nickName }</span>
									<input type="hidden" value="${user.id }" />
								</li>
							</c:forEach>
						</ul>
					</div>
			</div>
			</div>
		</div>
		<!-- <div class="halfTree">
			<ul class="person">
				<li id="template">
					<input type="hidden" name="fdId" value="{fdId}">
					<div class="check {classname}"></div>
					<div class="radius"></div>
					<div class="user-name">
						<div class="fdName">{fdName}</div>
						<div>{fdDept}</div>
					</div>
				</li>
			</ul>
		</div> -->
		<div class="btn-group address" role="group" aria-label="...">
			<div class="delete-all"></div>
			<ul class="person-choose">
				<li id="template-choose">
					<div class="select-del"></div>
					<input type="hidden" name="fdId" value="{fdId}">
					<div class="radius-choose"></div>
					<div class="user-name-choose"><span>{fdName}</span></div>
				</li>
			</ul>
		</div>
		
		<div class="btn-group" role="group" aria-label="...">
			<button type="button" class="btn btn-default queding">确定</button>
		  	<button type="button" class="btn btn-default quxiao">取消</button>
		  	<button type="button" class="btn btn-default choose-cancel">取消选定</button>
		</div>
	</div>
	
	
	<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
	<script type="text/javascript">
		if(window.opener){
			var authReadId = window.opener.document.getElementsByName("${param.fdId}")[0];   
			var authReadName = window.opener.document.getElementsByName("${param.fdName}")[0];   
			if(null != authReadId.value && "undefined" != authReadId.value && "" != authReadId.value){
				var fdIds = authReadId.value.split(";");
				var fdNames = authReadName.value.split(";");
				for(var i = 0 ; i < fdIds.length; i++){
					insertChoose(fdIds[i],fdNames[i]);
				}
			}
		}
	
		function insertChoose(fdId,fdName){
			var html = $("#template-choose").html();
			html = html.replace(/{fdId}/g,fdId);
			html = html.replace(/{fdName}/g,fdName);
			$(".person-choose").append("<li id='"+ fdId +"'>"+ html +"</li>");
		}
	
		/* $(".person").on('click','li',function(){
			$(this).find(".check").toggleClass("check-active");
			var fdId = $(this).find("input[name=fdId]").val();
			var fdName = $(this).find(".fdName").text();
			if($(this).find(".check").hasClass("check-active")){
				insertChoose(fdId,fdName);
			}else{
				$("#" + fdId).remove();
			}
		}); */
		
		$(".person-choose").on('mouseover','li',function(){
			$(this).find(".select-del").show();
		});
		$(".person-choose").on('mouseout','li',function(){
			$(this).find(".select-del").hide();
		});
		$(".person-choose").on('click','.select-del',function(){
			var $parent = $(this).closest("li");
			var value = $parent.find("input[name=fdId]").val();
			$(".person input[value="+ value +"]").closest("li").find(".check").toggleClass("check-active");
			$parent.remove();
		});
		$(".delete-all").click(function(){
			$(".person-choose li:gt(0)").remove();
			$(".check-active").toggleClass("check-active");
		});
		$(".dTreeNode").on('dblclick','li',function(){
			var fdId = $(this).find("input").val();
			var fdName = $(this).find("span").text();
			var $obj = $("#" + fdId);
			if(null != $obj && "undefined" != $obj && $obj.length > 0){
				return false;
			}
			insertChoose(fdId,fdName);
		});
		
		$(".queding").click(function(){
			if(window.opener){
				var $li = $(".person-choose li:gt(0)");
				var fdIds = [];
				var fdNames = [];
				for(var i = 0 ; i < $li.length; i++){
					var fdId = $li.eq(i).find("input[name=fdId]").val();
					var fdName = $li.eq(i).find(".user-name-choose").text();
					fdIds.push(fdId);
					fdNames.push(fdName);
				}
				var authReadId = window.opener.document.getElementsByName("${param.fdId}")[0];   
				authReadId.value = fdIds.join(";"); 
				var authReadName = window.opener.document.getElementsByName("${param.fdName}")[0];   
				authReadName.value = fdNames.join(";");   
                window.close();   
			}
		});
		
		$(".quxiao").click(function(){
			window.close();
		});
		

		$(".choose-cancel").click(function(){
			if(window.opener){
				var authReadId = window.opener.document.getElementsByName("${param.fdId}")[0];   
				authReadId.value = '';
				var authReadName = window.opener.document.getElementsByName("${param.fdName}")[0];   
				authReadName.value = ''; 
                window.close();   
			}
		});
	</script>
</body>
</html>