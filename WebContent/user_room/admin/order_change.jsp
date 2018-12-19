<%@page import="common.Convert"%>
<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.model.VrVenue"%>
<%@page import="java.util.*"%>
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
	<%@ include file="/includes/header_for_admin.jsp"%>

	<%
		boolean paraRight = true;
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			id = 0;
			paraRight = false;
		}
		String type = request.getParameter("type");
		if (type == null || paraRight == false) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}
		String reason = request.getParameter("reason");
		if (reason == null)
			reason = "";
		VrOrder order = new VrOrderDao().findById(id);
		if ("pass".equals(type)) {
			order.setOrdStatus(type);
		} else if ("reject".equals(type)) {
			order.setOrdStatus(type);
			order.setOrdRejectReason(reason);
		} else {
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
		if ("pass".equals(type)) {
			List<VrOrder> orders = new ArrayList<>();
			List<VrOrder> allOrders = new ArrayList<>();
			VrVenue venue = new VrVenueDao().findById(order.getVenueId());
			allOrders = vrOrderDao.findByVenueId(venue.getVenueId(), vrOrderDao.findCount(), 1);
			Iterator<VrOrder> iterator = allOrders.iterator();
			while (iterator.hasNext()) {
				VrOrder tmp = iterator.next();
				if (!order.getOrdId().equals(tmp.getOrdId())) {
					if (Convert.orderTimeConflict(order, tmp)) {
						tmp.setOrdStatus("reject");
						tmp.setOrdRejectReason("已被预约（冲突自检）");
						tmp.setAdminId(vrAdmin.getAdminId());
						tmp.setOrdDealTime(new Timestamp(System.currentTimeMillis()));
						vrOrderDao.update(tmp);
					}
				}
			}
		}
	%>
	<script>
		alert("处理成功!");
		window.location.href = "/Venue_Reservation/user_room/admin/order_manage.jsp?search=&type=wait";
	</script>
</body>
</html>