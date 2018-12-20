<%@page import="common.Convert"%>
<%@ page import="db.acess.*"%>
<%@ page import="db.model.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-用户信息</title>
<script type="text/javascript" charset="utf-8"
	src="/Venue_Reservation/js/room.js"></script>
</head>
<body>
	<%@ include file="/includes/header_for_both.jsp"%>
	<br />
	<br />
	<br />
	<%
		if (adminLogin) {
	%>
	<%@ include file="/user_room/admin/left_list.jsp"%>
	<%
		}
	%>

	<%
		String idString = request.getParameter("cust_id");
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
		VrCustomer cust = null;
		if (id != 0) {
			cust = new VrCustomerDao().findById(id);
		}
		if (cust == null || id == 0) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp";
	</script>
	<%
		}
		if (vrCustomer != null && vrCustomer.getCustId() != id) {
			Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
		}else{
		try {
	%>
	<div>
		<form>
			原用户信息:
			<table>
				<tbody>
					<tr>
						<td>用户ID:</td>
						<td><input type="text" name="id" value=<%=cust.getCustId()%>
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>用户昵称:</td>
						<td><input type="text" name="name"
							value=<%=cust.getCustName()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>用户密码:</td>
						<td><input type="text" name="password"
							value=<%=cust.getCustPassword()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>用户邮箱:</td>
						<td><input type="text" name="email"
							value=<%=cust.getCustEmail()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>真实姓名:</td>
						<td><input type="text" name="real_name"
							value=<%=cust.getRealName()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>电话号码:</td>
						<td><input type="text" name="phone"
							value=<%=cust.getCustPhone()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>用户地址:</td>
						<td><input type="text" name="address"
							value=<%=cust.getCustAddress()%> readonly="readonly"></td>
					</tr>
					<tr>
						<td>创建时间:</td>
						<td><input type="text" name="date_time"
							value=<%=cust.getCustDatetime()%> readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div>
		<form action="/Venue_Reservation/user_act/cust_change.jsp">
			修改信息:
			<table>
				<tbody>
					<tr>
						<td>用户ID:</td>
						<td><input type="text" name="id" value=<%=cust.getCustId()%>
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>用户昵称:</td>
						<td><input type="text" name="name"
							value=<%=cust.getCustName()%>></td>
					</tr>
					<tr>
						<td>用户密码:</td>
						<td><input type="text" name="password"
							value=<%=cust.getCustPassword()%>></td>
					</tr>
					<tr>
						<td>用户邮箱:</td>
						<td><input type="text" name="email"
							value=<%=cust.getCustEmail()%>></td>
					</tr>
					<tr>
						<td>真实姓名:</td>
						<td><input type="text" name="real_name"
							value=<%=cust.getRealName()%>></td>
					</tr>
					<tr>
						<td>电话号码:</td>
						<td><input type="text" name="phone"
							value=<%=cust.getCustPhone()%>></td>
					</tr>
					<tr>
						<td>用户地址:</td>
						<td><input type="text" name="address"
							value=<%=cust.getCustAddress()%>></td>
					</tr>
					<tr>
						<td>创建时间:</td>
						<td><input type="text" name="date_time"
							value=<%=cust.getCustDatetime()%> readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="提交修改">
		</form>
	</div>
	<div>
		<a href="/Venue_Reservation/user_room/admin/user_manage.jsp"><button>取消修改</button></a>
		<form action="/Venue_Reservation/user_act/cust_delete.jsp" onsubmit="return checkCustDelete()">
			<input hidden="hidden" type="text" name="id"
				value=<%=cust.getCustId()%> readonly="readonly"><br /> <input
				type="checkbox" name="delete" id="delete" value="true">确定删除<br> <input
				type="submit" value="删除用户">
		</form>
	</div>
	<%
		} catch (Exception e) {
	%>
	<script>
		alert("请求参数非法!");
		window.location.href = "/Venue_Reservation/index.jsp"
	</script>
	<%
		}
		}
	%>
</body>
</html>