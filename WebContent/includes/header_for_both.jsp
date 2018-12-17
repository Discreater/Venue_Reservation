<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<%
	if(!loginStatus){
%>
	<script type="text/javascript">
		alert("请先登陆！");
		window.location.href = "/Venue_Reservation/user_act/login.jsp";
	</script>
<%
	}
%>
</body>
</html>