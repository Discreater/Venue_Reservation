<%@page import="org.w3c.dom.Document"%>
<%@page import="common.Convert"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*"%>
<%@ page import="db.acess.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- loading venue info -->
<%@ include file="/includes/venue_id_handler.jsp"%>
<title>场馆预约 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp"%>
	<input type="text" hidden="hidden" value="true" id="jsconfirm"
		name="jsconfirm">

	<%
		VrOrderDao vrOrderDao = new VrOrderDao();
		Timestamp requestTime = new Timestamp(System.currentTimeMillis());
		String startTimeInUrl = request.getParameter("start_time");
		String endTimeInUrl = request.getParameter("end_time");
		String requestReason = request.getParameter("request_reason");
		String secondVisitStr = request.getParameter("jsconfirm");
		Timestamp startTime = Convert.urlParamaterToTimestamp(startTimeInUrl);
		Timestamp endTime = Convert.urlParamaterToTimestamp(endTimeInUrl);
		List<VrOrder> vrOrders = vrOrderDao.findByVenueId(venueId, vrOrderDao.findCount(), 1);//获取所有与该场馆有关的预约
		VrOrder vrOrder = new VrOrder();
		vrOrder.setCustId(vrCustomer.getCustId());
		vrOrder.setUseStartTime(startTime);
		vrOrder.setUseEndTime(endTime);
		vrOrder.setVenueId(venueId);
		vrOrder.setOrdSubmitReason(requestReason);//创建订单，填入信息
		boolean venueOccupied = false;//是否有通过的订单
		boolean venueRequested = false;//是否有相关订单
		boolean secondVisit = secondVisitStr != null;
		System.out.println(startTimeInUrl+secondVisitStr);
		if (!secondVisit) {
			System.out.println("First visit");
			if (vrOrders.size() == 0) {
				//无预约，直接设置标记			
				System.out.println("Relevant order list null.");
				venueOccupied = venueRequested = false;
			} else {
				//有预约，判断该时间段是否被占用/被预约

				Iterator<VrOrder> iterator = vrOrders.iterator();
				while (iterator.hasNext()) {//遍历所有同个场馆的订单
					VrOrder aVrOrder = iterator.next();
					String orderStatus = aVrOrder.getOrdStatus();
					//以下逻辑可优化顺序，但此处为了清楚不作优化
					if ("reject".equals(orderStatus)) {//无需理会被拒绝的订单
						continue;
					} else if ("wait".equals(orderStatus)) {
						if (Convert.orderTimeConflict(aVrOrder, vrOrder)) {//有待处理并且时间冲突的订单时
							venueRequested = true;
							System.out.println("Compete : order_id="+aVrOrder.getOrdId());
						}
					} else if ("pass".equals(orderStatus)) {//有通过并且时间冲突的订单时
						if (Convert.orderTimeConflict(aVrOrder, vrOrder)) {
							venueOccupied = true;
							System.out.println("Conflict : order_id="+aVrOrder.getOrdId());
							break;
						}
					}
				}
				//遍历结束后，判断标志变量
				if (venueOccupied) {
					Convert.alertAndBack(out, "订单提交失败！原因：预约时间与其他成交订单冲突！", 1);
		} else if (venueRequested) {
			System.out.println("Handling compete:");
	%>
	<script type="text/javascript">
				var jsconfirm;
				if(confirm("提示：当前订单可能和其他待办订单产生时间冲突，是否继续提交？")){
					//确认
					jsconfirm="true";
				}else{
					jsconfirm="false";					
				}

				var venueid=<%=venueId%>;
				var	starttime="<%=startTimeInUrl%>";
				var	endtime="<%=endTimeInUrl%>";
				var	requestreason="<%=requestReason%>";
				var url="/Venue_Reservation/main_pages/reservation_request.jsp";
				$.get(		url,
						{
							venue_id:venueid ,
							start_time:starttime ,
							end_time:endtime ,
							request_reason:requestreason ,
							jsconfirm:jsconfirm
						}
				);
				
			</script>
	<%
		} else {
					vrOrderDao.insert(vrOrder);
%>
	<script type="text/javascript">
				alert("订单提交成功！");
				history.go(-1);
			</script>
	<%
		}

			}
		} else if ("true".equals(secondVisitStr)) {//二次访问：
			System.out.println("Second visit");
			vrOrderDao.insert(vrOrder);
	%>
	<script type="text/javascript">
				alert("重新 提交 订单提交成功！");
				history.go(-2);
			</script>
	<%
		}else{
			%>
			<script type="text/javascript">
				alert("取消成功！");
				history.go(-2);
			</script>
			<%
		}
	%>
</body>
</html>