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
	<div class="venueInfo">
		<h1>场馆管理</h1>
		<div
			<%if (id == -1) {
					out.print("style=\"display:none;\"");
				}%> class="venueInfoLocate">

			<form>
				原信息:
				<table>
					<tr>
						<td>场馆ID:</td>
						<td><input type="text" name="id" value=<%=id%>
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>场馆名称:</td>
						<td><input type="text" name="name"
							value=<%=venue.getVenueName()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>拥有者:</td>
						<td><input type="text" name="owner_name"
							value=<%=venue.getVenueOwnerName()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>拥有者邮箱:</td>
						<td><input type="text" name="owner_email"
							value=<%=venue.getVenueOwnerEmail()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>拥有者电话:</td>
						<td><input type="text" name="owner_phone"
							value=<%=venue.getVenueOwnerPhone()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>拥有者地址:</td>
						<td><input type="text" name="owner_address"
							value=<%=venue.getVenueOwnerAddress()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>场馆地址:</td>
						<td><input type="text" name="address"
							value=<%=venue.getVenueAddress()%> readonly="readonly"></td>
					<tr>
						<td>场馆信息:</td>
						<td><input type="text" name="info"
							value=<%=venue.getVenueInfo()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>图片<span style="font-size:10px">(点击查看大图)</span>:</td>
						<td><a href=<%=venue.getVenuePicture() %> target="_blank"><img height="60" width="60" src="<%=venue.getVenuePicture() %>" alt="<%=venue.getVenuePicture() %>"></a></td>
					</tr>
					<tr>
						<td>场馆状态:</td>
						<td><input type="text" name="state"
							value=<%=venue.getVenueState()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>信息导入时间:</td>
						<td><input type="text" name="create_time"
							value=<%=venue.getVenueCreateTime()%> readonly="readonly"></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
		<div class="venueInfoLocateChange">
			<form action="/Venue_Reservation/UploadServlet" enctype="multipart/form-data" method="post">
			修改信息:
				<table>
					<tr>
						<td>场馆ID:</td>
						<td><input type="text" name="id" value=<%=id%>
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>场馆名称:</td>
						<td><input type="text" name="name"
							value=<%=venue.getVenueName()%> ></td>
					</tr>
					<tr>
						<td>拥有者:</td>
						<td><input type="text" name="owner_name"
							value=<%=venue.getVenueOwnerName()%>></td>
					</tr>
					<tr>
						<td>拥有者邮箱:</td>
						<td><input type="text" name="owner_email"
							value=<%=venue.getVenueOwnerEmail()%>></td>
					</tr>
					<tr>
						<td>拥有者电话:</td>
						<td><input type="text" name="owner_phone"
							value=<%=venue.getVenueOwnerPhone()%>></td>
					</tr>
					<tr>
						<td>拥有者地址:</td>
						<td><input type="text" name="owner_address"
							value=<%=venue.getVenueOwnerAddress()%>></td>
					</tr>
					<tr>
						<td>场馆地址:</td>
						<td><input type="text" name="address"
							value=<%=venue.getVenueAddress()%>></td>
					<tr>
						<td>场馆信息:</td>
						<td><input type="text" name="info"
							value=<%=venue.getVenueInfo()%>></td>
					</tr>
					<tr>
						<td>图片:</td>
						<td><input type="file" name="img"
							value=<%=venue.getVenuePicture()%>></td>
					</tr>
					<tr>
						<td>场馆状态: </td>
						<td><select name="state">
								<option value="valid">valid</option>
								<option value="invalid" selected="selected">invalid</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>信息导入时间:</td>
						<td><input type="text" name="create_time"
							value=<%=venue.getVenueCreateTime()%> readonly="readonly"></td>
					</tr>
				</table>
				<input type="submit" value="提交">
			</form>
			</div>
			<div
				<%if (id == -1) {
					out.print("style=\"display:none;\"");
				}%> class="venueDelete">
				<form action="/Venue_Reservation/user_room/admin/venue_delete.jsp"
					onsubmit="return checkDelete()">
					<input type="text" hidden="hidden" name="venue_id" value=<%=id%>>
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
	</div>
</body>
</html>