<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="webindexurl" value="http://zhanglab.ci.gxnu.edu.cn/web-file/upload/index/" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>数据挖掘实验室</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="DM多源信息大数据实验室,广西师范大学lab207实验室,张师超数据挖掘实验室,多媒体应用,医学图像分类,属性约简理论,HASHING,图像和视频分类,广西师范大学计信学院大数据实验室,大数据,数据挖掘,模式识别,机器学习">
<meta name="description"
	content="大数据挖掘中心于2014年成立，研究方向包括数据挖掘、机器学习、医学图像分类，特别集中在属性约简理论及其在HASHING,图像和视频分类等应用,致力于广西师范大学计算机科学与技术学科在机器学习和模式识别处理方向的学科建设，团队建设，人才培养，科学研究与技术应用。建设的目标是从事国际最前沿、最顶尖的学术研究，同时培养杰出人才，承担国家重大科研项目和转化科研成果。">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="/res/tech/css/cui.css">
<link rel="stylesheet" href="/res/tech/css/default.css">
<link rel="stylesheet" href="/res/tech/css/nivo-slider.css">
<link rel="stylesheet" href="/res/tech/css/style.css">
<link rel="stylesheet" href="/res/tech/css/style-rel.css">
<link rel="stylesheet" href="/res/tech/css/hd.css">
<link rel="shortcut icon" href="/res/tech/images/favicon.ico"
	type="image/x-icon">
<script type="text/javascript" src="/res/tech/js/jquery.js"></script>
<head>
<body>
	<!-- Start hd -->
<style>
.hdr ul li a{
/* color:rgb(64, 224, 208); 绿色 */
/* color:#9709F7;紫色 */
/*color:#EE11C2;/*粉红色*/
color:#FFFFFF;/**/
font-weight:bold;
}
</style>
<header id="hd">
	<div class="logo wow lightSpeedIn animated"
		style="visibility: visible; animation-name: lightSpeedIn;">
		<a href="#"><img src="/res/tech/images/logo.png" alt=""></a>
	</div>
	<div class="hdr wow fadeInDown animated"
		style="visibility: visible; animation-name: fadeInDown;">
		<ul class="nav">
			<li><a href="/index.shtml">网站首页<br> <em>HOME</em></a></li>
			<li>
				<a href="/news.shtml">新闻动态<br> <em>NEWS</em></a>
			</li>
			<li><a href="/members.shtml">研究团队<br> <em>MEMBERS</em></a></li>
			<li><a href="/publication.shtml">论文发表<br> <em>PUBLICATION</em></a></li>
			<li><a href="/projects.shtml">科研项目<br> <em>PROJECTS</em></a></li>
			<li>
				<a href="/about_us.shtml">关于我们<br> <em>ABOUT US</em></a>
			</li>
		</ul>
	</div>
</header>

<div id="cui-mobile-header" class="cui-mobile-header-fix"><span class="menu-btn" style="background: #000">展开</span> <a href="" class="logo"><img
		src="/res/tech/images/logo.png" alt=""></a>
</div>
<div id="cui-mobile-pop-menu" style="">
	<ul>
		<li><a href="/index.shtml">网站首页</a></li>
		<li><a href="/news.shtml">新闻动态</a></li>
		<li><a href="/members.shtml">研究团队</a></li>
		<li><a href="/publication.shtml">论文发表</a></li>
		<li><a href="/projects.shtml">科研项目</a></li>
		<!-- <li><a href="/collaboration.shtml">国际合作</a></li> -->
		<!-- <li><a href="/join_us.shtml">加入我们</a></li> -->
		<li><a href="/about_us.shtml">关于我们</a></li>
	</ul>
</div>
<!-- End hd -->
	
	
	<div class="c"></div>
	<section id="sban">
	<div
		style="background: url(/res/tech/images/sban2.jpg) no-repeat center top"></div>
	</section>
	<!-- End sban -->
	<div class="c"></div>

	<section id="bd">
	<div class="i-row2">
		<div class="wp" ng-app="myApp" ng-controller="myCtrl">
			<div class="col-l wow fadeInLeft" data-wow-offset="400">
				<div id="banner">
					<div id="wrapper">
						<div class="slider-wrapper theme-default">
							<div id="slider" class="nivoSlider">
							
							<img
								src="${webindexurl}2016/11/1.jpg"
								data-thumb="${webindexurl}2016/11/1.jpg"
							/>
							<img
								src="${webindexurl}2016/11/2.jpg"
								data-thumb="${webindexurl}2016/11/2.jpg"
							/>
							<img
								src="${webindexurl}2016/11/3.jpg"
								data-thumb="${webindexurl}2016/11/3.jpg"
							/>
							<img
								src="${webindexurl}2016/11/4.jpg"
								data-thumb="${webindexurl}2016/11/4.jpg"
							/>
							<%-- <c:forEach items="${news10 }" var="news">
								<c:if test="${!empty news.pic1}">
									<img
											src="${news.pic1 }"
											data-thumb="${news.pic1 }"
											alt="${news.title }" /> 
								</c:if>
								<img
											src="${news.pic1 }"
											data-thumb="${news.pic1 }"
											alt="${news.title }" /> 
							  
							</c:forEach> --%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-r wow fadeInRight" data-wow-offset="400">
				<div class="i-news">
					<h2>新闻资讯</h2>
					<ul class="ul-news2">
					<c:forEach items="${news10 }" var="news">
						<li><span class="r">${news.time }</span><a
							href="${news.reporterindex }" target="_blank"
							title="${news.title }">${news.title }</a>
							</li>
							
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="c"></div>
	<div class="i-row3 wow zoomIn">
		<div class="wp">
			<div class="slider link">
				<div>
					<ul>
						<li><a><i></i><img
								src="/res/tech/images/index/index00.jpg"
								alt=""></a>
							<p></p></li>
						<li><a href="http://www.nus.edu.sg"><i></i><img
								src="/res/tech/images/index/index01.png"
								alt=""></a>
							<p>新加坡国立大学NUS</p></li>
							
						<li><a href="http://www.ntu.edu.sg/Pages/home.aspx"><i></i><img
								src="/res/tech/images/index/index02.jpg"
								alt=""></a>
							<p>南洋理工大学</p></li>
						<li><a href="https://www.uq.edu.au/"><i></i><img
								src="/res/tech/images/index/index03.jpg"
								alt=""></a>
							<p>昆士兰大学</p></li>
						<li><a href="http://www.xidian.edu.cn/"><i></i><img
								src="/res/tech/images/index/index05.jpg"
								alt=""></a>
							<p>西安电子科技大学</p></li>
						<li><a href="http://www.uestc.edu.cn/"><i></i><img
								src="/res/tech/images/index/index06.jpg"
								alt=""></a>
							<p>电子科技大学</p></li>
						<li><a href="https://www.uts.edu.au/"><i></i><img
								src="/res/tech/images/index/index07.jpg"
								alt=""></a>
							<p>悉尼科技大学</p></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- End bd -->
	<div class="c"></div>
	
	<!-- start footer -->
	<footer id="fd">
	<div class="fd-row1">
		<div class="wp">
			<div class="menu">
				<a href="news.shtml">新闻中心</a> | <a href="about_us.shtml">关于我们</a> |
			</div>
			<div class="share">
				<ul>
					<li><a class="go-top" href="javascript:void(0);"></a></li>
				</ul>
			</div>
		</div>
	</div>
	
	
	<div class="c"></div>
	<div class="fd-row2">
		<div class="wp">
			<ul class="ul-info">
				<li class="s1">
					<h4>E-mail.</h4>
					<p>zxf@gxnu.edu.cn</p>
				</li>
				<li class="s2">
					<h4>Tel.</h4>
					<p>5833630</p>
					<p></p>
				</li>
				<li class="s3">
					<h4>Add.</h4>
					<p>广西桂林市七星区育才路15号.数学楼后楼207</p>
				</li>
			</ul>
			<div class="copyright">
				<span>网站建设：<a href="">207实验室</a></span>
				<p>©2016 PRML : ALL RIGHTS RESERVED</p>
			</div>
		</div>
	</div>
	</footer>
	<!-- End footer -->
	
	<script type="text/javascript" src="/res/tech/js/lib.js"></script>
	<link rel="stylesheet" href="/res/tech/css/animate.min.css">
	<script type="text/javascript" src="/res/tech/js/wow.min.js"></script>
	
	<script type="text/javascript"
		src="/res/tech/js/jquery.nivo.slider.pack.js"></script>
	<script type="text/javascript" src="/res/tech/js/slick.min.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider();
		});
		$('.link').slick({
			infinite : true,
			speed : 300,
			dots : true,
			slidesToShow : 1,
			slidesToScroll : 1
		});
		new WOW().init();
		//是导航条有选择的效果
		$(".nav li:eq(0)").attr("class", "on");
	</script>
</body>
</html>
