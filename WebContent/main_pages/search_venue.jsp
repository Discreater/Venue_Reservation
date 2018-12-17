<%@ page import="java.util.List"%>
<%@ page import="db.acess.VrVenueDao"%>
<%@ page import="db.model.VrVenue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统 - 查询结果</title>
<body>
	<%@ include file="/includes/header.jsp"%>
	<%
		request.setCharacterEncoding("UTF-8");
		//判断是否登陆：未登录：
		if (!loginStatus) {
	%>
	<script type="text/javascript">
		alert("请先登陆！");
		window.location.href = "/Venue_Reservation/user_act/login.jsp"
	</script>
	<%
		} else {
			//已登录：			
			String input = request.getParameter("search");
			boolean findAll = request.getParameter("findall") != null;
			String value = new String("");
			String msg = new String("请输入场馆名称");
			boolean enableTablePrint = request.getParameter("notprint") == null;
			if (input == null) {
				//first visit:
				enableTablePrint = false;
				value = new String(msg);
			} else {
				if (input.equals("") && !findAll) {
					//invalid input
					enableTablePrint = false;
				}
				value = new String(input);
			}
	%>
	<div>
	<form action="/Venue_Reservation/main_pages/search_venue.jsp">
		<input id="search" name="search" type="text" value="<%=value%>">
		<input type="submit" value="查找"> <input type="button"
			value="查找所有" onclick="window.location.href='/Venue_Reservation/main_pages/search_venue.jsp?search=&findall='">
	</form>
	</div>
	<%
		if (input != null && input.equals("") && !findAll) {
	%>
	<script type="text/javascript">
		alert("请输入场馆名称进行查找!");
		window.location.href = "/Venue_Reservation/main_pages/search_venue.jsp?search=%E8%AF%B7%E8%BE%93%E5%85%A5%E5%9C%BA%E9%A6%86%E5%90%8D%E7%A7%B0%0A&notprint=";
	</script>
	<%
		}
			if (enableTablePrint) {

				//行数与列数设置：
				int rawSize;//列数
				int colSize;//行数			
				VrVenue vrVenue = new VrVenue();
				VrVenueDao vrVenueDao = new VrVenueDao();
				if (findAll) {
					input = "";
				}
				List<VrVenue> allList = vrVenueDao.findPageByVenueName(input, vrVenueDao.findCount(), 1);
				colSize = allList.size();
				rawSize = 2;
				String[] headers = { "场馆名称", "场馆地址" };//表头
				String[] types = { "string", "string" };
				String[][] data = new String[colSize][rawSize];//数据
				//表头和属性赋值：
				//数据赋值:
				for (int raw = 0; raw < colSize; raw++) {
					vrVenue = allList.get(raw);
					data[raw][0] = vrVenue.getVenueName();
					data[raw][1] = vrVenue.getVenueAddress();
				}
	%>
	<!-- using script for sorting table -->
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
					href="/Venue_Reservation/main_pages/venue_info.jsp?venue_id=<%=allList.get(raw).getVenueId()%>">
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
	<%
		}
		}
	%>
	</div>
</body>
</html>