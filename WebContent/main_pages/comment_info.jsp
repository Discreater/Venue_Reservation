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
	String tmp=request.getParameter("comment_id");
	if(tmp==null){
		Convert.alertAndBack(out, "请求参数非法！", 1);
		return;
	}
		int commentId=Integer.parseInt(tmp);
		VrCommitDao vrCommitDao=new VrCommitDao();
		VrCommit aCommit=vrCommitDao.findById(commentId);
		if(aCommit==null||aCommit.getCommitState().equals("reject")){
			Convert.alertAndBack(out, "啊呀，你查看的留言好像被删除了！", 1);
			return;
		}
		String commentContext=aCommit.getCommitContext();
	%>
	<p>留言详细内容：</p>
	<textarea rows="6" cols="30" readonly="readonly"><%=commentContext %></textarea>
	<p>留言者：<%=Convert.CustIdToName(aCommit.getCustId()) %></p>
	<p>留言时间： <%=Convert.dateToTimestamp(aCommit.getCommitSubmitTime()) %></p>
</body>
</html>