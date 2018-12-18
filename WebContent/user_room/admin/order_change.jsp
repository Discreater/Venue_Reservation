<%@page import="java.sql.Timestamp"%>
<%@page import="db.acess.VrOrderDao"%>
<%@page import="db.model.VrOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-修改订单信息</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp" %>
	
	<% 
		boolean paraRight = true;
		String idString = request.getParameter("id");
		int id = 0;
		try{
			id=Integer.valueOf(idString);
		}catch (Exception e){
			id = 0;
			paraRight = false;
		}
		String type = request.getParameter("type");
		if(type==null || paraRight == false){
			%>
			<script>
				alert("请求参数非法!");
				window.location.href = "/Venue_Reservation/index.jsp"
			</script>
			<%
		}
		String reason = request.getParameter("reason");
		if(reason == null)
			reason = "";
		VrOrder order = new VrOrderDao().findById(id);
		if("pass".equals(type)){
			order.setOrdStatus(type);
		}
		else if("reject".equals(type)){
			order.setOrdStatus(type);
			order.setOrdRejectReason(reason);
		}
		else{
			%>
			<script>
				alert("请求参数非法!");
				window.location.href = "/Venue_Reservation/index.jsp"
			</script>
			<%
		}
		order.setAdminId(vrAdmin.getAdminId());
		order.setOrdDealTime(new Timestamp(System.currentTimeMillis()));
		VrOrderDao vrOrderDao = new VrOrderDao();
		vrOrderDao.update(order);
	%>
	<script>
				alert("处理成功!");
				window.location.go(-2);
			</script>
</body>
</html>