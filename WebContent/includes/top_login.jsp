<%@page import="db.model.VrCustomer"%>
<%@page import="db.model.VrCommit"%>
<%@page import="db.model.VrAdmin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<%@ include file="/includes/login_status_handler.jsp" %>
	<div class="rightUpConer">
	<%
		if (adminLogin) {			
	%>
	<a href="/Venue_Reservation/user_room/admin/admin.jsp"><%=vrAdmin.getAdminName()%> ,管理员您好！</a>|
	<a href="/Venue_Reservation/Logout">注销</a>
	<%
		} else if (customerLogin) {
	%>
	<a href="/Venue_Reservation//user_act/cust_info.jsp?cust_id=<%=vrCustomer.getCustId() %>"><%=vrCustomer.getCustName()%> ,你好！</a>|
	<a href="/Venue_Reservation/Logout">注销</a>
	<%
		} else {
	%>
	<a href="/Venue_Reservation/user_act/login.jsp">登录</a>|
	<a href="/Venue_Reservation/user_act/join.jsp">注册</a>
	<%
		}
	%>
	</div>
