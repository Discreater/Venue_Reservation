<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>
<%
	if(!adminLogin){
%>
	<script type="text/javascript">
		alert("请先以管理员身份登陆！");
		window.location.href = "/Venue_Reservation/user_act/login.jsp";
	</script>
<%
 	return;
	}
%>
