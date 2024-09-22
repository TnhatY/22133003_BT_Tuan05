<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@include file="/views/login.jsp"%>
	</div>
	<div> Trong thư mục decorators: tạo layout file web.jsp Gọi
		trang chung header.jsp sitemesh:write property = "body" /> Gọi trang
		content riêng</div>
	<div>
		<%@include file="/views/home.jsp"%>
	</div>
</body>
</html>