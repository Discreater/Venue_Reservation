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
	var sure = $("input[type='checkbox']").is(':checked');
	if(sure == false){
		alert("请勾选确认删除！");
		return false;
	}
	return confirm("确认删除?")
}

function changeStyle(i){
	if(i==1){
		$("#用户管理").
		$("#场馆管理").css("margin-right","10px");
		$("#订单管理").css("margin-right","10px");
		$("#留言管理").css("margin-right","10px");
	}
	else if(i==2){
		$("#用户管理").css("margin-right","10px");
		$("#场馆管理").css("margin-right","0");
		$("#订单管理").css("margin-right","10px");
		$("#留言管理").css("margin-right","10px");
	}
	else if(i==3){
		$("#用户管理").css("margin-right","10px");
		$("#场馆管理").css("margin-right","10px");
		$("#订单管理").css("margin-right","0");
		$("#留言管理").css("margin-right","10px");
	}else if(i==4){
		$("#用户管理").css("margin-right","10px");
		$("#场馆管理").css("margin-right","10px");
		$("#订单管理").css("margin-right","10px");
		$("#留言管理").css("margin-right","0");
	}

}

