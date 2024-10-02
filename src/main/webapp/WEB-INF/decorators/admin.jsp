<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url value="/" var="URL"></c:url>

<!DOCTYPE html>
<html>
<head>


<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="${URL}assets/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Karma Shop</title>
	<!--
		css
		============================================= -->
	<link rel="stylesheet" href="${URL}assets/css/linearicons.css">
	<link rel="stylesheet" href="${URL}assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="${URL}assets/css/themify-icons.css">
	<link rel="stylesheet" href="${URL}assets/css/bootstrap.css">
	<link rel="stylesheet" href="${URL}assets/css/owl.carousel.css">
	<link rel="stylesheet" href="${URL}assets/css/nice-select.css">
	<link rel="stylesheet" href="${URL}assets/css/nouislider.min.css">
	<link rel="stylesheet" href="${URL}assets/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="${URL}assets/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="${URL}assets/css/magnific-popup.css">
	<link rel="stylesheet" href="${URL}assets/css/main.css">
	<link rel="stylesheet" href="${URL}assets/css/profile.css">
</head>

</head>
<body>
	<div><%@ include file="/common/admin/header.jsp"%></div>
	
	
	<div class="main">

		<sitemesh:write property="body"/>
	<!-- End related-product Area -->
	</div>
	
	<div><%@ include file="/common/admin/footer.jsp"%></div>
	
	
	<script src="${URL}assets/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="${URL}assets/js/vendor/bootstrap.min.js"></script>
	<script src="${URL}assets/js/jquery.ajaxchimp.min.js"></script>
	<script src="${URL}assets/js/jquery.nice-select.min.js"></script>
	<script src="${URL}assets/js/jquery.sticky.js"></script>
	<script src="${URL}assets/js/nouislider.min.js"></script>
	<script src="${URL}assets/js/countdown.js"></script>
	<script src="${URL}assets/js/jquery.magnific-popup.min.js"></script>
	<script src="${URL}assets/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="${URL}assets/js/gmaps.min.js"></script>
	<script src="${URL}assets/js/main.js"></script>
	
</body>
</html>