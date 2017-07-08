<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/front_page/tech/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style>
.team-list1 ul li{
height: 235px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/front_page/tech/common-hd.jsp"%>
	<div class="c"></div>
	<section id="sban">
	<!-- /record -->
	<div style="background: url(/res/tech/images/sban2.jpg) no-repeat center top"></div>
	</section>
	<!-- End sban -->
	<div class="c"></div>
	<section id="bd"> 
	<div class="c"></div>
	<div class="mainBox">
		<div class="team-row1">
			
		</div>
		<div class="team-row2">
			<div class="wp wow zoomIn animated"
				style="visibility: visible; animation-name: zoomIn;">
				<div class="team-list1">
					<h2>客座教授</h2>
					<ul>
						<li><a href="http://nlpr-web.ia.ac.cn/mmc/homepage/csxu.html">
								<div class="img">
									<img
										src="./collaboration_files/thumb_147_186_20150418121841228.jpg"
										alt="">
								</div>
								<div class="txt">
									<div class="t1">
										<h4>姓名：徐常胜</h4>
										<p>
											<span>职 称：Professor</span><span><span>个人网页：http://nlpr-web.ia.ac.cn/mmc/homepage/csxu.html</span></span>
										</p>
										<p>
											<span>Email：csxu@csidm.sg</span><span>就职于：Institute of
												Automation, Chinese Academy of Sciences</span>
										</p>
									</div>
									<div class="t2">
										<h4>个人简介：</h4>
										<p></p>
										<div>Dr. Xu is a Professor in National Lab of Pattern
											Recognition, Institute of Automation, Chinese Academy of
											Sciences and Executive Director of China-Singapore Institute
											of Digital Media. His research interests include multimedia
											content analysis/indexing/retrieval, pattern recognition and
											computer vision. He has hold 30 granted/pending patents and
											published over 200 refereed research papers in these areas.</div>
										<p></p>
									</div>
								</div>
						</a></li>
						<li><a href="http://cs.adelaide.edu.au/~chhshen/">
								<div class="img">
									<img
										src="./collaboration_files/thumb_147_186_20150417033259519.png"
										alt="">
								</div>
								<div class="txt">
									<div class="t1">
										<h4>姓名：沈春华</h4>
										<p>
											<span>职 称：Professor</span><span><span>个人网页：http://cs.adelaide.edu.au/~chhshen/</span></span>
										</p>
										<p>
											<span>Email：chunhua.shen@adelaide.edu.au</span><span>就职于：University
												of Adelaide</span>
										</p>
									</div>
									<div class="t2">
										<h4>个人简介：</h4>
										<p>Chunhua Shen is an ARC Future Fellow (awarded in 2012)
											and Professor of Computer Science at University of Adelaide.
											He is part of the Au-stralian Centre for Visual Technologies
											(ACVT). His research and teaching focus on Statistical
											Machine Learning and Computer Vision.</p>
									</div>
								</div>
						</a></li>
						<li><a href="http://staff.itee.uq.edu.au/huang/">
								<div class="img">
									<img src="/res/tech/images/collaboration/20150417033335441.png" alt="">
								</div>
								<div class="txt">
									<div class="t1">
										<h4>姓名：黄兹</h4>
										<p>
											<span>职 称：Senior Lecturer &amp; ARC Future Fellow</span><span><span>个人网页：http://staff.itee.uq.edu.au/huang/</span></span>
										</p>
										<p>
											<span>Email：huang@itee.uq.edu.au</span><span>就职于：The
												University of Queensland</span>
										</p>
									</div>
									<div class="t2">
										<h4>个人简介：</h4>
										<p>Dr. Huang is an ARC Future Fellow in School of ITEE,
											The University of Queensland. She received her BSc degree
											from Department of Comp-uter Science, Tsinghua University,
											China, and her PhD in Computer Science from School of ITEE,
											The University of Queensland. Dr. Huang's research interests
											mainly include multimedia indexing and search, social data
											analysis and knowledge discovery.</p>
									</div>
								</div>
						</a></li>
						<li><a href="https://www.cse.ust.hk/~leichen/">
								<div class="img">
									<img src="/res/tech/images/collaboration/20150417033349252.png" alt="">
								</div>
								<div class="txt">
									<div class="t1">
										<h4>姓名：陈雷</h4>
										<p>
											<span>职 称：Associate Professor</span><span><span>个人网页：https://www.cse.ust.hk/~leichen/</span></span>
										</p>
										<p>
											<span>Email：leichen@cse.ust.hk</span><span>就职于：Hong
												Kong University of Science and Technology</span>
										</p>
									</div>
									<div class="t2">
										<h4>个人简介：</h4>
										<p>Lei Chen received his BS degree in Computer Science at
											Tian Jin University, P.R.China(BS 94), and an MA degree in
											computer science at Asian Institute of Technology (AIT) Asian
											Institute of Technology (MS 97). He received a Ph.D. degree
											in Computer Science at University of Waterl-oo. His research
											interests include crowdsourcing-based data processing,
											uncertain and probabilistic databases, Web data management,
											mult-imedia and time series database, and privacy.&nbsp;</p>
									</div>
								</div>
						</a></li>
					</ul>
				</div>
				<div class="down-more">
					<span>&nbsp;</span>
				</div>
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
		$(document)
				.ready(
						function() {
							var page = 1;
							var catid = "5";
							$(window)
									.scroll(
											function() {
												if ($(document).scrollTop() >= $(
														document).height()
														- $(window).height()) {
													$
															.ajax({
																url : "http://bmc.uestc.edu.cn/index.php?m=content&c=index&a=more_content",
																data : {
																	page : page,
																	num : 4,
																	catid : catid,
																	modelid : 27
																},
																success : function(
																		data) {
																	if (data != 'FULL') {
																		$(
																				".team-list1 ul")
																				.append(
																						data);
																	} else {
																		$(
																				".down-more")
																				.hide();
																	}
																}
															})
													page++;
												}
											});
						});
		
		
		//是导航条有选择的效果
		$(".nav li:eq(5)").attr("class","on");
	</script>

	<div id="cntvlive2-is-installed"></div>
</body>
</html>