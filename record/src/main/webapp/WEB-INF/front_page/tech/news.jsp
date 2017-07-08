<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/front_page/tech/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

</head>
<body>
	<%@ include file="/WEB-INF/front_page/tech/common-hd.jsp"%>
	<div class="c"></div>
	<section id="sban">
	<div style="background: url(/res/tech/images/sban2.jpg) no-repeat center top"></div>
	</section>
	<!-- End sban -->
	<div class="c"></div>
	<section id="bd"> 
	<div class="c"></div>
	<div class="mainBox wow zoomIn animated"
		style="visibility: visible; animation-name: zoomIn;">
		<div class="wp" style="width: 1120px">
			<div class="news-left">
				<h2>
					<strong>新闻动态</strong>
				</h2>
				<ul class="ul-news1">
				
				<c:forEach items="${pagination.list }" var="entry">
					<li>
						<div class="txt">
							<h4>
								<a href="${entry.reporterindex }" target="_blank">${entry.title }</a>
							</h4>
							<p>
								<em class="time">${entry.time }</em>
							</p>
							<p class="t2">
							${entry.contentintroduction }
							</p>
						</div>
						<div class="pic">
							<a href="${entry.reporterindex }" target="_blank"><img
								src="${entry.pic1 }" alt=""></a>
						</div>
					</li>
					<br>
				</c:forEach>
				</ul>
				
				
				<!-- <div class="page">
					<a href="news.html" class="a1 prev">&lt;</a> <span>1</span> <a
						href="http://bmc.uestc.edu.cn//news2/">2</a> <a
						href="http://bmc.uestc.edu.cn//news3/">3</a> <a
						href="http://bmc.uestc.edu.cn//news2/" class="a1 next">&gt;</a>
				</div> -->
				
			<!-- 分页  start -->
<div class="c"></div>
			<div>
				<span> 
				<c:forEach
						items="${pagination.pageView }" var="page">
					${page }
				</c:forEach>
				</span>
			</div>

		   <!-- 分页  end -->
		   
			</div>
			
			
			<div class="news-right">
				<h3>
					<strong>热门资讯</strong>
				</h3>
				<ul class="ul-news2">
				<c:forEach items="${news10 }" var="news" varStatus="status">
				
				
					<li 
					<c:if test="${status.count<4 }">class="hot"</c:if>
					>
					<span class="r">2016-05-25</span><b>${status.count }</b><a
						href="${news.reporterindex }"
						title="${news.title }" target="_blank">${news.title}</a></li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<!-- End bd -->
	<div class="c"></div>
	<%@ include file="/WEB-INF/front_page/tech/common-footer.jsp"%>


<!-- 	<script type="text/javascript" src="js/lib.js"></script>
	<div class="body-loading" style="display: none;"></div>
	<link rel="stylesheet" href="css/animate.min.css">
	<script type="text/javascript" src="js/wow.min.js"></script> -->
	<script>
		new WOW().init();
		//是导航条有选择的效果
		$(".nav li:eq(1)").attr("class","on");
	</script>


	<div id="cntvlive2-is-installed"></div>
</body>
</html>