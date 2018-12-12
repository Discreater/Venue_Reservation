$(function(){
	$('#username').focus().blur(checkName);
	$('#password').blur(checkPassword);
	$('#password-second').blur(checkPasswordSame);
	$('#usermail').blur(checkMail);
});

function checkName(){
	var name = $('#username').val();
	if(name == null || name == ""){
		//提示错误
		$('#count-msg').html("用户名不能为空");
		return false;
	}
	var reg = /^[a-zA-Z]\w{2,9}$/;
	if(!reg.test(name)){
		$('#count-msg').html("输入3-10个字母或数字或下划线，需以字母开头");
		return false;
	}
	$('#count-msg').empty();
	return true;
}

function checkPassword(){
	var password = $('#password').val();
	if(password == null || password == ""){
		//提示错误
		$('#password-msg').html("密码不能为空");
		return false;
	}
	var reg = /^\w{6,18}$/;
	if(!reg.test(password)){
		$('#password-msg').html("输入6-18个字母或数字或下划线");
		return false;
	}
	$('#password-msg').empty();
	return true;
}

function checkPasswordSame(){
	var password = $('#password').val();
	var password_sec = $('#password-second').val();
	if(password_sec != password){
			$('#password-msg-second').html("两次密码不一致");
			return false;
	}
	$('#password-msg-second').empty();
	return true;
}

function checkMail(){
	var mail = $('#usermail').val();
	if(mail == null || mail ==""){
		$('#user-mail-msg').html("邮箱不能为空");
		return false;
	}
	var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
	if(!reg.test(mail)){
		$('#user-mail-msg').html("请输入正确邮箱格式");
		return false;
	}
	$('#user-mail-msg').empty();
	return true;
}