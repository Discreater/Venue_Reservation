<%@page import="db.acess.VrAdminDao"%>
<%@page import="db.acess.VrCustomerDao"%>
<%@page import="db.acess.VrVenueDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="db.model.VrOrder"%>
<%@page import="db.acess.VrOrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-订单管理</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
	<%
		List<VrOrder> orders = new ArrayList<>();
		VrOrderDao vrOrderDao = new VrOrderDao();
		String type = request.getParameter("type");
		String input = request.getParameter("search");
		String waitChecked = "";
		String allChecked = "";
		if ("wait".equals(type)) {
			orders = vrOrderDao.findByState("wait", vrOrderDao.findCount(), 1);
			waitChecked = "checked";
		} else if ("all".equals(type)) {
			orders = vrOrderDao.findAll();
			allChecked = "checked";
		} else {
			waitChecked = "checked";
		}
		if (orders != null) {
			Iterator<VrOrder> iterator = orders.iterator();
			while (iterator.hasNext()) {
				VrOrder in = iterator.next();
				System.out.println(in.getOrdSubmitReason());
			}
		}
		if (input == null) {
			input = "";
		}
	%>
	<form action="">
		<input type="text" name="search" value="<%=input%>"> <input
			type="radio" name="type" value="wait" <%=waitChecked%>>查看未处理订单
		<input type="radio" name="type" value="all" <%=allChecked%>>查看所有订单
		<input type="submit" value="查找">
	</form>

	<%
		//行数与列数设置：
		int rawSize;//列数
		int colSize;//行数			
		String[] headers = { "订单ID", "预定场馆", "订单提交时间", "订单处理时间", "开始时间", "结束时间", "订单状态", "提交者", "处理者" };//表头
		String[] types = { "string", "string", "string", "string", "string", "string", "string", "string",
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
						href="/Venue_Reservation/user_room/admin/user_info.jsp?cust_id=<%=orders.get(raw).getCustId()%>">
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

</body>
</html>