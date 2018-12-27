<%@page import="db.acess.VrCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-修改信息</title>
</head>
<body>
	<%@ include file="/includes/header_for_both.jsp" %>
	<% 
		boolean paraRight = true;
		String idString = request.getParameter("id");
		int id = 0;
		try{
			id = Integer.valueOf(idString);
		}catch(Exception e){
			id = 0;
			paraRight = false;
		}
		if(vrCustomer != null && vrCustomer.getCustId() != id){
			paraRight = false;
		}
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String realName = request.getParameter("real_name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		if(name == null || email == null || password == null || paraRight == false){
			%>
			<script>
				alert("请求参数非法!");
				window.location.href = "/Venue_Reservation/index.jsp"
			</script>
			<%
		}
		VrCustomer cust = null;
		if(vrCustomer != null && vrCustomer.getCustId() == id){
			cust = vrCustomer;
		}
		else{
			cust = new VrCustomer();
		}
		//System.err.println(realName);
		cust.setCustId(id);
		cust.setCustName(name);
		cust.setCustPassword(password);
		cust.setCustEmail(email);
		cust.setRealName(realName);
		cust.setCustPhone(phone);
		cust.setCustAddress(address);
		VrCustomerDao vrCustomerDao = new VrCustomerDao();
		vrCustomerDao.update(cust);
	%>
	<script type="text/javascript">
		alert("修改成功");
		<%if(vrAdmin != null){%>
		window.location.href="/Venue_Reservation/user_room/admin/user_manage.jsp?search=&type=name";
		<%}%>
		<%else if(vrCustomer != null){%>
		window.location.href="/Venue_Reservation/user_act/cust_info.jsp?cust_id=<%=vrCustomer.getCustId()%>";
		<%}%>
		<%else{%>
		window.history.back();
		<%}%>
		</script>

</body>
</html>