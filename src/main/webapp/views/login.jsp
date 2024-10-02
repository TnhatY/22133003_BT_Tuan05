<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div
			class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
			<div class="col-first">
				<h1>Login/Register</h1>
				<nav class="d-flex align-items-center">
					<a href="${pageContext.request.contextPath}/home">Home<span
						class="lnr lnr-arrow-right"></span></a> <a
						href="${pageContext.request.contextPath}/login"
						style="margin-right: 5px;">Login</a>
					<p>/</p>
					<a href="${pageContext.request.contextPath}/register"
						style="margin-left: 5px;"> Register</a>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- End Banner Area -->


<!--================Login Box Area =================-->
<section class="login_box_area section_gap">
	<div class="container">
		<%String alertMsg = (String) request.getAttribute("alert");%>
				<%if (alertMsg != null) {%>
				<div class="alert alert-danger">
					<%=alertMsg%>
					</div><%}%>
		<div class="row">
			<div class="col-lg-6">
				<div class="login_box_img">
					<img class="img-fluid" src="${URL}assets/img/login.jpg" alt="">
					<div class="hover">
						<h4>New to our website?</h4>
						<p>There are advances being made in science and technology
							everyday, and a good example of this is the</p>
						<a class="primary-btn"
							href="${pageContext.request.contextPath}/register">Create an
							Account</a>
					</div>
				</div>
			</div>
				
			<div class="col-lg-6">
			
				
				<div class="login_form_inner">
					<h3>Login</h3>
					<form class="row login_form"
						action="${pageContext.request.contextPath}/login" method="post"
						id="contactForm" novalidate="novalidate">
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="name" name="username"
								placeholder="Username" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Username'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="name" name="password"
								placeholder="Password" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Password'">
						</div>
						<div class="col-md-12 form-group">
							<div class="creat_account">
								<input type="checkbox" id="f-option2" name="selector"> <label
									for="f-option2">Keep me logged in</label>
							</div>
						</div>
						<div class="col-md-12 form-group">
							<button type="submit" value="submit" class="primary-btn">Log
								In</button>
							<a href="${pageContext.request.contextPath}/checkUser">Forgot
								Password?</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Login Box Area =================-->


