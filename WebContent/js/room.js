function checkPara(){
	var id = $("#id").val();
	var type = $("#type").val();
	alert(id);
	alert(type);
	var r=/^[0-9]*$/;
	if(r.test(id)){
		if(type == "pass" || pass == "reject"){
			return true;
		}
	}
	return false;
}