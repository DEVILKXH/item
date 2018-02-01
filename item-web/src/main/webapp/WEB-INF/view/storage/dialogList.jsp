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
.halfTree {width: 100%; border-radius: 6px; height: 650px; overflow: auto; margin-bottom: 10px;}
.center span { height: 30px; line-height: 18px; display: inline-block; margin-top: 185px; }
.person { list-style: none; padding-left: 0px; }
.person li { border-bottom: 1px solid #ccc; padding: 5px; height: 30px; cursor: pointer; }
.person li:hover {background: #dfdfdf }
.person-choose { padding: 5px 10px 0;list-style: none; margin-bottom: 5px}
.person-choose li { position: relative; width: 10%; height: 60px; display: inline-block;margin: 0 10px;}
.user-name-choose { overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
.select-del { position: absolute; width: 15px; height: 15px; background: url(${resources}/images/icon_del.png) no-repeat; display: none; z-index: 999; left: 50%; margin-left: 7px; cursor: pointer }
.check { float: left; width: 13px; height: 13px; margin-top: 20px; margin-right: 10px; background: url(${resources}/images/checkbox_s.png)}
.check-active { background: url(${resources}/images/checkbox_s_on.png) }
#template, #template-choose { display: none; }
.radius { float: left; width: 30px; height: 30px; border: 1px solid #ccc; border-radius: 30px; margin-top: 10px; background: url(${resources}/images/readUserIcon.jpg); background-position: 0px 0px; background-repeat: no-repeat; background-size: 30px; }
.radius-choose { width: 30px; height: 30px; border: 1px solid #ccc; border-radius: 30px; margin: 5px auto 2px; background: url(${resources}/images/readUserIcon.jpg); background-position: 0px 0px; background-repeat: no-repeat; background-size: 30px; }
.radius-active { border: 0px solid #ccc; background: orange; }
.user-name { float: left; margin-left: 10px; height: 30px; margin-top: 5px;}
.user-name-choose { text-align: center;}
::-webkit-scrollbar { width: 12px; height: 10px;}
::-webkit-scrollbar-thumb { height: 30px; background-color: #999; -webkit-border-radius: 7px; outline: 2px solid #fff; outline-offset: -2px;border: 2px solid #fff;}
::-webkit-scrollbar-track-piece { background-color: #fff;-webkit-border-radius: 3px;}
.address {clear: both;width: 100%;min-height: 70px;border: 1px solid #ccc;margin-bottom: 5px;border-radius: 5px;position: relative;}
.delete-all { width: 24px; height: 20px; background: url(${resources}/images/delAll.png) no-repeat 50%; transition: background .3s ease-in-out; position: absolute; right: 0; top: 0; cursor: pointer; z-index: 1000;}
.delete-all:hover {background: url(${resources}/images/delAll_hover.png) no-repeat 50%;}
.panel-body, .panel, .content {margin-bottom: 0;}
.panel-body {padding-bottom: 5px;}
.content {padding-bottom: 0;padding-top: 10px;}
.row {padding: 10px;margin: 0;}
.dTreeNode{width: 100%; border: 1px solid #ccc; border-radius: 6px;}
#treeDiv,#treeDiv1{padding: 0}
</style>
	<div class="row">
		<div class="halfTree">
			<div class="panel panel-inverse">
				<div class="panel-body" id="treeDiv">
					<div class="dTreeNode">
						<iframe src="${contextPath }/item/storage/selectStoragePage.do" id="myFrame" name="myFrame" class="myFrame" style="height: 290px; width: 100%; border: 0; overflow: auto">
							
						</iframe>
					</div>
				</div>
				<button class="choose" style="margin-top: 10px;">选择</button>
				<div class="panel-body"  id="treeDiv1">
					<div class="dTreeNode" style="height: 270px; overflow: auto; margin-top: 10px">
						<table class="table table-hover table-bordered" id="choose-table">
							<tr>
								<td align="center" class="td_normal_title">
									<input type="checkbox" class="select-All">
								</td>
								<td align="center" class="td_normal_title">序号</td>
								<td align="center" class="td_normal_title">物品名称</td>
								<td align="center" class="td_normal_title">库存量</td>
								<td align="center" class="td_normal_title">数量</td>
								<td align="center" class="td_normal_title">操作</td>
							</tr>
							<tr id="template">
								<td align="center">
									<input type="checkbox" value="{{id}}">
								</td>
								<td align="center" class="hand-index">{{index}}</td>
								<td align="center">
									<input type="text" class="inputsgl itemName" readonly name="itemName" value="{{itemName}}">
								</td>
								<td align="center">
									<input type="text" class="inputsgl itemStorage" readonly name="itemStorage" value="{{itemStorage}}">
								</td>
								<td align="center"><input type="text" class="inputsgl itemNumber" name="itemNumber" value="1"></td>
								<td align="center"><img src="${resources }/images/delete.gif" style="cursor: pointer" onclick="deleteRow(this);"></td>
							</tr>
						</table>
					</div>
				</div>
				<button class="enter" style="margin-top: 10px;">确定</button>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${resources }/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(".choose").click(function(){
			var iForm = window.frames['myFrame'].document.forms[0];
			var $choose = $("input[name=listed]:checked",iForm);			
			for(var i = 0; i < $choose.length; i++){
				var id = $choose.eq(i).val();
				var $t = $("#choose-table input[value="+ id +"]");
				if($t.length > 0){
					continue;
				}
				
				var html = $("#template").html();			
				var $tr = $choose.eq(i).closest("tr");
				var itemName = $tr.find("td").eq(2).text();
				var itemStorage = $tr.find("td").eq(3).text();
				var index = $(".hanlerInfo").length + 1;
				html = html.replace(/{{index}}/,index);
				html = html.replace(/{{id}}/,id);
				html = html.replace(/{{itemName}}/,itemName);
				html = html.replace(/{{itemStorage}}/,itemStorage);
				$("#choose-table").append("<tr class='hanlerInfo'>"+ html +"</tr>")
			}
		});
		
		$(".enter").click(function(){
			if(window.opener){
				var template = window.opener.document.getElementById('template');
				var table = window.opener.document.getElementById("result-table");
				$(table).find(".hanlerInfo").remove();
				var $tr = $(".hanlerInfo");
				for(var i = 0; i < $tr.length; i++){
					var html = template.innerHTML;
					var index = i + 1;
					var id = $tr.eq(i).find("input[type=checkbox]").val();
					var itemName = $tr.eq(i).find(".itemName").val();
					var itemStorage = $tr.eq(i).find(".itemStorage").val();
					var itemNumber = $tr.eq(i).find(".itemNumber").val();
					html = html.replace(/{{index}}/,index);
					html = html.replace(/{{id}}/,id);
					html = html.replace(/{{itemName}}/,itemName);
					html = html.replace(/{{itemStorage}}/,itemStorage);
					html = html.replace(/{{itemNumber}}/,itemNumber);
					$(table).append("<tr class='detail hanlerInfo'>"+ html +"</tr>")
				}
				window.close();
			}
		});
		$(function(){
			if(window.opener){
				var table = window.opener.document.getElementById("result-table");
				var $tr = $(table).find(".hanlerInfo");
				for(var i = 0; i < $tr.length; i++){
					var html = $("#template").html();
					var index = i + 1;
					var id = $tr.eq(i).find("input[name=detailId]").val();
					var itemName = $tr.eq(i).find(".itemName").val();
					var itemStorage = $tr.eq(i).find(".itemStorage").val();
					var itemNumber = $tr.eq(i).find(".itemNumber").val();
					html = html.replace(/{{index}}/,index);
					html = html.replace(/{{id}}/,id);
					html = html.replace(/{{itemName}}/,itemName);
					html = html.replace(/{{itemStorage}}/,itemStorage);
					html = html.replace(/{{itemNumber}}/,itemNumber);
					$("#choose-table").append("<tr class='hanlerInfo'>"+ html +"</tr>")
				}
			}
		});
		
	</script>
</body>
</html>