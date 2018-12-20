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
	<h2>订单管理</h2>
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
			
			<input type="radio" name="type" id="type"
				value="pass">通过<br /> <input type="radio" name="type"
				value="reject">拒绝<br /> 若拒绝，请输入拒绝理由: <input type="text"
				name="reason" value=""> <input type="submit" value="确认">

		</form>
		<a href="/Venue_Reservation/user_room/admin/order_manage.jsp"><button>取消</button></a>
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
	<div>
		<p>该订单与以下订单冲突：</p>
		<%
		List<VrOrder> orders = new ArrayList<>();
		List<VrOrder> allOrders = new ArrayList<>();
		VrOrderDao vrOrderDao = new VrOrderDao();
		allOrders = vrOrderDao.findByVenueId(venue.getVenueId(), vrOrderDao.findCount(), 1);
		Iterator<VrOrder> iterator = allOrders.iterator();
		while (iterator.hasNext()) {
			VrOrder tmp = iterator.next();
			if (!order.getOrdId().equals(tmp.getOrdId())) {
				if (Convert.orderTimeConflict(order, tmp)) {
					orders.add(tmp);
				}
			}
		}

		//行数与列数设置：
		int rawSize;//列数
		int colSize;//行数			
		String[] headers = { "订单ID", "预定场馆", "订单提交时间", "订单处理时间", "开始时间", "结束时间", "订单状态", "提交者", "处理者" };//表头
		String[] types = { "number", "string", "string", "string", "string", "string", "string", "string",
				"string" };
		colSize = orders.size();
		rawSize = headers.length;
		String empty = null;
		String[][] data = new String[colSize][rawSize];//数据
		//表头和属性赋值：
		//数据赋值:
		for (int raw = 0; raw < colSize; raw++) {
			VrOrder tmp = orders.get(raw);
			data[raw][0] = tmp.getOrdId().toString();
			try {
				data[raw][1] = new VrVenueDao().findById(tmp.getVenueId()).getVenueName();
			} catch (Exception e) {
				data[raw][1] = empty;
			}
			try {
				data[raw][2] = tmp.getOrdSubmitTime().toString();
			} catch (Exception e) {
				data[raw][2] = empty;
			}
			try {
				data[raw][3] = tmp.getOrdDealTime().toString();
			} catch (Exception e) {
				data[raw][3] = empty;
			}
			try {
				data[raw][4] = tmp.getUseStartTime().toString();
			} catch (Exception e) {
				data[raw][4] = empty;
			}
			try {
				data[raw][5] = tmp.getUseEndTime().toString();
			} catch (Exception e) {
				data[raw][5] = empty;
			}
			data[raw][6] = tmp.getOrdStatus();
			try {
				data[raw][7] = new VrCustomerDao().findById(tmp.getCustId()).getCustName();
			} catch (Exception e) {
				data[raw][7] = empty;
			}
			try {
				data[raw][8] = new VrAdminDao().findById(tmp.getAdminId()).getAdminName();
			} catch (Exception e) {
				data[raw][8] = empty;
			}

		}
	%>
		<!-- using script for sorting table -->
		<script type="text/javascript"
			src="/Venue_Reservation/js/sort_table.js"></script>

		<div>
			<table id="tableSort" class="sortable_table">
				<thead>
					<tr>
						<%
							for (int col = 0; col < rawSize; col++) {
						%>
						<th type="<%=types[col]%>">
							<!-- data here --> <%=headers[col]%>
						</th>
						<%
							}
						%>
					</tr>
				</thead>
				<tbody>
					<%
						for (int raw = 0; raw < colSize; raw++) {
					%>
					<tr>
						<%
							for (int col = 0; col < rawSize; col++) {
						%>
						<td>
							<!-- data here --> <%
 	if (col == 0) {
 %> <a
							href="/Venue_Reservation/user_room/admin/order_info.jsp?order_id=<%=orders.get(raw).getOrdId()%>">
								<%=data[raw][col]%>
						</a> <%
 	} else {
 %> <%=data[raw][col]%> <%
 	}
 %>


						</td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="<%=rawSize%>">再怎么找也没有啦!</td>
					</tr>
				</tfoot>
			</table>
		</div>

	</div>
</body>
</html>