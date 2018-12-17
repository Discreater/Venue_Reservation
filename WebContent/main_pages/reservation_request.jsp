<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*" %>
<%@ page import="db.acess.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	}
	if (thisVrVenue == null) {
		idOk = false;
%>
<script type="text/javascript">
	alert("请求参数出错！");
	window.history.back();
</script>
<%
	} else {
		String venueName;
		venueName = new String(thisVrVenue.getVenueName());
%>
<title>场馆预约 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<%
		request.setCharacterEncoding("UTF-8");
		if (!customerLogin) {
		//判断是否以用户登陆：未登录：
	%>
		<script type="text/javascript">
			alert("请先登陆！");
			window.location.href = "/Venue_Reservation/user_act/login.jsp"
		</script>
	<%
		} else {
				//已登录
				
		}
	%>
	<%
		}
	%>
</body>
</html>