<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>场馆预约系统-个人空间</title>
</head>
<body>

	<%@ include file="/includes/header_for_customer.jsp"%>
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
		src="/Venue_Reservation/js/canvas-particle.js"></script>
	<div>
		<form>
			
		</form>
	</div>
	
</body>
</html>