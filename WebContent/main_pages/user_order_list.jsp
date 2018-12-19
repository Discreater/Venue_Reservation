<%@page import="common.Convert"%>
<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.acess.VrOrderDao"%>
<%@page import="db.model.VrOrder"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 订单一览</title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp" %>
	<%
		VrOrderDao vrOrderDao=new VrOrderDao();
		List<VrOrder> customerOrders=vrOrderDao.findByCustId(vrCustomer.getCustId(), vrOrderDao.findCount(), 1);
		//行数与列数设置：
		int rawSize;//列数
		int colSize;//行数	
		colSize = customerOrders.size();
		rawSize = 3;
		String[] headers = { "场馆名称", "预约时间","订单状态" };//表头
		String[] types = { "string", "string","string" };
		String[][] data = new String[colSize][rawSize];//数据
		//表头和属性赋值：
		//数据赋值:
		VrOrder aVrOrder;
		for (int raw = 0; raw < colSize; raw++) {
			aVrOrder = customerOrders.get(raw);
			int venueId=aVrOrder.getVenueId();
			data[raw][0] = new VrVenueDao().findById(venueId).getVenueName();
			data[raw][1] = Convert.vrOrderTimeFromAndTo(aVrOrder);
			data[raw][2] = aVrOrder.getOrdStatus();
		}
%>
<!-- using script for sorting table -->
<div>
<table id="nottableSort" class="sortable_table">
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
			href="/Venue_Reservation/main_pages/order_info.jsp?order_id=<%=customerOrders.get(raw).getOrdId() %>">
				<%=data[raw][col]%>
		</a> <%
} else {
%> <%=data[raw][col]%> 
			<%} %>

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