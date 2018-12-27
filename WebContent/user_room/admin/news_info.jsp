<%@page import="db.acess.VrAdminDao"%>
<%@page import="db.acess.VrCommitDao"%>
<%@page import="common.Convert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-新闻信息</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
	<%
	String idString = request.getParameter("id");
	int id = 0;
	if(idString == null){
		Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
	}else{
		try{
			id = Integer.valueOf(idString);
		}catch(Exception e){
			Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
		}
	}
	VrCommitDao vrCommitDao = new VrCommitDao();
	VrCommit commit = vrCommitDao.findById(id);
	if(commit == null){
		Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
	}else{
		%>
		<div class="roomInfo">
		<h1>新闻管理</h1>
		<div>
			<form action="/Venue_Reservation/user_room/admin/news_change.jsp">
				<table>
						<tr>
							<td>新闻ID</td>
							<td><input type="text" name="id" value=<%=commit.getCommitId() %>></td>
						</tr>
						<tr>
							<td>发布者</td>
							
							<td><%=new VrAdminDao().findById(commit.getAdminId()).getAdminName() %></td>
						</tr>
						<tr>
							<td>新闻内容</td>
							<td><textarea cols="30" rows="6" ><%=commit.getCommitContext() %></textarea><td>
						</tr>
						<tr>
							<td>新闻状态</td>
							<td><%=commit.getCommitState() %></td>
						</tr>
				</table>
				<input type="radio" name="type" value="pass" checked="checked">保留
				<input type="radio" name="type" value="reject" >废弃<br/>
				<input type="submit" value="确认">
				
			</form>
		</div>
		</div>
		<%
	}
	
	%>
</body>
</html>