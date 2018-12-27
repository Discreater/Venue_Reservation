<%@page import="db.acess.VrAdminDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="db.acess.VrCommitDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-新闻管理</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
		<div class="roomInfo">
	<h1>新闻管理</h1>
	<a href="/Venue_Reservation/user_room/admin/news_new.jsp"><button>发布新闻</button></a>
	<%
		VrCommitDao vrCommitDao = new VrCommitDao();
		List<VrCommit> allList = null;
		allList = vrCommitDao.findAll();
		List<VrCommit> list = new ArrayList<>();
		Iterator<VrCommit> iterator = allList.iterator();
		while(iterator.hasNext()){
			VrCommit itCommit = iterator.next();
			if("news".equals(itCommit.getCommitType())){
				list.add(itCommit);
			}
		}
		
		//行数与列数设置：
		int rawSize;//列数
		int colSize;//行数			
		String[] headers = { "新闻ID", "新闻内容", "发布时间", "发布者", "新闻状态"};//表头
		String[] types = { "number", "string", "string", "string","string"};
		colSize = list.size();
		rawSize = headers.length;
		String[][] data = new String[colSize][rawSize];//数据
		//表头和属性赋值：
		//数据赋值:
		for (int raw = 0; raw < colSize; raw++) {
			VrCommit tmp = list.get(raw);
			data[raw][0] = tmp.getCommitId().toString();
			String cmt=tmp.getCommitContext();
			data[raw][1] = cmt.length()>15?cmt.substring(0, 15)+"...":cmt;
			data[raw][2] = tmp.getCommitSubmitTime().toString();
			try{
			data[raw][3] = new VrAdminDao().findById(tmp.getAdminId()).getAdminName();
			}catch(Exception e){
				data[raw][3] = "null";
			}
			data[raw][4] = tmp.getCommitState();
		}
	%>
	<!-- using script for sorting table -->
	<script type="text/javascript"
		src="/Venue_Reservation/js/sort_table.js"></script>

	<div>
		<table id="tableSort" class="sortable_table">
			<thead>
				<tr>
					<%
						for (int col = 0; col < rawSize; col++) {
					%>
					<th type="<%=types[col]%>">
						<!-- data here --> <%=headers[col]%>
					</th>
					<%
						}
					%>
				</tr>
			</thead>
			<tbody>
				<%
					for (int raw = 0; raw < colSize; raw++) {
				%>
				<tr>
					<%
						for (int col = 0; col < rawSize; col++) {
					%>
					<td>
						<!-- data here --> <%
 	if (col == 0) {
 %> <a
						href="/Venue_Reservation/user_room/admin/news_info.jsp?id=<%=list.get(raw).getCommitId()%>">
							<%=data[raw][col]%>
					</a> <%
 	} else {
 %> <%=data[raw][col]%> <%
 	}
 %>


					</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="<%=rawSize%>">再怎么找也没有啦!</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
</body>
</html>