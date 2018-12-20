<%@page import="common.Convert"%>
<%@page import="db.acess.*"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 用户留言 - 全部留言</title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp"%>
	<%
//行数与列数设置：
int rawSize;//列数
int colSize;//行数			
int pageSize=1;//页大小
VrCommitDao vrCommitDao=new VrCommitDao();
List<VrCommit> allList = vrCommitDao.findAll();
List<VrCommit> showList=new ArrayList<VrCommit>();
for(VrCommit aCommit:allList){
	if(!aCommit.getCommitState().equals("reject")){
		showList.add(aCommit);
		System.out.println("Comment :"+aCommit.getCommitContext());
	}
}//获取可见列表

int pageTotalNo=showList.size()/pageSize+showList.size()%pageSize==0?0:1;
colSize = showList.size();
rawSize = 3;
String[] headers = { "评论时间", "评论用户","评论内容" };//表头
String[] types = { "string", "string","string" };
String[][] data = new String[colSize][rawSize];//数据
//表头和属性赋值：
//数据赋值:
for (int raw = 0; raw < colSize; raw++) {
	 VrCommit aCommit= showList.get(raw);
	data[raw][0] = simpleDateFormat.format(aCommit.getCommitSubmitTime().getTime());
	data[raw][1] = Convert.CustIdToName(aCommit.getCustId());
	data[raw][2] = aCommit.getCommitContext();
}
for(int pageNo=0;pageNo<pageTotalNo;pageNo++){
	

%>
	<div>
		<table id="paged_table<%=pageNo+1 %>" class="sortable_table" <%=pageNo==0?"":"hidden=\"hidden\"" %>>
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
for (int raw = 0; pageSize*pageNo+raw<colSize; raw++) {
%>
				<tr>
					<%
	for (int col = 0; col < rawSize; col++) {
		int rawInList=pageNo*pageSize+raw;
%>
					<td>
						<!-- data here --> <%
if(col==2){
	String tmp=data[rawInList][col];
	String show=tmp.length()>15?tmp.substring(0,15)+"...":tmp;
	out.println("<a href=\"/Venue_Reservation/main_pages/comment_info.jsp?comment_id="+showList.get(rawInList).getCommitId()+"\">");
	out.println(show);
	out.println("</a>");
}else{
	out.println(data[pageNo*pageSize+raw][col]);
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
<%}
	out.println("<br>");
	out.println("<br>");
	out.println("<br>");
	out.println("<div>");
	for(int pageNo=0;pageNo<pageTotalNo;pageNo++){
		out.println("<button id=\"button"+(pageNo+1)+"\">"+(pageNo+1)+"</button>");
	}
	out.println("</div>");
%>
<script type="text/javascript">
function setPage(page){
	var totalPages=<%=pageTotalNo %>;
	for(var i=0;i<totalPages;i++){
		if(i!=page){
			$("#paged_table"+i).hide();
		}
		else{
			$("#paged_table"+i).show();
		}
	}
	var totalPages=<%=pageTotalNo %>;
	for(var i=0;i<totalPages;i++){
		$("#button"+i).click(function setPage(i));
	}
</script>

</body>
</html>