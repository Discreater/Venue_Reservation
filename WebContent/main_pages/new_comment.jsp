<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp" %>
	<form action="/Venue_Reservation/main_pages/comment_submission.jsp">
		<p>请在下面输入您的留言：</p>
		<textarea rows="6" cols="30" name="comment" id="comment"></textarea>
		<input type="submit" value="提交">
	</form>
</body>
</html>