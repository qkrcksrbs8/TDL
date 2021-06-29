<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
 <%
	String TU_id="테스트";
	String TN_id="";
%>
<jsp:include page="../main/head.jsp"/>

<!-- 자유게시판 list header -->
<section id="content" class="board-list-header-wrap">
	<div class="container">
		<h3 class="board-list-header"><i class="icon-clipboard-list" style="margin-right: 10px;"></i>자유게시판</h3>
	</div>
</section>


<section id="content">
	<div class="container board-view-con">
		<div class="board-view-tit">
			${article.TP_title }
		</div>
	</div>
</section>	

<section id="content">
	<div class="container board-view-con board-view-con1">
		<div class="board-view-info">
			<span><i class="icon-user-edit"></i>${article.TP_id }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span><i class="icon-clock"></i> ${article.TP_date }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span><i class="icon-line-eye"></i> 8</span>
		</div>
	</div>
</section>
	
<section id="content">
	<div class="container board-view-con">
		<div class="board-view-sub">
			<pre>${article.TP_content }</pre>
		</div>
	</div>
</section>	
	
		
<section id="content">
	<div class="container board-view-con board-view-con1">
		<div class="board-view-sub board-view-utilbtn">
<%-- 			<c:if test="${TN_id || article.TP_id==TU_id}"> --%>
				<a href="/TDLSpring/TDL_POST/TDLPostUpdate.do?TP_num=${article.TP_num}"><button class="btn btn-success">글수정</button></a>
				<a href="/TDLSpring/TDL_POST/TDLPostDelete.do?TP_num=${article.TP_num}"><button class="btn btn-success">글삭제</button></a>
		<%-- 	</c:if> --%>
				<a href="/TDLSpring/TDL_POST/TDLPostList.do"><button class="btn btn-success">글목록</button></a>
		</div>
	</div>
</section>				
	
	
<!-- 댓글시작 -->

<section id="content">
	<div class="container board-view-con">
		<div class="board-view-comments-tit">
			<i class="icon-comments"></i> 댓글
		</div>
		<div class="board-view-comments-form">
			<form action="/TDLSpring/TDL_Comment/TDLCommentWrite.do" name="writeform" method="POST" >
				<input type="hidden" name="TP_num"  value="${article.TP_num}">
				<input type="hidden" name="TP_id"  value="${article.TP_id}">
				<input type="hidden" name="TU_id" value="${TU_id}">
				

				<div class="form-group">
					<textarea class="form-control" id="CommentValue" name="TPC_content" rows="3" maxlength="2048"></textarea>		
						<button class="btn btn-success board-view-comments-submit" type="submit" >댓글쓰기</button>	
				</div>	
			</form>
		</div>
	</div>
</section>

<!-- 댓글 출력 -->

<section id="content">
	<div class="container board-view-con board-view-con1">
		<div class="board-view-comments-tit">
			<i class="icon-comments"></i> 댓글
		</div>
	</div>
</section>

<!-- forEach를 사용해 댓글 출력 -->
<c:if test="${sumCountC > 0 }">
	<c:set var="countC" value="1"/>
	<c:forEach var="articleC" items="${listC}" >

			<section id="content">
				<div class="container board-view-con">
					<div class="row">
						<div class="board-view-comments col-9">
							<div>
								<span><i class="icon-user-edit"></i> ${articleC.TPC_id }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>
								<i class="icon-clock"></i> ${articleC.TPC_date}작성 </span>
							</div> 
							<div class="board-view-comments-con">
								${articleC.TPC_content }
							</div>
							<div class="board-view-comments-delbtn">
								<form action="/TDLSpring/TDL_Comment/TDLCommentDelete.do" method="post">
										<button class="btn btn-success">댓글삭제</button>							 	
									<input type="hidden" name="TPC_num" value="${articleC.TPC_num}">
									<input type="hidden" name="countC" value="${countC}">
									<input id="likeAddr" type="hidden" name="likeAddr" value="${articleC.TPC_addr}">
									<input id="sumCount" type="hidden" name="sumCount" value="${sumCount}">		
									<input type="hidden" name="TP_num"  value="${article.TP_num}">
									<input type="hidden" name="TU_id" value="${TU_id}">
									<input type="hidden" name="TP_id" value="${article.TP_id }">
								</form>
								<c:set var="countC" value="${countC+1}" />		
							</div>
						</div>
						<div class="board-view-comments col-3">
						<!-- 좋아요 조건 수정 -->	
							<p class="comment-like text-center">${articleC.TPC_good}</p>	
								<c:set var="likeCheck" value="${likeCheck }"/>
								<c:set var="TPC_addr" value="${articleC.TPC_addr }"/>
								
							 	<c:set var="check" value="${fn:indexOf(likeCheck, TPC_addr)}"/>
							 	
							 	<c:if test="${check <0}">
									<form action="/TDLSpring/TDLLike/TDLLikeUp.do" method="post">								
										<p class="comment-like-btn text-center">			
											<button type="submit">									
													<font id="" class="icon-thumbs-up" color="gray" style="font-size:22"></font>																		
											</button>
										</p>	
										<input type="hidden" name="TU_id" value="test">
										<input type="hidden" name="TP_num" value="${article.TP_num }">
										<input type="hidden" name="TPC_addr" value="${articleC.TPC_addr }">
									</form>
								</c:if>
								
								<c:if test="${check > 0}">
									<form action="/TDLSpring/TDLLike/TDLLikeDown.do" method="post">								
										<p class="comment-like-btn text-center">			
											<button btye="submit">									
													<font id="" class="icon-thumbs-up" color="blue" style="font-size:22"></font>																		
											</button>
										</p>	
										<input type="hidden" name="TU_id" value="test">
										<input type="hidden" name="TP_num" value="${article.TP_num }">
										<input type="hidden" name="TPC_addr" value="${articleC.TPC_addr }">
									</form>
								</c:if>
								
						</div>
					</div>
				</div>					
			</section>		
	</c:forEach>							
</c:if>
 	

<script src="../js/jquery.js"></script>
<script src="../js/plugins.js"></script>
<script src="../js/functions.js"></script>
</body>
</html>