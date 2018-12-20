<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.VrCustomer"%>
<%@ page import="db.model.VrCommit"%>
<%@ page import="db.model.VrAdmin"%>

	<%
		VrAdmin vrAdmin = null;
		VrCustomer vrCustomer = null;
		if (session.getAttribute("Admin") != null) {
			vrAdmin = (VrAdmin) session.getAttribute("Admin");

		} else if (session.getAttribute("Customer") != null) {
			vrCustomer = (VrCustomer) session.getAttribute("Customer");

		} else {

		}
		boolean customerLogin = (vrCustomer != null);
		boolean adminLogin = (vrAdmin != null);
		boolean loginStatus = adminLogin || customerLogin;
	%>
