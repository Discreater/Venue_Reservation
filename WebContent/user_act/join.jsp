<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="/Venue_Reservation/css/login.css" />
<script type="text/javascript" src="/Venue_Reservation/js/jquery.min.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/join_check.js"></script>
</head>
<body>
<%@ include file="/includes/login_status_handler.jsp" %>
	<%
	if(!loginStatus){ 
	%>
	<div class="page">
		<div class="loginwarrp">
			<div class="logo">注册</div>
			<div class="login_form">
				<form id="Login" name="Login" method="post" onsubmit="return validate()" action="check_join.jsp">
					<div class="login-item">
						<span>用户名：</span> <input type="text" id="username" name="username"
							class="login_input"> <span id="count-msg" class="error"></span>
					</div>
					<div class="login-item">
						<span>邮箱：</span> <input type="text" id="usermail" name="usermail"
							class="login_input"> <span id="user-mail-msg"
							class="error"></span>
					</div>
					<div class="login-item">
						<span>密码：</span> <input type="password" id="password"
							name="password" class="login_input"> <span
							id="password-msg" class="error"></span>
					</div>
					<div class="login-item">
						<span>再次输入密码：</span> <input type="password" id="password-second"
							name="password-second" class="login_input"> <span
							id="password-msg-second" class="error"></span>
					</div>
					<div class="login-sub">
						<input type="submit" name="Submit" value="注册" onclick="" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
	}else{
		%>
		<script type="text/javascript">
			window.location.href = "/Venue_Reservation/index.jsp";
		</script>
	<%
	}
	%>
	<script type="text/javascript">
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}

			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript"
		src="/Venue_Reservation/js/canvas-particle.js"></script>
</body>
</html>