<%@page import="db.acess.VrVenueDao"%>
<%@page import="db.model.VrVenue"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-个人空间</title>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@include file="/user_room/admin/left_list.jsp"%>
	<%
		List<VrVenue> venues = new ArrayList<>();
		VrVenueDao vrVenueDao = new VrVenueDao();
		String type = request.getParameter("type");
		String input = request.getParameter("search");
		if(input==null){
			input="";
		}
		String nameChecked = "";
		String idChecked = "";
		if ("name".equals(type)) {
			venues = vrVenueDao.findPageByVenueName(input, vrVenueDao.findCount(), 1);
			nameChecked = "checked";
			
		} else if ("id".equals(type)) {
			venues = new ArrayList<VrVenue>();
			int id = 0;
			try{
				id = Integer.valueOf(input);
			}catch (Exception e){
				id = 0;
				System.err.println(id);
			}
			if(id!=0){
				VrVenue tempVenue = vrVenueDao.findById(id);
				if(tempVenue != null){
				venues.add(vrVenueDao.findById(id));
				}
			}
			idChecked = "checked";
		}
		else{
			nameChecked = "checked";
		}
		
	%>
	<a href="/Venue_Reservation/user_room/admin/venue_info.jsp?venue_id=-1">
		<button>
			新建场馆
		</button>
	</a>
	<form action="/Venue_Reservation/user_room/admin/venue_manage.jsp"
		onsubmit="return checkVenuePara()">
		<input id="search" name="search" type="text" value="<%=input%>">
		<input type="radio" name="type" id="type" value="name"
			<%=nameChecked%>>按名称查找 <input type="radio" name="type"
			id="type" value="id" <%=idChecked%>>按ID查找 <input
			type="submit" value="查找">
	</form>
	
	
	<%
				//行数与列数设置：
				int rawSize;//列数
				int colSize;//行数			
				String[] headers = { "场馆ID", "场馆名称","拥有者","拥有者邮箱","场馆地址","场馆状态" };//表头
				String[] types = { "string", "string","string","string","string","string" };
				colSize = venues.size();
				rawSize = headers.length;
				String[][] data = new String[colSize][rawSize];//数据
				//表头和属性赋值：
				//数据赋值:
				for (int raw = 0; raw < colSize; raw++) {
					VrVenue tmp = venues.get(raw);
					data[raw][0] = tmp.getVenueId().toString();
					data[raw][1] = tmp.getVenueName();
					data[raw][2] = tmp.getVenueOwnerName();
					data[raw][3] = tmp.getVenueOwnerEmail();
					data[raw][4] = tmp.getVenueAddress();
					data[raw][5] = tmp.getVenueState();
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
					<!-- data here --> 
					<%
 						if (col == 0) {
 					%> 
 					<a href="/Venue_Reservation/user_room/admin/venue_info.jsp?venue_id=<%=venues.get(raw).getVenueId()%>">
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
</body>
</html>