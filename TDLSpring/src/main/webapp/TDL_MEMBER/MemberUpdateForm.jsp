<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/head.jsp"></jsp:include>

<section id="content" class="mypage-wrap">
	<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">

		<div class="tab-container">
		
				<div class="card nobottommargin">
					<div class="card-body" style="padding: 40px;">
						<h3>회원수정</h3>

						<form id="register-form" name="register-form" class="nobottommargin" action="/TDLSpring/updateMember.do" method="post">

							<div class="col_full">
								<label >아이디:</label>
								<input type="text" id="TU_id" name="TU_id" class="form-control" disabled="disabled" value="${TU_id }"/>															
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
								<input type="text" id="TU_name" name="TU_name" class="form-control" required value="${TU_name }"/>												
							</div>
				
							<div class="col_full">
								<label>이메일:</label>
								<input type="text" id="TU_email" name="TU_email" class="form-control" required value="${TU_email }"/>
							</div>

							<div class="col_full">
								<label>전화번호:</label>
								<input type="text" id="TU_phone" name="TU_phone" class="form-control" required value="${TU_phone }"/>
							</div>
							
														
							<center>
							<div class="col_full nobottommargin" >
								<button type="submit" class="button button-3d button-green nomargin" id="submit" >회원정보수정</button>
							</div>
							</center>
						</form>
					</div>
				</div>
		</div>
	</div>
</section><!-- #content end -->

<script src="/TDLSpring/js/jquery.js"></script>
<script src="/TDLSpring/js/plugins.js"></script>

<!-- Footer Scripts start -->
<script src="/TDLSpring/js/functions.js"></script>
<script type="text/javascript" src="/TDLSpring/js/MemberCheck.js"></script>
<!-- Footer Scripts end -->

</body>
</html>