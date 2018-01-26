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