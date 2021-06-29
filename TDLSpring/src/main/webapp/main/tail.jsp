<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 템플릿 script start-->
<script src="../js/jquery.js"></script>
<script src="../js/plugins.js"></script>
<!-- 템플릿 script end-->

<!-- Footer Scripts start -->
<script src="../js/functions.js"></script>
<!-- Footer Scripts end -->

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
    tpj.noConflict();

    tpj(document).ready(function() {

        var apiRevoSlider = tpj('#rev_slider_k_fullwidth').show().revolution(
        {
            sliderType:"standard",
            sliderLayout:"fullwidth",
            navigation: {
                arrows:{enable:false}
            },
            responsiveLevels:[1240,1024,778,480],
            visibilityLevels:[1240,1024,778,480],
            gridwidth:[1240,1024,778,480],
            gridheight:[600,768,960,720],
        });

        apiRevoSlider.bind("revolution.slide.onloaded",function (e) {
            setTimeout( function(){ SEMICOLON.slider.sliderParallaxDimensions(); }, 400 );
        });

        apiRevoSlider.bind("revolution.slide.onchange",function (e,data) {
            SEMICOLON.slider.revolutionSliderMenu();
        });

    });

</script>


</body>
</html>