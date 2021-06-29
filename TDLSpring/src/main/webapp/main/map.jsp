<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>

<!-- 지도 search select section start -->
<section id="content">
	<div class="container">
		<form id="map-search" class="map-search" method="get" action="map.jsp">
			<legend>위치 검색</legend>
			<input type="text" id="searchDong" class="form-control" name="searchDong"  placeholder="동 이름 검색" autofocus>
			<input type="submit" value="검색" class="button button-rounded">
		</form>
	</div>
</section>
<!-- 지도 search select section end -->

<!-- 지도 map section start -->
<section id="content">
	<div class="container">
		<div id="map" style="width:100%; height:700px;">
		</div>
	</div>
</section>
<!-- 지도 section end -->

<!-- External JavaScripts
============================================= -->
<script src="/TDLSpring/js/jquery.js"></script>
<script type="text/javascript"  src="http://code.jquery.com/jquery-3.3.1.min.js" ></script>
<script src="/TDLSpring/js/plugins.js"></script>

<!-- Footer Scripts
============================================= -->
<script src="/TDLSpring/js/functions.js"></script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=365c7a93040d1f5d842f1c1fdae035f8&libraries=services"></script>
<script>

	var mapContainer = document.getElementById('map'),			//지도를 담을 영역의 DOM 레퍼런스
	mapOption = { //지도를 생성할 때 필요한 기본 옵션
		center: new daum.maps.LatLng(37.5666805, 126.9784147),	//지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	var map = new daum.maps.Map(mapContainer, mapOption); 		//지도 생성 및 객체 리턴
	var zoomControl = new daum.maps.ZoomControl();				//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
	var geocoder = new daum.maps.services.Geocoder();			//주소-좌표 변환 객체를 생성합니다
	function searchBtn(){//주소검색 변수 선언
		return getParam("searchDong");	
	}

//-------------------------정규식 파라미터값 받아오기--------------------------------------------
 var getParam = function(key){
     var _parammap = {};
     document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
         function decode(s) {
             return decodeURIComponent(s.split("+").join(" "));
         }
         _parammap[decode(arguments[1])] = decode(arguments[2]);
     });
     return _parammap[key];
 };

//--------------------------------------------------------------------------------------------


	geocoder.addressSearch(searchBtn(), function(result, status) {//주소로 좌표를 검색합니다 
	     if (status === daum.maps.services.Status.OK) {// 정상적으로 검색이 완료됐으면 
	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);    
	        map.setCenter(coords); // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	    } 
	});

$(function(){
	/* api 불러오기 1 */
	$.getJSON("http://openapi.seoul.go.kr:8088/5144656366616c7338364b4945547a/json/bikeList/1/1000", function(data){
		$.each(data.rentBikeStatus.row, function(){			
			var imageSrc;// 마커이미지의 주소입니다
			if(this.parkingBikeTotCnt>=7){
				imageSrc = '../tdl/img/map-marker-1.png';
			}else if(this.parkingBikeTotCnt>=4){
				imageSrc = '../tdl/img/map-marker-2.png';
			}else if(this.parkingBikeTotCnt>=1){
				imageSrc = '../tdl/img/map-marker-3.png';
			}else {
				imageSrc = '../tdl/img/map-marker-4.png';
			}
			
		    var imageSize = new daum.maps.Size(16, 24), // 마커이미지의 크기입니다
		    imageOption = {offset: new daum.maps.Point(8, 24)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		    
			// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption),
			    markerPosition = new daum.maps.LatLng(this.stationLatitude, this.stationLongitude); // 마커가 표시될 위치입니다
			
			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
			    position: markerPosition,
			    image: markerImage,
			    clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
			});
			
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			
			// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
			var iwContent = 
			'<div class="wrap">' + 
            '    <div class="info">' + 
            '        <div class="title">' + this.stationName +
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div>' + 
            '                <div>자전거 거치수 : ' + this.parkingBikeTotCnt + '</div>' +  
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';
            
			// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

			// 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
			    content : iwContent
			});

			// 마커에 클릭이벤트를 등록합니다
			daum.maps.event.addListener(marker, 'click', function(e) {
				// 마커 위에 인포윈도우를 표시합니다
				if(infowindow.getMap()){
					infowindow.close();
				}
				else{
					infowindow.open(map, marker);
				}
			});
			
		})//each
	})//JSON
	/* api 불러오기 2 */
	$.getJSON("http://openapi.seoul.go.kr:8088/5144656366616c7338364b4945547a/json/bikeList/1001/2000", function(data){
		$.each(data.rentBikeStatus.row, function(){
			
			/* 마커 이미지 설정 부분 */
			
			// 마커이미지의 주소입니다
			var imageSrc;
			
			if(this.parkingBikeTotCnt>=7){
				imageSrc = '../tdl/img/map-marker-1.png';
			}else if(this.parkingBikeTotCnt>=4){
				imageSrc = '../tdl/img/map-marker-2.png';
			}else if(this.parkingBikeTotCnt>=1){
				imageSrc = '../tdl/img/map-marker-3.png';
			}else {
				imageSrc = '../tdl/img/map-marker-4.png';
			}
			
		    var imageSize = new daum.maps.Size(16, 24), // 마커이미지의 크기입니다
		    imageOption = {offset: new daum.maps.Point(6, 24)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		    
			// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption),
			    markerPosition = new daum.maps.LatLng(this.stationLatitude, this.stationLongitude); // 마커가 표시될 위치입니다
			
			// 마커를 생성합니다
			var marker = new daum.maps.Marker({
			    position: markerPosition,
			    image: markerImage,
			    clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
			});
			
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			
			// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
			var iwContent =
        	'<div class="wrap">' + 
            '    <div class="info">' + 
            '        <div class="title">' + this.stationName +
            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div>' + 
            '                <div>자전거 거치수 : ' + this.parkingBikeTotCnt + '</div>' +  
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';
            
			// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

			// 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
			    content : iwContent
			});

			// 마커에 클릭이벤트를 등록합니다
			daum.maps.event.addListener(marker, 'click', function(e) {
				// 마커 위에 인포윈도우를 표시합니다
				if(infowindow.getMap()){
					infowindow.close();
				}
				else{
					infowindow.open(map, marker);
				}
			});
			
		})//each
	})//JSON
});//function

</script>





</body>
</html>