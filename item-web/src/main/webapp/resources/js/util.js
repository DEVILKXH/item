/**
 * 
 */

function isNotNull(value){
	if(null != value && "undefined" != value && "" != value){
		return true;
	}
	return false;
}

function isNull(value){
	return !isNotNull(value);
}

function $ajax(options){
	var url = options.url || "";
	var data = options.data || {};
	var type = options.type || "POST";
	var async = options.async || "true";
	var datatype = options.datatype || 'json';
	var fns = options.success || function(){
	};
	var fne = options.error || function(){
	};
	
	$.ajax({
		url: url,
		data: data,
		type: type,
		async: async,
		datatype: datatype,
		success: fns,
		error: fne 
	});
}

function  getPage(obj,val,form){
	if($(obj).hasClass("disabled")){
		return false;
	}
	var value = $("#mypage .active").text();
	var page = parseInt(value) + val;
	$("#pages").val(page);
	form.submit();
}

function getPage2(val,form){
	if(val == $("#pages").val()){
		return false;
	}
	$("#pages").val(val);
	form.submit();
}

var row_Index = 0;
window.onload = function(){
	row_Index = $(".hanlerInfo").length;
}
function addRow(id){
	var $template = $("#" + id + "  #template");
	var html = $template.html();
	html = html.replace(/{index}/g,$(".hanlerInfo").length + 1);
	html = html.replace(/{fIndex}/g,row_Index ++ );
	$("#" + id).append("<tr class='hanlerInfo'>"+ html +"</tr>");
}

function deleteRow(obj){
	$(obj).closest("tr").remove();
	var $hand = $(".hanlerInfo");
	for(var i = 0; i < $hand.length; i++){
		$hand.eq(i).find(".hand-index").html(i + 1);
	}
}

function selectUser(name,id){
	var height=400;
    var width=400;
	window.open('/item-web/item/user/getUserList.do?fdName='+ name +'&fdId='+ id +'','sdf','height=560,width=400,top='+(screen.height-height)/2+',left='+(screen.width-width)/2+',toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function selectTemplate(){
	var height=400;
    var width=400;
	window.open('/item-web/item/template/getTemplateList.do','sdf','height=424,width=400,top='+(screen.height-height)/2+',left='+(screen.width-width)/2+',toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}