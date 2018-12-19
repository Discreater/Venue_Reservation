<%@page import="common.Convert"%>
<%@page import="java.util.*"%>
<%@page import="db.acess.VrAdminDao"%>
<%@page import="db.model.VrVenue"%>
<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.acess.VrCustomerDao"%>
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
	<%@ include file="/includes/header_for_customer.jsp"%>
	<br />
	<br />
	<br />

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
		VrCustomer cust = null;
		VrVenue venue = null;
		if (id != 0) {
			order = new VrOrderDao().findById(id);
		}
		if (order == null || id == 0) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}
		try {
			cust = new VrCustomerDao().findById(order.getCustId());
			venue = new VrVenueDao().findById(order.getVenueId());
	%>
	<div>
		<form action="/Venue_Reservation/user_room/admin/order_change.jsp" onsubmit="return checkPara()">
			订单ID: <input type="text" name="id" id="id" value=<%=order.getOrdId()%>
				readonly="readonly"><br /> 订单提交时间:
			<%=order.getOrdSubmitTime()%><br /> 订单状态:
			<%=order.getOrdStatus()%><br /> 订单拒绝理由:
			<%=order.getOrdRejectReason()%><br /> 申请人:
			<%=cust.getCustName()%><br /> 申请场馆:
			<%=venue.getVenueName()%><br /> 申请理由: <input type="text"
				value=<%=order.getOrdSubmitReason()%> readonly="readonly"><br />
			开始时间:
			<%=order.getUseStartTime()%><br> 结束时间:
			<%=order.getUseEndTime()%><br /> 
			

		</form>
	</div>
	<%
		} catch (Exception e) {
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