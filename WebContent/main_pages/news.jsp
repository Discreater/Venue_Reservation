<%@page import="common.Convert"%>
<%@page import="db.model.VrCommit"%>
<%@page import="db.model.VrOrder"%>
<%@page import="db.acess.*"%>
<%@page import="db.acess.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 最新动态</title>
</head>
<body>
	<%@ include file="/includes/header.jsp" %>
	<h1>最新消息：</h1>
	<%
		out.println("<p>");
		VrOrderDao vrOrderDao=new VrOrderDao();
		VrCommitDao vrCommitDao=new VrCommitDao();
		List<VrOrder> showOrder=vrOrderDao.findByReverse(3, 1);
		List<VrCommit> showCommit=vrCommitDao.findByReverse(3, 1);
		for(VrOrder aOrder:showOrder){
			out.println("<p>");
			out.println(Convert.CustIdToName(aOrder.getCustId())+
					" 在 "+
					Convert.timestampToDateString(aOrder.getOrdSubmitTime())+
					" 预约了 "+
					Convert.venueIdToString(aOrder.getVenueId())+
					" 的 " +
					Convert.vrOrderTimeFromAndTo(aOrder)+
					" 时间段的场地 ");			
			out.println("<p>");
		}
		out.println("</p>");
	%>
	
	<%
		out.println("<p>");
		for(VrCommit aCommit:showCommit){
			if((!aCommit.getCommitState().equals("reject"))
					&& aCommit.getCommitType().equals("userCommit")){
			out.println("<p>");
			out.println(Convert.CustIdToName(aCommit.getCustId())+
					" 在 "+
					Convert.timestampToDateString(aCommit.getCommitSubmitTime())+
					" 留言道 ："+
					Convert.cutStringWithDots(aCommit.getCommitContext(), 30));			
			out.println("<p>");
			}
		}
	out.println("</p>");
	%>
</body>
</html>