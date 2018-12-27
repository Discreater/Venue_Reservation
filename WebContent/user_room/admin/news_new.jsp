<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-新闻发布</title>
</head>
<body>
<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
	<div class="newsInfo">
		<form action="/Venue_Reservation/user_room/admin/news_submit.jsp">
			<p>请输入新闻内容：<p>
			<textarea name="news" rows="20" cols="60"></textarea><br/>
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>