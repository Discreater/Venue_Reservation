<%@page import="db.acess.VrVenueDao"%>
<%@page import="common.Convert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-删除场馆</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<%
		int id = 0;
		try {
			String idString = request.getParameter("venue_id");
			id = Integer.valueOf(idString);
			VrVenueDao vrVenueDao = new VrVenueDao();
			vrVenueDao.delete(id);
			Convert.alertAndJump(out, "删除成功！", "/Venue_Reservation/user_room/admin/venue_manage.jsp?search=&type=name");
		} catch (Exception e) {
			id = 0;
			Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
		}
		
	%>
</body>
</html>