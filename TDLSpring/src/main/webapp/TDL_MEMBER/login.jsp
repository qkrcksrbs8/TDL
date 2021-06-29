<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String check = (String)request.getAttribute("check");	
%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- 템플릿 내용 start -->
	<link rel="stylesheet" href="../css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link rel="stylesheet" href="../css/dark.css" type="text/css" />
	<link rel="stylesheet" href="../css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="../css/animate.css" type="text/css" />
	<link rel="stylesheet" href="../css/magnific-popup.css" type="text/css" />

	<link rel="stylesheet" href="../css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <!-- 템플릿 내용 end -->
    
    <!-- tdl file start -->
    <link rel="stylesheet" href="../tdl/css/tdl.css" type="text/css" />
    <!-- tdl file end -->
    
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>

<!-- Document Wrapper
============================================= -->


	<!-- Content
	============================================= -->
	<section id="content">

		<div class="content-wrap nopadding">

			<div class="section nopadding nomargin" style="width: 100%; height: 100%; position: absolute; left: 0; top: 0; background: #fff;"></div>

			<div class="section nobg full-screen nopadding nomargin">
				<div class="container-fluid vertical-middle divcenter clearfix">

					<div class="center">
						<a href="../in/index.jsp"><img class="login-tdl-logo" src="../tdl/img/logo.png" alt="TDL Logo"></a>
					</div>

					<div class="card divcenter noradius noborder login-form-wrap" style="max-width: 400px;">
						<div class="card-body" style="padding: 40px;">
							<form id="login-form" name="login-form" class="nobottommargin" action="/TDLSpring/login.do" method="post">
								<h3>로그인</h3>

								<div class="col_full">
									<label>아이디:</label>
									<input type="text" id="TU_id" name="TU_id" class="form-control not-dark" required/>
								</div>

								<div class="col_full">
									<label>비밀번호:</label>
									<input type="password" id="TU_passwd" name="TU_passwd" class="form-control not-dark" required/>
									<%
										if(check != null){
									%>									
									<label style="color:red"><b>아이디 또는 비밀번호가 틀렸습니다.</b></label>
									<%}else{ %>
									<label></label>
									<%} %>
								</div>
								
								<div class="col_full nobottommargin">								
									<button class="button button-black nomargin" id="submit" name="submit" value="login">로그인</button>
									<!-- <a href="#" class="fright login-register-search">아이디/비밀번호 찾기</a> -->
								</div>
							</form>

						</div>
					</div>
					<br>
					<div class="center dark">
						<a id="login-home" class="button nomargin" href="index.jsp">메인으로</a>
					</div>
					<br>
					<div class="center dark text-black"><small>Copyrights &copy; All Rights Reserved by Canvas Inc.</small></div>
				</div>
			</div>

		</div>

	</section><!-- #content end -->

<!-- #wrapper end -->

<!-- Go To Top
============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- External JavaScripts
============================================= -->
<script src="../js/jquery.js"></script>
<script src="../js/plugins.js"></script>

<!-- Footer Scripts
============================================= -->
<script src="../js/functions.js"></script>

</body>
</html>