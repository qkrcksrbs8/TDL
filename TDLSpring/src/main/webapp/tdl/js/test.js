
var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.5666805, 126.9784147),
    zoom: 11,
    mapTypeId: naver.maps.MapTypeId.NORMAL
});

var infowindow = new naver.maps.InfoWindow();

function onSuccessGeolocation(position) {
    var location = new naver.maps.LatLng(position.coords.latitude,
                                         position.coords.longitude);

    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
    map.setZoom(11); // 지도의 줌 레벨을 변경합니다.

    console.log('Coordinates: ' + location.toString());
}

function onErrorGeolocation() {
    var center = map.getCenter();
}

$(window).on("load", function() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
    } else {
        var center = map.getCenter();
    }
});

/* 마커표시 */

$(function(){
	/*기존 JSON json 파일 index값 1 ~ 1480까지*/
	//$.getJSON("http://openapi.seoul.go.kr:8088/5144656366616c7338364b4945547a/json/bikeList/1/1000", function(data){
		//$.each(data.rentBikeStatus.row, function(){
			/* 마커표시 부분*/
			//var marker = new naver.maps.Marker({
			    //position: new naver.maps.LatLng(this.stationLatitude, this.stationLongitude),
			    //map: map
			//})
		//})//each
	//})//getJSON
	$.getJSON("http://openapi.seoul.go.kr:8088/5144656366616c7338364b4945547a/json/bikeList/1001/1480", function(data){
		$.each(data.rentBikeStatus.row, function(){
			/* 마커표시 부분*/
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(this.stationLatitude, this.stationLongitude),
			    map: map
			    
			})
		})//each
	})//getJSON
	
});

/*test*/

