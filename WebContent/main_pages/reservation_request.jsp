<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*" %>
<%@ page import="db.acess.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- loading venue info -->
<%@ include file="/includes/venue_id_handler.jsp" %>
<title>场馆预约 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header.jsp"%>
	<%
		VrOrderDao vrOrderDao=new VrOrderDao();
		Date requestTime=new Date();
		SimpleDateFormat tmp=new SimpleDateFormat("yyyy-MM-dd ");
		String startTimeInUrl=request.getParameter("start_time");
		String endTimeInUrl=request.getParameter("end_time");
		Date startTime=new Date();
		Date endTime=new Date();
		boolean venueNotOccupied=true;
		/*
		List<VrOrder> vrOrders=vrOrderDao.findByVenueId(venueId, vrOrderDao.findCount(), 0);//获取所有与该场馆有关的预约
		if(vrOrders.size()==0){
			//无预约，直接成功
			venueNotOccupied=true;
		}else{
			//有预约，判断
		}
		*/
	%>
</body>
</html>