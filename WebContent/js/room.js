function checkPara(){
	var id = $("#id").val();
	var type = $("#type").val();
	var r=/^[0-9]*$/;
	if(r.test(id)){
		if(type == "pass" || pass == "reject"){
			return true;
		}
	}
	alert("请求参数错误");
	return false;
}
function checkVenuePara(){
	var $search= $("#search")
	var type=$("#type").val();
	if($search.val() == null){
		$search.val("");
	}
	if(type == "name" || type == "id"){
		return true;
	}
	alert("请求参数错误");
	return false;
}
function checkDelete(){
	return confirm("确认删除？");
}
function checkCustDelete(){
	var sure = $("#delete").val();
	if(sure == null){
		alert("请勾选确认删除！");
		return false;
	}
	return confirm("确认删除?")
}