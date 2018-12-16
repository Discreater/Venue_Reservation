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
		if (session.getAttribute("Admin") != null) {
			VrAdmin vrAdmin = (VrAdmin) session.getAttribute("Admin");
	%>
	<a href=""><%=vrAdmin.getAdminName()%>，管理员您好！</a>
	<%
		} else if (session.getAttribute("Customer") != null) {
			VrCustomer vrCustomer = (VrCustomer) session.getAttribute("Customer");
	%>
	<a href=""><%=vrCustomer.getCustName()%>，你好！</a>
	<%
		}else{
			%>
			<a href="/Venue_Reservation/user_act/login.jsp">登录</a>|
			<a href="/Venue_Reservation/user_act/join.jsp">注册</a>
			<%
		}
	%>
</body>
</html>