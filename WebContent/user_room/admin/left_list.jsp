<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link type="text/css" href="/Venue_Reservation/css/menu.css"
	rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="/Venue_Reservation/js/room.js"></script>
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
		src="/Venue_Reservation/js/canvas-particle.js" ></script>

	<div>
		<ul>
			<li><a href="/Venue_Reservation/user_room/admin/user_manage.jsp">用户管理</a></li>
			<li><a href="/Venue_Reservation/user_room/admin/venue_manage.jsp">场馆管理</a></li>
			<li><a href="/Venue_Reservation/user_room/admin/order_manage.jsp">订单管理</a></li>
			<li><a href="/Venue_Reservation/user_room/admin/commit_manage.jsp">留言管理</a></li>
		</ul>
	</div>
