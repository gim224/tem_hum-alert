<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
<link href="<c:url value="/resources/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"
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

<script>
	$(document).ready(function() {
		updateData();
	});

	function updateData() {
		$.ajax({
			url : "/api/raspberry/sensor",
			dataType : "json",
			type : "GET",
			success : function(data) {
				$('#tem').html(data.temperature);
				$('#hum').html(data.humidity);
				$('#day').html(getTimeStamp());

			}

		});

		setTimeout("updateData()", 1000); //1 sec

	}

	function getTimeStamp() { // 24시간제
		var d = new Date();

		var s =

		leadingZeros(d.getHours(), 2) + ':' + leadingZeros(d.getMinutes(), 2)
				+ ':' + leadingZeros(d.getSeconds(), 2);

		return s;
	}

	function leadingZeros(n, digits) {
		var zero = '';
		n = n.toString();

		if (n.length < digits) {
			for (i = 0; i < digits - n.length; i++)
				zero += '0';
		}
		return zero + n;
	}
</script>
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
								<div class="ds-element-title">시간</div>
								<div class="ds-element-value ds-days" id="day">${date }</div>
							</div>

							<div class="ds-element ds-element-minutes">
								<div class="ds-element-title">온도(℃)</div>
								<div class="ds-element-value ds-minutes" id="tem">${temperature}
								</div>
							</div>
							<div class="ds-element ds-element-seconds">
								<div class="ds-element-title">습도(%)</div>
								<div class="ds-element-value ds-seconds" id="hum">${humidity}</div>
							</div>
						</div>

					</div>
					<div class="content3">
						<ul>
							<li><p>
									<a class="book popup-with-zoom-anim button-isi zoomIn animated"
										data-wow-delay=".5s" href="#small-dialog"><span
										class="fa fa-paper-plane-o"></span> Setting</a>
								</p></li>
							<li><p>
									<a class="read" href="<c:url value="/logout"/>"><span
										class="fa fa-search"></span> Logout</a>
								</p></li>
						</ul>
					</div>




					<div class="demo3" style="margin-top: 20px">

						<ol>
							<li style="font-size: 8px">최적 : 21~24 / 45~55</li>
							<li style="font-size: 8px">정상 : 16~28 / 40~70</li>
							<li style="font-size: 8px">위험 : 그 외</li>
						</ol>


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
	<script src="<c:url value="/resources/js/demo-1.js"/>"></script>
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
			<h3 class="sub-head-w3-agileits">Setting</h3>
			<hr />
			<br />
			<%-- 			<form:form action="/alertChanged" method="post" modelAttribute="user"> --%>
			<!-- 				<p class="popuptext"> -->
			<%-- 					E-mail : <form:radiobutton path="emailAlert" value="1" label="ON"/>   --%>
			<%-- 					<form:radiobutton path="emailAlert" value="0" label="OFF"/> --%>
			<!-- 				</p> -->
			<!-- 				<blockquote>24시간마다 E-mail이 전송됩니다.</blockquote> -->
			<!-- 				<br /> -->
			<!-- <!-- 				<p class="popuptext"> -->

			<!-- <!-- 					Android Notification : <input type="radio" name="android" -->

			<!-- <!-- 						value="ON"> ON <input type="radio" name="android" -->

			<!-- <!-- 						value="OFF" checked="checked">OFF -->

			<!-- <!-- 				</p> -->

			<!-- <!-- 				<blockquote>1시간마다 notification이 전송됩니다.</blockquote> -->

			<!-- <!-- 				<br /> -->

			<!-- 				<div class="cen"> -->
			<!-- 					<input type="submit" value="OK"> -->
			<!-- 				</div> -->
			<!-- 				<div class="clear"></div> -->
			<%-- 			</form:form> --%>

			<form action="/alertChanged" method="post" modelAttribute="user">
				<p class="popuptext">
					E-mail : <input type="radio" name="emailAlert" value="1"
						checked="checked" /> ON <input type="radio" name="emailAlert"
						value="0" /> OFF
				</p>
				<blockquote>※ e-mail에 on을 check하면, 1시간마다 E-mail이 전송됩니다.</blockquote>
				
				<br />
<%-- 				<p class="popuptext"><a href="<c:url value="/files/app-debug.zip"/>">download app</a></p> --%>
				<blockquote>※ 앱을 다운로드 시, 1시간마다 notification이 전송됩니다.</blockquote>


				<br />
				
				
				<div class="cen">
					<span><input type="submit" value="OK"></span>
				</div>



				<div class="clear"></div>
			</form>

			<div class="">
				<sec:authentication var="principal" property="principal" />
				<c:if test="${principal.username == 'gim224'}">
					<form action="/manager" method="post">
						<input type="submit" value="manager_page" />
					</form>
				</c:if>
			</div>

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