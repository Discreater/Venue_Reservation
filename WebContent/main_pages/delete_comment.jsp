<%@page import="common.Convert"%>
<%@page import="db.acess.VrCommitDao"%>
<%@page import="db.model.VrCommit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 删除留言</title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp" %>
	<%
		VrCommitDao vrCommitDao=new VrCommitDao();
		String idInUrl=request.getParameter("comment_id");
		boolean sure=request.getParameter("sure")!=null;
		if(idInUrl==null){
			Convert.alertAndBack(out, "请求参数非法！", 1);
			return;
		}
		int id=Integer.parseInt(idInUrl);
		VrCommit aCommit=vrCommitDao.findById(id);
		if(aCommit==null){
			Convert.alertAndBack(out, "啊呀，你查看的评论好像被删除了！", 1);
			return;
		}
		if(!vrCustomer.getCustId().equals(aCommit.getCustId())){
			Convert.alertAndBack(out, "你没有删除权限！", 1);
			return;
		}
		if(!sure){
			%>
			<script type="text/javascript">
				if(confirm("确认该评论删除吗？删除后无法恢复！")){
					window.location.href="/Venue_Reservation/main_pages/delete_comment.jsp?comment_id="
							+"<%=id %>&sure=";
				}else{
					history.go(-1);
				}
			</script>
			<% 
		}else{
			vrCommitDao.delete(id);
			Convert.alertAndJump(out, "删除成功！", "/Venue_Reservation/main_pages/my_comments.jsp");
		}
	%>
</body>
</html>