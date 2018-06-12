<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- Html -->
<html lang="kr">
<!-- Head -->
<head>
<title>Site Coming Soon a Flat Responsive Widget Template ::
	w3layouts</title>
<!-- Meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Site Coming Soon Widget Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- Meta tags -->


<link href="<c:url value="/resources/css/popup-box.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources//css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources//css/style.css"/>" rel="stylesheet"
	type="text/css" media="all" />
<!-- stylesheet -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.1.4.min.js"/>"></script>
<!-- Supportive-JavaScript -->

<!--fonts-->
<link
	href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=cyrillic,cyrillic-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Quattrocento+Sans:400,400i,700,700i&amp;subset=latin-ext"
	rel="stylesheet">
<!--/fonts-->
</head>
<!-- //Head -->

<!-- Body -->
<body>
	<!-- main-section -->
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="myCanvas"></canvas>
				<div class="main-title">
					<h1>
						Be under Development...<br /> by GT.kim
					</h1>
					<p class="para">Temperature & Humidity alert server for Kimpo..</p>
					<div class="demo2">

						<div class="demo2 dsCountDown ds-black">
							<div class="ds-element ds-element-days">
								<div class="ds-element-title">date</div>
								<div class="ds-element-value ds-days" >${date}</div>
							</div>
							<div class="ds-element ds-element-hours">
								<div class="ds-element-title">
									<c:out value="<temp>" escapeXml="true"></c:out>
								</div>
								<div class="ds-element-value ds-hours" >...</div>
							</div>
							<div class="ds-element ds-element-minutes">
								<div class="ds-element-title">temperature</div>
								<div class="ds-element-value ds-minutes"
									>${temperature}℃</div>
							</div>
							<div class="ds-element ds-element-seconds">
								<div class="ds-element-title">humidity</div>
								<div class="ds-element-value ds-seconds"
									>${humidity}%</div>
							</div>
						</div>

					</div>
					<div class="content3">
						<ul>
							<li><p>
									<a class="book popup-with-zoom-anim button-isi zoomIn animated"
										data-wow-delay=".5s" href="#small-dialog"><span
										class="fa fa-paper-plane-o"></span> Notify Me</a>
								</p></li>
							<li><p>
									<a class="read" href="#"><span class="fa fa-search"></span>
										Learn More</a>
								</p></li>
						</ul>
					</div>
					<p class="agileinfo txt-center">&copy; 2018 Site Coming Soon...
						Be developed by GT.kim, kr-cse</p>
					<!-- <p class="agileinfo txt-center"> &copy; 2018 Site Coming Soon. All Rights Reserved | Design by  <a href="http://w3layouts.com/"> W3layouts</a></p> -->
				</div>
			</div>
		</div>
	</div>
	<!-- /main-section -->

	<!-- Counter required files -->
	<link rel='stylesheet'
		href='<c:url value="/resources/css/dscountdown.css"/>' type='text/css'
		media='all' />
	<script type="text/javascript"
		src="<c:url value="/resources/js/dscountdown.min.js"/>"></script>
	<script src="<c:url value="js/demo-1.js"/>"></script>
	<!-- 	<!-- 		<script> -->
	-->
	<!-- 	// jQuery(document).ready(function($){ // $('.demo2').dsCountDown({ // -->
	<!-- 	endDate: new Date("December 24, 2020 23:59:00"), // theme: 'black' // -->
	<!-- 	}); // }); -->
	<!-- 		</script> -->
	<!-- //Counter required files -->

	<!-- particles effect -->
	<script src="<c:url value="/resources/js/particles.min.js"/>"></script>
	<script>
		window.onload = function() {
			Particles.init({
				selector : '#myCanvas',
				color : '#888888',
				connectParticles : true,
				minDistance : 70
			});
		};
	</script>
	<!-- //particles effect -->

	<div class="pop-up">
		<div id="small-dialog" class="mfp-hide book-form">
			<h3 class="sub-head-w3-agileits">Subscribe Us</h3>
			<p class="popuptext">Be the first to know when our site is ready</p>
			<form action="#" method="post">
				<input type="email" placeholder="Enter Your Email" required="">
				<input type="Submit">
				<div class="clear"></div>
			</form>
		</div>
	</div>
	<div class="pop-up">
		<div id="small-dialog2" class="mfp-hide book-form">
			<h3 class="sub-head-w3-agileits">Launching Soon</h3>
			<span class="fa fa-paper-plane-o"></span>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Curabitur varius metus et consequat maximus lorem. Pellentesque a
				est sagittis urabitur.</p>
			<div class="address">
				<p>
					<span class="bold">Address</span> : <span class="fa fa-map-marker"></span>
					USA Parkway, Silver Springs, NV, USA
				</p>
				<p>
					<span class="bold">Contact</span> : <span class="fa fa-phone"></span>
					+0 123 446 987
				</p>
				<p>
					<span class="bold">Mail </span> :<span class="fa fa-envelope"></span>
					<a href="mailto:info@example.com">info@example.com</a>
				</p>
			</div>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d19454557.19634976!2d-132.64465989095385!3d53.47160766892698!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5309b282a82419b5%3A0xb0a9479a409b8e9e!2sAlberta%2C+Canada!5e0!3m2!1sen!2sin!4v1510641039780"></iframe>
		</div>
	</div>

	<!--popup-js-->
	<script src="<c:url value="/resources/js/jquery.magnific-popup.js"/>"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

		});
	</script>
	<!--//popup-js-->

</body>
<!-- //Body -->

</html>
<!-- //Html -->