<%@page import="common.Convert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 用户留言</title>
</head>
<body>
<%@ include file="/includes/header_for_customer.jsp" %>
<%@ include file="/main_pages/comments_head.jsp" %>
<div class="room halfVisual roomLocate">
<ul>
	<li><a href="/Venue_Reservation/main_pages/all_comments.jsp">全部留言</a></li>
	<li><a href="/Venue_Reservation/main_pages/my_comments.jsp">我的留言</a></li>
	<li><a href="/Venue_Reservation/main_pages/new_comment.jsp">新建留言</a></li>
</ul>
</div>
<%
	Convert.alertAndJump(out, null, "/Venue_Reservation/main_pages/all_comments.jsp");
%>
</body>
</html>