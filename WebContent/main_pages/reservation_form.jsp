<%@page import="common.Convert"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*" %>
<%@ page import="db.acess.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- loading venue info -->
<%@ include file="/includes/venue_id_handler.jsp" %>

<title>场馆预约 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp" %>
	<%@ include file="/main_pages/comments_head.jsp" %>
	<script type="text/javascript" src="/Venue_Reservation/js/date_judger.js"></script>
	<div class="reservation_form">
	<div>
		<form id="dont_sort" onsubmit="return judgeDate()" action="/Venue_Reservation/main_pages/reservation_request.jsp?venue_id=<%=venueId %>">
			<table>
				<thead>
					<tr>
						<th>预约场馆唯一标识id</th>
						<th>预约场馆名称</th>
						<th>预约起始时间</th>
						<th>预约截止时间</th>
						<th>预约申请理由</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input hidden id="venue_id" name="venue_id" type="text" value="<%=venueId %>"><%=venueId %></td>
						<td><%=venueName %></td>
						<td><input type="datetime-local" name="start_time" id="start_time"></td>
						<td><input type="datetime-local" name="end_time" id="end_time"></td>
						<td><input type="text" name="request_reason" id="request_reason" value="在此输入预约申请理由"></td>		
					</tr>
				</tbody>
				<tfoot>
					<tr><td><input type="submit" value="提交订单" style="
    position: relative;
    left: 364px;
    top: 10px;
"></td></tr>
				</tfoot>
			</table>
		</form>
	</div>
	<%
	//行数与列数设置：
				int rawSize;//列数
				int colSize;//行数
				VrOrder vrOrder=new VrOrder();
				VrOrderDao vrOrderDao=new VrOrderDao();
				List<VrOrder> allList = vrOrderDao.findByVenueId(venueId, vrOrderDao.findCount(), 1);
				List<VrOrder> passList= new ArrayList<VrOrder>();
				for(VrOrder aOrder:allList){
					if(aOrder.getOrdStatus().equals("pass")){
						passList.add(aOrder);
					}
				}
				colSize = passList.size();
				rawSize = 1;
				String[] headers = { "该场馆已经被预约的时间" };//表头
				String[] types = { "string" };
				String[][] data = new String[colSize][rawSize];//数据
				//表头和属性赋值：
				//数据赋值:
				for (int raw = 0; raw < colSize; raw++) {
					vrOrder = passList.get(raw);
					data[raw][0] = Convert.vrOrderTimeFromAndTo(vrOrder);
				}
	%>
	<!-- using script for sorting table -->
	<table id="nottableSort" class="sortable_table" style="
    margin-top: 40px;
    margin-left: 270px;
">
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
					<!-- data here -->  <%=data[raw][col]%>
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