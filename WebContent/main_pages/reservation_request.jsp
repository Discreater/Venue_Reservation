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
		request.setCharacterEncoding("UTF-8");
		boolean loginStatus = vrCustomer!=null;
		//判断是否登陆：未登录：
		if (!loginStatus) {
	%>
	<script type="text/javascript">
		alert("请先登陆！");
		window.location.href = "/Venue_Reservation/user_act/login.jsp"
	</script>
	<%
		}else{
			//已登录
			
		}
		
	%>
</body>
</html>