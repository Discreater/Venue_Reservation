<%@page import="db.model.VrCustomer"%>
<%@page import="db.model.VrCommit"%>
<%@page import="db.model.VrAdmin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<%
		VrAdmin vrAdmin = null;
		VrCustomer vrCustomer = null;
		if (session.getAttribute("Admin") != null) {
			vrAdmin = (VrAdmin) session.getAttribute("Admin");
	%>
	<a href="/Venue_Reservation//user_room/admin.jsp"><%=vrAdmin.getAdminName()%> ,管理员您好！</a>|
	<a href="/Venue_Reservation/Logout">注销</a>
	<%
		} else if (session.getAttribute("Customer") != null) {
			vrCustomer = (VrCustomer) session.getAttribute("Customer");
	%>
	<a href="/Venue_Reservation//user_room/customer.jsp"><%=vrCustomer.getCustName()%> ,你好！</a>|
	<a href="/Venue_Reservation/Logout">注销</a>
	<%
		} else {
	%>
	<a href="/Venue_Reservation/user_act/login.jsp">登录</a>|
	<a href="/Venue_Reservation/user_act/join.jsp">注册</a>
	<%
		}
	%>
</body>
</html>