<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../main/head.jsp"></jsp:include>

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
				<li class="col-1 col-md-1 d-none d-md-block">번호</li>
				<li class="col-6 col-md-5">제목</li>
				<li class="col-3 col-md-2">작성자</li>
				<li class="col-2 col-md-2 d-none d-md-block">작성일</li>
				<li class="col-3 col-md-2">조회수</li>
			</ul>
		</div>
		<div class="board-list-wrap borard-list-con">
			<ul class="row">
				<li class="col-1 col-md-1 d-none d-md-block">번호</li>
				<li class="col-6 col-md-5">제목</li>
				<li class="col-3 col-md-2">작성자</li>
				<li class="col-2 col-md-2 d-none d-md-block">작성일</li>
				<li class="col-3 col-md-2">조회수</li>
			</ul>
			<ul class="row">
				<li class="col-1 col-md-1 d-none d-md-block">번호</li>
				<li class="col-6 col-md-5">제목</li>
				<li class="col-3 col-md-2">작성자</li>
				<li class="col-2 col-md-2 d-none d-md-block">작성일</li>
				<li class="col-3 col-md-2">조회수</li>
			</ul>
		</div>
	</div>
</section>

<!-- 자유게시판 list page paging -->
<section id="content" class="board-list-paging">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ul class="pagination">
				  <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
				  <li class="page-item"><a class="page-link" href="#">1</a></li>
				  <li class="page-item"><a class="page-link" href="#">2</a></li>
				  <li class="page-item"><a class="page-link" href="#">3</a></li>
				  <li class="page-item"><a class="page-link" href="#">4</a></li>
				  <li class="page-item"><a class="page-link" href="#">5</a></li>
				  <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
</section>

<!-- 자유게시판 list page search -->
<section id="content" class="board-list-search-wrap">
	<div class="container">
		<div class="row">
			<div class="col-12 col-md-2 nopadding form-row">
				<div class="col-4 col-md-12">
					<button class="btn btn-success write-btn btn-block">글쓰기</button>
				</div>
			</div>
			<div class="col-12 col-md-10  nopadding">
				<form>
					<div class="form-row">
						<div class="form-group  col-4 col-md-3 offset-md-4">
							<div class="white-section">
							<select id="inputState" name="search" class="form-control selectpicker">					
									<option value="TP_title">제목</option>
									<option value="subject_content">제목+본문</option>
									<option value="subject_writer">작성자</option>
								</select> 
							</div>
						</div>
						<div class="form-group col-5 col-md-4">
							<input type="text" class="form-control">
						</div>
						<div class="form-group col-3 col-md-1">
							<button type="submit" class="btn btn-success form-control"><i class="icon-line-search"></i></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<!-- External JavaScripts
============================================= -->
<script src="../js/jquery.js"></script>
<script src="../js/plugins.js"></script>

<!-- Footer Scripts start -->
<script src="../js/functions.js"></script>
<!-- Footer Scripts end -->

<!-- Bootstrap Select Plugin -->
<script src="../js/components/bs-select.js"></script>

<!-- Select Splitter Plugin -->
<script src="../js/components/selectsplitter.js"></script>

<!-- SLIDER REVOLUTION 5.x SCRIPTS  -->
	<script src="../include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script src="../include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

	<script src="../include/rs-plugin/js/extensions/revolution.extension.video.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.actions.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.navigation.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.migration.min.js"></script>
	<script src="../include/rs-plugin/js/extensions/revolution.extension.parallax.min.js"></script>

	<script>

		var tpj=jQuery;
		var revapi31;
		tpj(document).ready(function() {
			if(tpj("#rev_slider_679_1").revolution == undefined){
				revslider_showDoubleJqueryError("#rev_slider_679_1");
			}else{
				revapi31 = tpj("#rev_slider_679_1").show().revolution({
					sliderType:"standard",
					jsFileLocation:"../include/rs-plugin/js/",
					sliderLayout:"fullwidth",
					dottedOverlay:"none",
					hideThumbs:200,
					thumbWidth:100,
					thumbHeight:50,
					thumbAmount:5,
					navigation: {
	                    keyboardNavigation: "on",
	                    keyboard_direction: "horizontal",
	                    mouseScrollNavigation: "off",
	                    onHoverStop: "off",
	                    touch: {
	                        touchenabled: "on",
	                        swipe_threshold: 75,
	                        swipe_min_touches: 1,
	                        swipe_direction: "horizontal",
	                        drag_block_vertical: false
	                    }
	                },
					responsiveLevels:[1140,1024,778,480],
					visibilityLevels:[1140,1024,778,480],
					gridwidth:[1140,1024,778,480],
					gridheight:[700,768,960,720],
					lazyType:"none",
					shadow:0,
					spinner:"off",
					stopLoop:"off",
					stopAfterLoops:-1,
					stopAtSlide:-1,
					shuffle:"off",
					autoHeight:"off",
					fullScreenAutoWidth:"off",
					fullScreenAlignForce:"off",
					fullScreenOffsetContainer: "",
					fullScreenOffset: "0px",
					hideThumbsOnMobile:"off",
					hideSliderAtLimit:0,
					hideCaptionAtLimit:0,
					hideAllCaptionAtLilmit:0,
					debugMode:false,
					fallbacks: {
						simplifyAll:"off",
						nextSlideOnWindowFocus:"off",
						disableFocusListener:false,
					}
				});
			}

           
			revapi31.bind("revolution.slide.onchange",function (e,data) {
				SEMICOLON.slider.revolutionSliderMenu();
			});
		});	/*ready*/
	</script>

<script>
	$('.selectsplitter').selectsplitter();
</script>
</body>
</html>