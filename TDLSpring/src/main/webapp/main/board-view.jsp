<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>

<!-- 자유게시판 list header -->
<section id="content" class="board-list-header-wrap">
	<div class="container">
		<h3 class="board-list-header"><i class="icon-clipboard-list" style="margin-right: 10px;"></i>자유게시판</h3>
	</div>
</section>

<!-- 자유게시판 list wrap -->
<section id="content">
	<div class="container">
		<div class="board-list-wrap board-list-header">
			<ul class="row">
				<li class="col-md-1 col-xs-1">글번호</li>
				<li class="col-md-6 col-xs-6">글제목</li>
				<li class="col-md-2 col-xs-2">작성자</li>
				<li class="col-md-2 col-xs-2">작성일</li>
				<li class="col-md-1 col-xs-1">조회수</li>
			</ul>
		</div>
		<div class="board-list-wrap borard-list-con">
			<ul class="row">
				<li class="col-md-1 col-xs-1">1</li>
				<li class="col-md-6 col-xs-6"><a href="#">test글</a></li>
				<li class="col-md-2 col-xs-2">홍길동</li>
				<li class="col-md-2 col-xs-2">2018-02-03</li>
				<li class="col-md-1 col-xs-1">12</li>
			</ul>
			<ul class="row">
				<li class="col-md-1 col-xs-1">1</li>
				<li class="col-md-6 col-xs-6"><a href="#">test글</a></li>
				<li class="col-md-2 col-xs-2">홍길동</li>
				<li class="col-md-2 col-xs-2">2018-02-03</li>
				<li class="col-md-1 col-xs-1">12</li>
			</ul>
		</div>
	</div>
</section>

<!-- 자유게시판 list page search -->
<section id="content">
	<div class="container">
		<form class="board-list-search-wrap" name="" id="" method="get" action="">
			<fieldset>
				<legend>자유게시판 검색</legend>
				<select class="board-list-search-select">
					<option>제목+내용</option>
					<option>작성자</option>
				</select>
				<input class="board-list-search-input" type="text" name="" id="" placeholder="검색">
				<button class="board-list-search-btn button button-dark button-rounded" type="submit" value="검색" id=""><i class="icon-line-search"></i></button>
			</fieldset>
		</form>
	</div>
</section>

</body>
</html>