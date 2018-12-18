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

</head>
<body>
<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
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
		if(id!=0){
			cust = new VrCustomerDao().findById(id);
		}
		if(cust == null || id == 0){
			%>
			<script>
				alert("请求参数非法!");
				window.location.href = "/Venue_Reservation/index.jsp"
			</script>
			<%
		}
		try{
	%>
	<div>
		<form>
		原用户信息:
			用户ID:<input type="text" name="id" value=<%=cust.getCustId()%> readonly="readonly"><br/>
			用户昵称:<input type="text" name="name" value=<%=cust.getCustName() %> readonly="readonly"><br/>
			用户密码:<input type="text" name="password" value=<%=cust.getCustPassword() %> readonly="readonly"><br/>
			用户邮箱:<input type="text" name="email" value=<%= cust.getCustEmail() %> readonly="readonly"><br/>
			真实姓名:<input type="text" name="real_name" value=<%= cust.getRealName() %> readonly="readonly"><br/>
			电话号码:<input type="text" name="phone" value=<%= cust.getCustPhone() %> readonly="readonly"><br/>
			用户地址:<input type="text" name="address" value=<%= cust.getCustAddress() %> readonly="readonly"><br/>
			创建时间:<input type="text" name="date_time" value=<%= cust.getCustDatetime() %> readonly="readonly"><br/>
		</form>
	</div>
	<div>
		<form action="/Venue_Reservation/user_act/cust_infoChange.jsp">
		修改信息:
			用户ID:<input type="text" name="id" value=<%=cust.getCustId()%> readonly="readonly"><br/>
			用户昵称:<input type="text" name="name" value=<%=cust.getCustName() %> ><br/>
			用户密码:<input type="text" name="password" value=<%=cust.getCustPassword() %>><br/>
			用户邮箱:<input type="text" name="email" value=<%= cust.getCustEmail() %> ><br/>
			真实姓名:<input type="text" name="real_name" value=<%= cust.getRealName() %> ><br/>
			电话号码:<input type="text" name="phone" value=<%= cust.getCustPhone() %>><br/>
			用户地址:<input type="text" name="address" value=<%= cust.getCustAddress() %>><br/>
			创建时间:<input type="text" name="date_time" value=<%= cust.getCustDatetime() %> readonly="readonly"><br/>
			<input type="submit" value="提交修改">
		</form>
	</div>
	<div>
		<a href="/Venue_Reservation/user_room/admin/user_manage.jsp"><button>取消修改</button></a>
		<form action="/Venue_Reservation/user_act/cust_infoChange.jsp">
			<input type="checkbox" name="delete" value="true">确定删除<br>
			<input type="submit" value="删除用户">
		</form>
	</div>
	<% 
		}catch(Exception e){
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