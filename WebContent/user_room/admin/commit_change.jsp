<%@page import="db.acess.VrCommitDao"%>
<%@page import="common.Convert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-留言信息处理</title>
</head>
<body>
		<%@ include file="/includes/header_for_admin.jsp"%>
		
		<%
			String idString = request.getParameter("id");
			int id = 0;
			try{
				id = Integer.valueOf(idString);
			}catch(Exception e){
				id = 0;
			}
			VrCommitDao vrCommitDao = new VrCommitDao();
			VrCommit commit = null;
			if(id==0){
				Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
			}else{
				commit=vrCommitDao.findById(id);
			}
			if(commit==null){
				Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
			}
			else{
				String type= request.getParameter("type");
				if(type==null || (type != null && !"pass".equals(type) && !"reject".equals(type))){
					Convert.alertAndJump(out, "请求参数非法", "/Venue_Reservation/index.jsp");
				}else{
					System.out.print(type);
					commit.setCommitState(type);
					commit.setAdminId(vrAdmin.getAdminId());
					vrCommitDao.update(commit);
					Convert.alertAndJump(out, "提交成功", "/Venue_Reservation/user_room/admin/commit_manage.jsp");
				}
			}
		%>
</body>
</html>