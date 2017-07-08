$(window).load(function() {
	// 预加载
	$('.body-loading').fadeOut();
});
// 预加载
$('body').append('<div class="body-loading"></div>');
if( $('.body-loading').length ){
    $('.body-loading').fadeIn();
}

$(document).ready(function() {
	
	$(".s-btn").click(function(){
	    $(".hide-sou").slideToggle();
	});
	$(".share .wx").hover(function(){
	    $(".share .hide-qr").stop().fadeToggle();
	});
	$('a.go-top').click(function(){ 
	   $('html, body').animate({scrollTop:0}, 'slow'); 
	});
	$(".TAB-CLICK li").click(function(){
		var tab=$(this).parent(".TAB-CLICK");
		var con=tab.attr("id");
		var on=tab.find("li").index(this);
		$(this).addClass('hover').siblings(tab.find("li")).removeClass('hover');
		$(con).eq(on).show().siblings(con).hide();
	});

	// 手机头部浮动
	$(window).scroll(function(){

	    if( $(window).scrollTop() > 50 ){
	        $('#cui-mobile-header').addClass('cui-mobile-header-fix');
	    }else{
	        $('#cui-mobile-header').removeClass('cui-mobile-header-fix');
	    };

	});

	// 菜单
	$('.menu-btn').click(function(e){
	    if( $('#cui-mobile-so-box').is(':visible') ){
	        $('#cui-mobile-so-box').slideUp(400);
	    };

	    $('#cui-mobile-pop-menu').stop().slideToggle(400);
	    e.stopPropagation();
	});
	$('#cui-mobile-pop-menu a.v1').click(function(){
	    if( $(this).next('dl').length > 0 ){
	        $(this).parents('li').siblings('li').removeClass('on');
	        $(this).parents('li').toggleClass('on');
	        $(this).parents('li').siblings('li').find('dl').stop().slideUp(400);
	        if( $(this).parents('li').hasClass('on') ){
	            $(this).parents('li').find('dl').stop().slideDown(400);
	        }else{
	            $(this).parents('li').find('dd').stop().slideUp(400);
	            $(this).parents('li').find('dl').stop().slideUp(400);
	        };
	        return false;
	    }
	});
	$('#cui-mobile-pop-menu dt a').click(function(){
	    $(this).parents('dl').siblings('dl').stop().slideToggle(400);
	    $(this).parents('dl').find('dd').stop().slideToggle(400);
	    return false;
	});

	$('#cui-mobile-pop-menu').click(function(e){
	    e.stopPropagation();
	});
	$('body').click(function(){
	    $('#cui-mobile-pop-menu').slideUp(400);
	    $('.search-btn').removeClass('search-btn-on');
	    $('#cui-mobile-so-box').stop().slideUp(300);
	});

	// 搜索框
	$('.search-btn').click(function(e){
	    if( $('#cui-mobile-pop-menu').is(':visible') ){
	        $('#cui-mobile-pop-menu').slideUp(300);
	    };

	    $(this).toggleClass('search-btn-on');
	    $('#cui-mobile-so-box').stop().slideToggle(400);
	    e.stopPropagation();

	    $('.moban-top').toggleClass('moban-top-on');
	});
	$('#cui-mobile-so-box').click(function(e) {
	    e.stopPropagation();
	});

});