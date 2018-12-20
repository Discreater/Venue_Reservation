<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录信息处理</title>
</head>
<body>
	<%
		String info = (String)request.getAttribute("info");
		if ( info == null || "登录失败".equals(info)) {
	%>
	<script type="text/javascript">
		alert("登录失败！");
		window.location.href = "/Venue_Reservation/user_act/login.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		window.location.href = "/Venue_Reservation/index.jsp";
	</script>
	<%
		}
	%>
</body>
</html>