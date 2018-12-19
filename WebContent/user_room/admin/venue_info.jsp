<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.model.VrVenue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-场馆信息</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@include file="/user_room/admin/left_list.jsp"%>
	<%
		String idString = request.getParameter("venue_id");
		int id = 0;
		if (idString == null) {
			id = 0;
		} else {
			try {
				id = Integer.valueOf(idString);
			} catch (Exception e) {
				id = 0;
			}
		}
		VrVenue venue = null;
		if (id == -1) {
			venue = new VrVenue();
		} else if (id != 0) {
			venue = new VrVenueDao().findById(id);
		}
		if (venue == null || id == 0) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}
		try {
	%>
	<div
		<%if (id == -1) {
					out.print("style=\"display:none;\"");
				}%>>
		<form>
			原信息:<br /> 场馆ID:<input type="text" name="id" value=<%=id%>
				readonly="readonly"><br /> 场馆名称:<input type="text"
				name="name" value=<%=venue.getVenueName()%> readonly="readonly"><br />
			拥有者:<input type="text" name="owner_name"
				value=<%=venue.getVenueOwnerName()%> readonly="readonly"><br />
			拥有者邮箱:<input type="text" name="owner_email"
				value=<%=venue.getVenueOwnerEmail()%> readonly="readonly"><br />
			拥有者电话:<input type="text" name="owner_phone"
				value=<%=venue.getVenueOwnerPhone()%> readonly="readonly"><br />
			拥有者地址:<input type="text" name="owner_address"
				value=<%=venue.getVenueOwnerAddress()%> readonly="readonly"><br />
			图片:<input type="text" name="img" value=<%=venue.getVenuePicture()%>
				readonly="readonly"><br /> 场馆地址:<input type="text"
				name="address" value=<%=venue.getVenueAddress()%>
				readonly="readonly"><br /> 场馆信息:<input type="text"
				name="info" value=<%=venue.getVenueInfo()%> readonly="readonly"><br />
			场馆状态:<input type="text" name="state"
				value=<%=venue.getVenueState()%> readonly="readonly"> <br />
			信息导入时间:<input type="text" name="create_time"
				value=<%=venue.getVenueCreateTime()%> readonly="readonly"><br />
		</form>
	</div>
	<div>
		<form action="/Venue_Reservation/user_room/admin/venue_change.jsp">
			提交信息:<br /> 场馆ID:<input type="text" name="id" value=<%=id%>
				readonly="readonly"><br /> 场馆名称:<input type="text"
				name="name" value=<%=venue.getVenueName()%>>*<br /> 拥有者:<input
				type="text" name="owner_name" value=<%=venue.getVenueOwnerName()%>>*<br />
			拥有者邮箱:<input type="text" name="owner_email"
				value=<%=venue.getVenueOwnerEmail()%>>*<br /> 拥有者电话:<input
				type="text" name="owner_phone"
				value=<%=venue.getVenueOwnerPhone()%>><br /> 拥有者地址:<input
				type="text" name="owner_address"
				value=<%=venue.getVenueOwnerAddress()%>><br /> 图片:<input
				type="text" name="img" value=<%=venue.getVenuePicture()%>
				readonly="readonly"><br /> 场馆地址:<input type="text"
				name="address" value=<%=venue.getVenueAddress()%>>*<br />
			场馆信息:<input type="text" name="info" value=<%=venue.getVenueInfo()%>><br />
			场馆状态: <select name="state">
				<option value="valid">valid</option>
				<option value="invalid" selected="selected">invalid</option>
			</select><br /> 信息导入时间:<input type="text" name="create_time"
				value=<%=venue.getVenueCreateTime()%> readonly="readonly"><br />
			<input type="submit" value="提交">
		</form>
		<div
			<%if (id == -1) {
					out.print("style=\"display:none;\"");
				}%>>
			<form action="/Venue_Reservation/user_room/admin/venue_delete.jsp" onsubmit="return checkDelete()">
				<input type="text" hidden name="venue_id" value=<%=id %>>
				<input type="submit" value="删除">
			</form>
		</div>
	</div>
	<%
		} catch (Exception e) {
			System.err.println(e);
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}
	%>
</body>
</html>