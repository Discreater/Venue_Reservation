<%@page import="common.Convert"%>
<%@page import="db.acess.VrCommitDao"%>
<%@page import="db.acess.VrOrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/includes/header_for_customer.jsp" %>
<%
String comment=request.getParameter("comment");
if(!Convert.isPoliteComment(comment)){
	Convert.alertAndBack(out, "请文明用语！", 1);
	return;
}
VrCommitDao vrOrderDao=new VrCommitDao();
VrCommit aCommit=new VrCommit();
aCommit.setCommitContext(comment);
aCommit.setCommitType("userCommit");
aCommit.setCustId(vrCustomer.getCustId());
vrOrderDao.insert(aCommit);
Convert.alertAndBack(out, "提交成功！", 1);
%>
</body>
</html>