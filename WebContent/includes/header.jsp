<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- link necessary files -->
<link href="/Venue_Reservation/css/img.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/info_card.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/list.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/login.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/menu.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/table.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/text_style.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/room.css" type="text/css" rel="stylesheet">
<link href="/Venue_Reservation/css/status.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/Venue_Reservation/js/canvas-particle.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/join_check.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/jquery.min.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/jquery-latest.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/login.js"></script>
<script type="text/javascript" src="/Venue_Reservation/js/sort_table.js"></script>


<div>
<p>
	<img  class="img" alt="img/vr_logo2.png" src="/Venue_Reservation/img/vr_logo2.png" width="60" height="60">
	<%@ include file="/includes/top_menu.jsp"  %>	
	<%@ include file="/includes/top_login.jsp" %>
	<%		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	%>
</p>
</div>
	<script type="text/javascript">
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}

			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript"
		src="/Venue_Reservation/js/canvas-particle.js" defer></script>
