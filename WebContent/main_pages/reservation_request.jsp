<%@page import="common.Convert"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="db.model.*" %>
<%@ page import="db.acess.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- loading venue info -->
<%@ include file="/includes/venue_id_handler.jsp" %>
<title>场馆预约 - <%=venueName%></title>
</head>
<body>
	<%@ include file="/includes/header_for_customer.jsp"%>

	<%
		VrOrderDao vrOrderDao=new VrOrderDao();
		Timestamp requestTime=new Timestamp(System.currentTimeMillis());		
		String startTimeInUrl=request.getParameter("start_time");
		String endTimeInUrl=request.getParameter("end_time");
		System.out.print(startTimeInUrl);
		Timestamp startTime=Convert.urlParamaterToTimestamp(startTimeInUrl);
		Timestamp endTime=Convert.urlParamaterToTimestamp(endTimeInUrl);
		List<VrOrder> vrOrders=vrOrderDao.findByVenueId(venueId, vrOrderDao.findCount(), 1);//获取所有与该场馆有关的预约
		VrOrder vrOrder=new VrOrder();
		vrOrder.setCustId(vrCustomer.getCustId());
		vrOrder.setUseStartTime(startTime);
		vrOrder.setUseEndTime(endTime);
		vrOrder.setVenueId(venueId);
		vrOrder.setOrdSubmitReason(request.getParameter("request_reason"));//创建订单，填入信息
		if(vrOrders.size()==0){
			//无预约，直接insert成功			
			vrOrderDao.insert(vrOrder);
		}else{
			//有预约，判断该时间段是否被占用/被预约
			boolean venueOccupied=false;//是否有通过的订单
			boolean venueRequested=false;//是否有相关订单
			Iterator iterator=vrOrders.iterator();
			while(iterator.hasNext()){//遍历所有同个场馆的订单
				VrOrder aVrOrder=(VrOrder)iterator.next();
				String orderStatus=aVrOrder.getOrdStatus();
				//以下逻辑可优化顺序，但此处为了清楚不作优化
				if("reject".equals(orderStatus)){//无需理会被拒绝的订单
					continue;
				}else if("wait".equals(orderStatus)){
					if(Convert.orderTimeConflict(aVrOrder, vrOrder)){//有待处理并且时间冲突的订单时
						venueRequested=true;
					}
				}else if("pass".equals(orderStatus)){//有通过并且时间冲突的订单时
					if(Convert.orderTimeConflict(aVrOrder, vrOrder)){
						venueOccupied=true;
						break;
					}
				}
			}
			//遍历结束后，判断标志变量
			if(venueOccupied){
%>
			<script type="text/javascript">
				alert("订单提交失败！原因：预约时间与其他成交订单冲突！");
			</script>
<%				
			}else if(venueRequested){
%>
			<script type="text/javascript">
				if(confirm("提示：当前订单可能和其他待办订单产生时间冲突，是否继续提交？")){
					
				}
			</script>
<%
			}else{
				vrOrderDao.insert(vrOrder);
%>
			<script type="text/javascript">
				alert("订单提交成功！");
			</script>
<%
			}
			
		}
		
	%>
</body>
</html>