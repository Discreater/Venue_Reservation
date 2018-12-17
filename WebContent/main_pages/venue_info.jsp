<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.acess.VrVenueDao"%>
<%@ page import="db.model.VrVenue"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- include necessary files: -->
<link href="/Venue_Reservation/css/info_card.css" type="text/css"
	rel="stylesheet">
<!-- loading venue info given var: venueId, venueName, idOk -->
<%@ include file="/includes/venue_id_handler.jsp" %>
<title>场馆信息 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	
	<h1>
		<%=venueName%>
	</h1>
	<div class="info_card">
	<table>
	<thead>
		<tr>
			<th colspan="6">信息</th>
		</tr>
	</thead>
	<tbody>
	<tr>
	<td>
		地址：<%=thisVrVenue.getVenueAddress() %>
	</td>
	<td>
		持有者：<%=thisVrVenue.getVenueOwnerName() %>
	</td>
	<td>
		持有者联系方式：<br>
		电话：
		<%=thisVrVenue.getVenueOwnerPhone() %><br>
		电子邮件：
		<%=thisVrVenue.getVenueOwnerEmail() %>
	</td>
	<td>
		图片：
		<%=thisVrVenue.getVenuePicture() %>
	</td>
	<td>
		创建时间：
		<%=thisVrVenue.getVenueCreateTime() %>
	</td>
	<td>
		其他信息：<%=thisVrVenue.getVenueInfo() %>
	</td>
	</tr>
	</tbody>
	<tfoot>
	
	</tfoot>
	</table>
	</div>
	<script type="text/javascript">
	function sendRequest(venueId){
		window.location.href="/Venue_Reservation/main_pages/reservation_request.jsp?venue_id="+venueId;
	}
	</script>
	<input type="button" value="心动了，预定一下！" onclick="sendRequest(<%=venueId %>)">
</body>
</html>