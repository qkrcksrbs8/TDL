<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String TU_id="테스트";
%>
<jsp:include page="../main/head.jsp"/>

		
<!-- 자유게시판 list header -->
<section id="content" class="board-list-header-wrap">
	<div class="container">
		<h3 class="board-list-header"><i class="icon-clipboard-list" style="margin-right: 10px;"></i>자유게시판</h3>
	</div>
</section>		
		
		
<!-- 자유게시판 write wrap -->
<section id="content" class="board-write-con-wrap">
	<div class="container">		
		
		<div class="form-widget">

			<div class="form-result"></div>
		
				<form class="nobottommargin" id="template-contactform" name="writeform" 
				action="/TDLSpring/TDL_NOTICE/TDLNoticeUpdate.do" method="post" onsubmit="return writeSave()">

				<div class="form-process"></div>
				
			
			<input type="hidden" name="TN_num" value="${articleN.TN_num }">
			<input type="hidden" name="TU_id" value="${TU_id }">
			
				<div class="col_full">
					<label for="template-contactform-subject">제목 <small>*</small></label>
					<input type="text" id="template-contactform-subject" name="TN_title" value="${articleN.TN_title}" class="required sm-form-control" />
				</div>
			
				
				<div class="clear"></div>

				<div class="col_full">
					<label for="template-contactform-message">내용 <small>*</small></label>
					<textarea class="required sm-form-control" id=""  name="TN_content" rows="6" cols="30">${articleN.TN_content}</textarea>
				</div>
	
				<div class="col_full hidden">
					<input type="text" id="template-contactform-botcheck" name="template-contactform-botcheck" value="" class="sm-form-control" />
				</div>
				
				<div class="row">
					<div class="col-6 col-sm-6">
						<a href="/TDLSpring/TDL_NOTICE/TDLNoticeList.do"><button class="btn btn-success">목록으로</button></a>
					</div>
					
					<div class="col-6 col-sm-6 text-right">
						<button id="sub" class="btn btn-success" type="submit" >글수정</button>
					</div>
				</div>	
				</form>
		</div>
	</div>
</section>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script>
		
		function writeSave(){
		
			if(document.writeform.subject.value==""){
			  alert("제목을 입력하십시요.");
			  document.writeform.subject.focus();
			  return false;
			}
			
			if(document.writeform.content.value==""){
			  alert("내용을 입력하십시요.");
			  document.writeform.content.focus();
			  return false;
			}
		        
		 }    
		</script>

<script src="js/jquery.js"></script>
<script src="js/plugins.js"></script>

<!-- Footer Scripts start -->
<script src="js/functions.js"></script>
<!-- Footer Scripts end -->

</body>
</html>

