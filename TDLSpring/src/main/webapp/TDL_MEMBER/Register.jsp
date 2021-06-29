<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400i,700|Raleway:300,400,500,600,700|Crete+Round:400i" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="../css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link rel="stylesheet" href="../css/dark.css" type="text/css" />
	<link rel="stylesheet" href="../css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="../css/animate.css" type="text/css" />
	<link rel="stylesheet" href="../css/magnific-popup.css" type="text/css" />

	<link rel="stylesheet" href="../css/responsive.css" type="text/css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<!-- Document Title
	============================================= -->
	<title>Login - Layout 2 | Canvas</title>
	<style>
		#checkId{
			margin-top:10px;
			float:right;
		}
		#tab-login-register{
			margin-bottom: 50px !important;
		}
		.login-tdl-logo {
			max-height: 150px;
		}
		#idResult{
			margin-top:20px;
		}
		.radio-inline{
			margin-left:50px;
		}
	</style>

</head>

<body class="stretched">
	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">

		<!-- Page Title
		============================================= -->


		<div class="center">
			<a href="index.jsp"><img class="login-tdl-logo" src="../tdl/img/logo.png" alt="TDL Logo"></a>
		</div>
		

		<!-- Content
		============================================= -->
		<section id="content">
					<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">

						<div class="tab-container">
						
								<div class="card nobottommargin">
									<div class="card-body" style="padding: 40px;">
										<h3>회원 가입</h3>

										<form id="register-form" name="register-form" class="nobottommargin" action="/TDLSpring/register.do" method="post">

											<div class="col_full">
												<label >아이디:</label>
												<input type="text" id="TU_id" name="TU_id" class="form-control" required/>
												<label id="idResult"></label>
												<input type="button" class="button button-3d button-green" id="checkId" name="checkId" onclick="" value="중복체크">
											</div>
			
											<div class="col_full">
												<label>패스워드:</label>
												<input type="password" id="password" name="TU_passwd" value="" class="form-control" required/>
											</div>

											<div class="col_full">
												<label>패스워드 확인:</label>
												<input type="password" id="password_check" name="TU_passwd_check" value="" class="form-control" required/>												
											</div>
											<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
											<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
											

											<div class="col_full">
												<label>이름:</label>
												<input type="text" id="TU_name" name="TU_name" class="form-control" required/>												
											</div>

											<div class="col_full">
												<label>성별:</label><br>
												<label class="radio-inline">
													남자 <input type="radio" id="TU_gender" name="TU_gender" value="남자" class="form-control" required>
												</label>
												
												<label class="radio-inline">
													여자 <input type="radio" id="TU_gender" name="TU_gender" value="여자" class="form-control" required>
												</label>												
											</div>	
											
											<div class="col_full">
												<label>이메일:</label>
												<input type="text" id="TU_email" name="TU_email" value="" class="form-control" required/>
											</div>

											<div class="col_full">
												<label>전화번호:</label>
												<input type="text" id="TU_phone" name="TU_phone" value="" class="form-control" required/>
											</div>
											
																		
											<center>
											<div class="col_full nobottommargin" >
												<button type="submit" class="button button-3d button-green nomargin" id="submit" name="TU_register" value="register">가입하기</button>
											</div>
											</center>
										</form>
									</div>
								</div>
						</div>
					</div>


		</section><!-- #content end -->

	</div><!-- #wrapper end -->

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
	<script language="JavaScript" src="../js/Idcheck.js"></script>
	<script language="JavaScript" src="../js/prototype.js"></script>
	<script type="text/javascript" src="../js/MemberCheck.js"></script>
	
</body>
</html>