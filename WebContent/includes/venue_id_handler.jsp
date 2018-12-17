<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="db.acess.VrVenueDao"%>
<%@ page import="db.model.VrVenue"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<!-- loading venue info -->
<%
	VrVenueDao vrVenueDao = new VrVenueDao();
	VrVenue thisVrVenue = null;
	boolean idOk = true;
	String venueName=null;
	String venueId = request.getParameter("venue_id");
	if (venueId == null) {
		idOk = false;
	} else {
		thisVrVenue = vrVenueDao.findById(Integer.parseInt(venueId));
	}if(thisVrVenue==null){
		idOk=false;
%>
<script type="text/javascript">
	alert("请求参数出错！");
	window.history.back();
</script>
<%
	} else {		
		venueName=new String(thisVrVenue.getVenueName());
	}
%>
</div>
</body>
</html>