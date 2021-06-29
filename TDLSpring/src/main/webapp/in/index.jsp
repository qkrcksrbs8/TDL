<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../main/head.jsp"></jsp:include>

<section id="slider" class="slider-element slider-parallax main-slide" style="background: url('<%=request.getContextPath()%>/tdl/img/slide1.jpg'); background-size: contain;" data-height-xl="670" data-height-lg="500" data-height-md="400" data-height-sm="250" data-height-xs="200">
	<div class="slider-parallax-inner">
		<div class="container clearfix">
			<div class="vertical-middle center">
				<div class="heading-block nobottomborder center">
					<h1>
						<div class="text-rotater" data-separator="|" data-rotate="flipInX" data-speed="3500">
							서울자전거 따릉이는 <span class="t-rotate">시민들의 삶의 질 향상|교통체증 해결|고유가 문제해결|건강한 사회|대기오염 감소</span>
						</div>
					</h1>
				</div>
			</div>
		</div> 
	</div>
</section>

<!-- OurTeam start -->
<section id="content">
    <div class="content-wrap teaminfo-wrap">
        <div class="container clearfix">
            <div class="heading-block topmargin-sm center">
                <h3>Meet Our Team</h3>
            </div>
            <div class="row">

                <div class="col-lg-3 col-6 bottommargin fadeInLeft animated">
                    <div class="team">
                        <div class="team-image">
                            <img src="<%=request.getContextPath()%>/images/team/2.jpg" alt="Josh Clark">
                        </div>
                        <div class="team-desc team-desc-bg">
                            <div class="team-title"><h4>박찬균</h4><span>Board</span></div>
                        </div>
                    </div>
                </div> 
            </div>

        </div>
    </div>
</section>
<!-- OurTeam end -->
 
<!-- Client start -->
<section id="content">
	<div class="content-wrap development">
		<div class="container clearfix">
		
			<div class="heading-block topmargin-sm center">
                <h3 class="center">프로젝트 개발 환경</h3>
            </div>
	
			<div id="oc-clients-full" class="owl-carousel image-carousel carousel-widget" data-margin="30" data-nav="false" data-loop="true" data-autoplay="2000" data-pagi="false" data-items-xs="3" data-items-sm="4" data-items-md="5" data-items-lg="6" data-items-xl="8">

				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/java.png" alt="java"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/jsp.png" alt="jsp"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/spring.png" alt="spring"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/mysql.png" alt="mysql"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/tomcat.png" alt="tomcat"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/html5.png" alt="html5"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/bootstrap.png" alt="bootstrap"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/css3.png" alt="css3"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/javascript.png" alt="javascript"></a>
				<a href="#"><img src="<%=request.getContextPath()%>/tdl/img/development/jquery.png" alt="jquery"></a>

			</div>
		</div>
	</div>
</section>
<!-- Client end -->

<!-- 템플릿 script start-->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/plugins.js"></script>
<!-- 템플릿 script end-->

<!-- Footer Scripts start -->
<script src="<%=request.getContextPath()%>/js/functions.js"></script>
<!-- Footer Scripts end -->

<!-- SLIDER REVOLUTION 5.x SCRIPTS  -->
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.video.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.actions.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.navigation.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.migration.min.js"></script>
	<script src="<%=request.getContextPath()%>/include/rs-plugin/js/extensions/revolution.extension.parallax.min.js"></script>

	




</body>
</html>