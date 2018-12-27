<%@page import="common.Convert"%>
<%@page import="db.acess.VrCommitDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-新闻提交</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<%
		String news = request.getParameter("news");
		if (news == null || "".equals(news)) {
			Convert.alertAndBack(out, "请输入内容！", 1);
		} else {
			
			VrCommitDao vrCommitDao = new VrCommitDao();
			VrCommit vrCommit = new VrCommit();
			vrCommit.setCommitType("news");
			vrCommit.setAdminId(vrAdmin.getAdminId());
			vrCommit.setCommitState("pass");
			vrCommit.setCommitContext(news);
			vrCommitDao.insert(vrCommit);
			Convert.alertAndBack(out, "提交成功", 2);
		}
	%>
</body>
</html>