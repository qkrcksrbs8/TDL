<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/head.jsp"></jsp:include>

<section id="content" class="mypage-wrap">
	<div class="tabs divcenter nobottommargin clearfix" id="tab-login-register" style="max-width: 500px;">

		<div class="tab-container">
		
				<div class="card nobottommargin">
					<div class="card-body" style="padding: 40px;">
						<h3>마이페이지</h3>						

							<div class="col_full">
								<label >아이디:</label>
								<input type="text" id="TU_id" name="TU_id" class="form-control" disabled="disabled" value="${TU_id }"/>						
							</div>														

							<div class="col_full">
								<label>이름:</label>
								<input type="text" id="TU_name" name="TU_name" class="form-control" disabled="disabled" value="${TU_name }"/>												
							</div>

							<div class="col_full">
								<label>성별:</label><br>
								<input type="text" id="TU_gender" name="TU_gender" class="form-control" disabled="disabled" value="${TU_gender }"/>																	
							</div>	
							
							<div class="col_full">
								<label>이메일:</label>
								<input type="text" id="TU_email" name="TU_email" class="form-control" disabled="disabled" value="${TU_email }"/>
							</div>

							<div class="col_full">
								<label>전화번호:</label>
								<input type="text" id="TU_phone" name="TU_phone"  class="form-control" disabled="disabled" value="${TU_phone }"/>
							</div>																					
							<center>
							<div class="col_full nobottommargin" >
								<a href="/TDLSpring/MemberUpdateForm.do" class="button button-3d button-green nomargin" id="mem_update" name="TU_register">정보수정</a>
								<a href="/TDLSpring/TDL_MEMBER/MemberDeleteForm.jsp" class="button button-3d button-green nomargin" id="mem_delete" name="TU_register">회원탈퇴</a>
							</div>
							</center>
						
					</div>
				</div>
		</div>
	</div>
</section><!-- #content end -->

<script src="js/jquery.js"></script>
<script src="js/plugins.js"></script>

<!-- Footer Scripts start -->
<script src="js/functions.js"></script>
<!-- Footer Scripts end -->

</body>
</html>