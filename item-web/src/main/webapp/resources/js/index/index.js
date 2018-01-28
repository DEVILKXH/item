/**
 * 
 */

function _delete(path,id){
	$ajax({
		url: context + path + "/delete.do?id="+id,
		type: 'GET',
		success: function(ajax){
			if(ajax.status == "200"){
				window.location.reload();
			}
		}
	});
}