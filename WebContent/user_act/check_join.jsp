<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*"%>
<%@ page import="db.acess.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>检查</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		VrCustomerDao vrCustomerDao = new VrCustomerDao();
		VrCustomer vrCustomer = vrCustomerDao.findByName(name);
		if (vrCustomer != null) {
	%>
	<script type="text/javascript">
		alert("此用户名已经被占用请重新注册");
		history.back();
	</script>
	<%
		} else {
			String password = request.getParameter("password");
			String usermail = request.getParameter("usermail");
			vrCustomer = new VrCustomer();
			vrCustomer.setCustName(name);
			vrCustomer.setCustPassword(password);
			vrCustomer.setCustEmail(usermail);
			vrCustomerDao.insert(vrCustomer);
			session.setAttribute("Customer", vrCustomerDao.findByName(name));
	%>
	<script type="text/javascript">
		alert("注册成功！");
		window.location.href="/Venue_Reservation/index.jsp";
	</script>
	<%
		}
	%>
</body>
</html>