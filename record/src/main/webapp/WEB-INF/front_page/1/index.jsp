<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>演示：HTML5+CSS3实现的响应式垂直时间轴</title>
<!-- http://www.helloweba.com/demo/css/main.css -->
<link rel="stylesheet" href="/record/res/timeline/css/main.css" />
<link rel="stylesheet" href="/record/res/timeline/css/style.css" />
<style type="text/css">
h2.top_title{border-bottom:none;background:none;text-align:center;line-height:32px; font-size:20px}
h2.top_title span{font-size:12px; color:#666;font-weight:500}
</style>
<script type="text/javascript">
	function login() {
		window.location.href = "/record/user/tologin.do?returnUrl="
				+ window.location.href;
	}
	function regist() {
		window.location.href = "/record/user/regist.do";
	}
	function myInfo() {
		window.location.href = "/record/show/manage.do";
	}
	function logout() {
		window.location.href = "/record/user/logout.do?returnUrl="
				+ window.location.href;
	}
</script>
</head>

<body>
<div id="header">
   <div id="logo"><h1><a href="http://www.helloweba.com" title="返回helloweba首页">LAB207</a></h1></div>
   <div>
   	<c:if test="${!flag}">
		<a href="javascript:void(0)" onclick="login()" title="登陆">[登陆]</a>
		<a href="javascript:void(0)" onclick="regist()" title="注册">[注册]</a>
	</c:if>

	<c:if test="${flag}">
		<a href="javascript:void(0)" onclick="myInfo()" title="资料">[我的资料]</a>
		<a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a>
	</c:if>
   </div>
</div>

<h2 class="top_title"><a href="http://www.helloweba.com/view-blog-285.html">LAB207实验室</a><br/><span>各届师兄去向及论文发表情况记录</span></h2>

<section id="cd-timeline" class="cd-container">
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-picture">
			<img src="/record/res/timeline/img/cd-icon-picture.svg" alt="Picture">
		</div>

		<div class="cd-timeline-content">
			<h2>师兄一、师兄二、师兄三、师兄四、师兄五</h2>
			<p>①网页时间轴一般用于展示以时间为主线的事件，如企业网站常见的公司发展历程等。</p>
			<p>②网页时间轴一般用于展示以时间为主线的事件，如企业网站常见的公司发展历程等。</p>
			<p>③网页时间轴一般用于展示以时间为主线的事件，如企业网站常见的公司发展历程等。</p>
			<p>④网页时间轴一般用于展示以时间为主线的事件，如企业网站常见的公司发展历程等。</p>
			<p>⑤网页时间轴一般用于展示以时间为主线的事件，如企业网站常见的公司发展历程等。</p>
			<!--<div><img src="img/2016.jpg" width="50%" height="50%"></div>-->
			<a href="http://www.helloweba.com/view-blog-285.html" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date">2016届</span>
		</div>
	</div>
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-movie">
			<img src="/record/res/timeline/img/cd-icon-movie.svg" alt="Movie">
		</div>

		<div class="cd-timeline-content">
			<h2>jQuery+PHP动态数字展示效果</h2>
			<p>我们在一些应用中需要动态展示数据，比如当前在线人数，当前交易总额，当前汇率等等，前端页面需要实时刷新获取最新数据。本文将结合实例给大家介绍使用jQuery和PHP来实现动态数字展示效果。</p>
			<a href="http://www.helloweba.com/view-blog-284.html" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date">2014-12-25</span>
		</div>
	</div>
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-picture">
			<img src="/record/res/timeline/img/cd-icon-picture.svg" alt="Picture">
		</div>

		<div class="cd-timeline-content">
			<h2>PHP操作Session和Cookie</h2>
			<p>我们跟踪用户信息时需要用到Session和Cookie，比如用户登录验证、记录用户浏览历史，存储购物车数据，限制用户会话有效时间等。今天我们来了解下PHP是如何操作Session和Cookie的。</p>
			<a href="http://www.helloweba.com/view-blog-283.html" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date">2014-12-20</span>
		</div>
	</div>
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-movie">
			<img src="/record/res/timeline/img/cd-icon-movie.svg" alt="Movie">
		</div>

		<div class="cd-timeline-content">
			<h2>jQuery数字加减插件</h2>
			<p>我们在网上购物提交订单时，在网页上一般会有一个选择数量的控件，要求买家选择购买商品的件数，开发者会把该控件做成可以通过点击实现加减等微调操作，当然也可以直接输入数字件数。本文将介绍常见的几种使用spinner数字微调器来实现数字加减的功能的方法。</p>
			<a href="http://www.helloweba.com/view-blog-282.html" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date">2014-12-14</span>
		</div>
	</div>
	<div class="cd-timeline-block">
		<div class="cd-timeline-img cd-movie">
			<img src="/record/res/timeline/img/cd-icon-location.svg" alt="Location">
		</div>

		<div class="cd-timeline-content">
			<h2>收集整理的非常有用的PHP函数</h2>
			<p>项目中经常会需要一些让人头疼的函数，作为开发者应该整理一个自己的函数库，在需要之时复制过来即可。本文作者收集整理数十个PHP项目中常用的函数，保证能正常运行，你只要复制粘贴到你项目中即可。</p>
			<a href="http://www.helloweba.com/view-blog-281.html" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date">2014-12-05</span>
		</div>
	</div>
</section>

<div id="footer">
    <p>Powered by helloweba.com  允许转载、修改和使用本站的DEMO，但请注明出处：<a href="http://www.helloweba.com">www.helloweba.com</a></p>
</div>
</body>
</html>