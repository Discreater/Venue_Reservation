<%@page import="common.Convert"%>
<%@page import="db.acess.VrCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-删除用户</title>
</head>
<body>
	<%@ include file="/includes/header_for_both.jsp"%>
	<%
		String sureDelete = request.getParameter("delete");
		int id = 0;
		if (sureDelete != null) {
			if ("true".equals(sureDelete)) {
				try {
					String idString = request.getParameter("id");
					id = Integer.valueOf(idString);
				} catch (Exception e) {
					id = 0;
	%>
	<script>
		alert("请求参数非法");
		window.location.href = "/Venue_Reservation/index.jsp";
	</script>
	<%
		}
			}
			if (vrCustomer != null && vrCustomer.getCustId() != id) {
	%>
	<script>
		alert("请求参数非法");
		window.location.href = "/Venue_Reservation/index.jsp";
	</script>
	<%
		} else {
				VrCustomerDao vrCustomerDao = new VrCustomerDao();
				vrCustomerDao.delete(id);
				if(vrCustomer != null && vrCustomer.getCustId() == id){
					session.invalidate();
					%>
					<script>
						alert("删除成功！");
						window.location.href = "/Venue_Reservation/index.jsp";
					</script>
					<%
				}
	%>
	<script>
		alert("删除成功！返回后请刷新页面");
		window.history.go(-2);
	</script>
	<%
		}
		}else{
			%>
			<script>
				window.location.href = "/Venue_Reservation/index.jsp";
			</script>
			<%
		}
	%>
</body>
</html>