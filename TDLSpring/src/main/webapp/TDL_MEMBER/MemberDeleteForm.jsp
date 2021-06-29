<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/head.jsp"></jsp:include>
<%
	String check = (String)request.getAttribute("check");
%>
<section id="content" class="mypage-wrap">
	<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">

		<div class="tab-container">
		
				<div class="card nobottommargin">
					<div class="card-body" style="padding: 40px;">
						<center><h3>회원탈퇴</h3></center>

						<form id="register-form" name="register-form" class="nobottommargin" action="/TDLSpring/deleteMember.do" method="post">

							<div class="col_full">
								<label>패스워드:</label>
								<input type="password" id="password" name="TU_passwd" value="" class="form-control" required/>
							<%
								if(check != null){
							%>
								<label style="color:red">비밀번호가 틀렸습니다.</label>
							<%}%>		
							</div>
																	
														
							<center>
							<div class="col_full nobottommargin" >
								<button type="submit" class="button button-3d button-green nomargin" id="submit">회원탈퇴</button>
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
<!-- Footer Scripts end -->

</body>
</html>