<%@ page import="java.util.List"%>
<%@ page import="db.acess.VrVenueDao"%>
<%@ page import="db.model.VrVenue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 场馆一览</title>
<!-- include necessary files: -->

<link href="/Venue_Reservation/css/table.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript"
	src="/Venue_Reservation/js/jquery-latest.js"></script>

</head>
<body>
	<%@ include file="/includes/header.jsp" %>
	<%@ include file="/main_pages/comments_head.jsp" %>
	<%
			//行数与列数设置：
			int rawSize;//列数
			int colSize;//行数
			VrVenue vrVenue = new VrVenue();
			VrVenueDao vrVenueDao = new VrVenueDao();
			List<VrVenue> allList = vrVenueDao.findAll();
			colSize = allList.size();
			rawSize = 2;
			String[] headers = { "场馆名称", "场馆地址" };//表头
			String[] types = { "string", "string" };
			String[][] data = new String[colSize][rawSize];//数据
			//表头和属性赋值：

			//数据赋值:
			for (int raw = 0; raw < colSize; raw++) {
				vrVenue = allList.get(raw);
				data[raw][0] = vrVenue.getVenueName();
				data[raw][1] = vrVenue.getVenueAddress();
			}
	%>
	<!-- using script for sorting table -->

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
					href="/Venue_Reservation/main_pages/venue_info.jsp?venue_id=<%=allList.get(raw).getVenueId()%>">
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

</body>
</html>