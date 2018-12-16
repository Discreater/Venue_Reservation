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
<!-- loading venue info -->
<%
	VrVenueDao vrVenueDao = new VrVenueDao();
	VrVenue thisVrVenue = null;
	boolean idOk = true;
	String venueId = request.getParameter("venue_id");
	if (venueId == null) {
		idOk = false;
	} else {
		thisVrVenue = vrVenueDao.findById(Integer.parseInt(venueId));
	}if(thisVrVenue==null){
		idOk=false;
%>
<script type="text/javascript">
	alert("请求参数出错！");
	window.history.back();
</script>
<%
	} else {
		String venueName;
		venueName=new String(thisVrVenue.getVenueName());
		
%>
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
</body>
<%
	}
%>
</html>