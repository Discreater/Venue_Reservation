<%@page import="db.acess.VrOrderDao"%>
<%@page import="db.model.VrOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-订单信息</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>

	<%
		String idString = request.getParameter("order_id");
		int id = 0;
		if (idString == null) {
			id = 0;
		} else {
			try {
				id = Integer.valueOf(idString);
			} catch (Exception e) {
				id = 0;
			}
		}
		VrOrder order = null;
		if(id!=0){
			order = new VrOrderDao().findById(id);
		}
		if(order == null || id == 0){
			%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}try{
		%>
		<%
		}catch(Exception e){
			%>
			<script>
				alert("请求参数非法!");
				window.location.href = "/Venue_Reservation/index.jsp"
			</script>
			<%
		}
		%>
</body>
</html>