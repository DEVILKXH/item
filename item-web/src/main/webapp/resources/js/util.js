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
