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
	<script type="text/javascript" src="/Venue_Reservation/js/date_judger.js"></script>
	<div class="reservation_form">
		<form action="/Venue_Reservation/main_pages/reservation_request.jsp?venue_id=<%=venueId %>">
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
					<tr><td><input type="submit" value="提交订单" onsubmit="judgeDate()"></td></tr>
				</tfoot>
			</table>
		</form>
	</div>
	
</body>
</html>