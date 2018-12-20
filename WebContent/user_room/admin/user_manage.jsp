<%@ page import="db.acess.VrCustomerDao"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-用户管理</title>
<link href="/Venue_Reservation/css/table.css" type="text/css"
	rel="stylesheet">
	<script type="text/javascript"
	src="/Venue_Reservation/js/jquery-latest.js"></script>
</head>
<body>
	<%@ include file="/includes/header_for_admin.jsp"%>
	<br />
	<br />
	<br />
	<%@ include file="/user_room/admin/left_list.jsp"%>
	
		<%
			List<VrCustomer> customers = new ArrayList<VrCustomer>();
			VrCustomerDao vrCustomerDao = new VrCustomerDao();
			String type = request.getParameter("type");
			String input = request.getParameter("search");
			String nameChecked = "";
			String idChecked = "";
			if ("name".equals(type)) {
				customers = vrCustomerDao.findPage(input, vrCustomerDao.findCount(), 1);
				nameChecked = "checked";
				
			} else if ("id".equals(type)) {
				customers = new ArrayList<VrCustomer>();
				int id = 0;
				try{
					id = Integer.valueOf(input);
				}catch (Exception e){
					id = 0;
					System.err.println(id);
				}
				if(id!=0){
				customers.add(vrCustomerDao.findById(id));
				}
				idChecked = "checked";
			}
			else{
				nameChecked = "checked";
			}
			if(input==null){
				input="";
			}
		%>
		<div class="roomInfo">
		<h1>用户管理</h1>
		<div>
		<form action="/Venue_Reservation/user_room/admin/user_manage.jsp">
			<input id="search" name="search" type="text" value="<%=input%>">
			<input type="radio" name="type" value="name" <%=nameChecked %>>按昵称查找
			<input type="radio" name="type" value="id" <%=idChecked %>>按ID查找
			<input type="submit" value="查找">
		</form>
		
		<%
				//行数与列数设置：
				int rawSize;//列数
				int colSize;//行数			
				String[] headers = { "用户ID", "用户昵称","用户邮箱","真实姓名","电话号码","用户地址","创建时间" };//表头
				String[] types = { "number", "string","string","string","string","string","string" };
				colSize = customers.size();
				rawSize = headers.length;
				String[][] data = new String[colSize][rawSize];//数据
				//表头和属性赋值：
				//数据赋值:
				for (int raw = 0; raw < colSize; raw++) {
					VrCustomer tmp = customers.get(raw);
					data[raw][0] = tmp.getCustId().toString();
					data[raw][1] = tmp.getCustName();
					data[raw][2] = tmp.getCustEmail();
					data[raw][3] = tmp.getRealName();
					data[raw][4] = tmp.getCustPhone();
					data[raw][5] = tmp.getCustAddress();
					data[raw][6] = tmp.getCustDatetime().toString();
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
 					<a href="/Venue_Reservation/user_act/cust_info.jsp?cust_id=<%=customers.get(raw).getCustId()%>">
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
	</div>
</body>
</html>