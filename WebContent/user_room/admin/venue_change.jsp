<%@page import="common.Convert"%>
<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.model.VrVenue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-场馆信息提交</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>

	<%
		boolean paraRight = true;
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			id = 0;
			Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
		}
		String name = request.getParameter("name");
		String ownerName = request.getParameter("owner_name");
		String ownerEmail = request.getParameter("owner_email");
		String ownerPhone = request.getParameter("owner_phone");
		String ownerAddress = request.getParameter("owner_address");
		String imgPath = request.getParameter("img");
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		String state = request.getParameter("state");
		if (name == null  || (name!=null && "null".equals(name)) 
				|| ownerName == null || (ownerName != null &&  "null".equals(ownerName)) 
				|| ownerEmail == null || (ownerEmail !=null && "null".equals(ownerEmail))
				|| state == null || (state != null && !state.equals("valid") && !state.equals("invalid"))) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}else{
		try{
		VrVenue venue = null;
		VrVenueDao vrVenueDao = new VrVenueDao();
		if(vrVenueDao.findByName(name) != null){
			Convert.alertAndBack(out, "场馆名称已存在!", 1);
		}else{
		if(id==-1){
			venue = new VrVenue();	
		}
		else{
			venue = vrVenueDao.findById(id);
			if(venue == null){
				Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
			}
		}
		venue.setVenueName(name);
		venue.setVenueOwnerName(ownerName);
		venue.setVenueOwnerPhone("null".equals(ownerPhone) ? null: ownerPhone);
		venue.setVenueOwnerEmail(ownerEmail);
		System.err.print(ownerEmail);
		venue.setVenueOwnerAddress("null".equals(ownerAddress) ? null : ownerAddress);
		venue.setVenuePicture("null".equals(imgPath)?null:imgPath);
		venue.setVenueAddress("null".equals(address)?null:address);
		venue.setVenueInfo("null".equals(info)?"":info);
		venue.setVenueState(state);
		if(id == -1){
			vrVenueDao.insert(venue);
			System.err.print(venue.getVenueOwnerEmail());
			venue = vrVenueDao.findByName(name);
			System.err.print(venue.getVenueOwnerEmail());
		}
		vrVenueDao.update(venue);
		
		Convert.alertAndJump(out, "提交成功！", "/Venue_Reservation/user_room/admin/venue_manage.jsp?search=&type=name");
		}
		}catch(Exception e){
			System.err.println(e);
		}
		}
		%>
</body>
</html>