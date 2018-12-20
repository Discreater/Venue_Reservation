<%@page import="common.Convert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/img.css" rel="stylesheet">
<title>场馆预约系统-主页</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<%
	Convert.alertAndJump(out, null, "/Venue_Reservation/main_pages/news.jsp");
%>
</body>
</html>