<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${student.name }</title>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="keywords" content="大数据,多源数据挖掘,大数据研究,算法研究">
				<meta name="description"
					content="广西计算机重点实验室">
					<meta name="format-detection" content="telephone=no">
						<link rel="stylesheet" href="/res/person/css/style.css"
							type="text/css" charset="utf-8">
<link rel="shortcut icon" href="/res/tech/images/favicon.ico"
	type="image/x-icon">
</head>
<body>
	<div id="wrapper">
		<div id="body">
			<div id="body-top">
				<div id="body-bot">
					<div id="header">
						<img src=" ${student.pic1 }" width="220" height="320" alt="Pic 1"
							id="person">
							<h1>${student.name }</h1>
							<div id="about">
								<p>去向：${student.place }</p>
								<p>描述：${student.describe }</p>

								<p class="email">邮箱： ${student.email }</p>
								<strong>其他联系方式</strong>
								<p>手机：${student.phone }</p>
								<p>qq：${student.qq }</p>
								<p>微信：${student.wechat }</p>
							</div>
							<div class="clear"></div>
					</div>
					<div class="category">
						<h2>论文节选</h2>
						<div class="clear"></div>
						<ul>
							<c:forEach items="${achievelist }" var="achieve">
								<li class="paper">
									<p class="p title">
										<strong>${achieve.title }</strong>
									</p>
									<p class="p author">${achieve.describe }</p>
									<p class="p time">
										<b>${achieve.time } <!-- <span class="mark">(CCF A类会议)</span> --></b>
										<span class="link">
										<c:if test="${not empty achieve.essay}">
										[<a href="${achieve.essay1 }" target="_blank">pdf</a>]
										</c:if>
										
										<c:if test="${not empty achieve.code}">
										[<a href="${achieve.code1 }" target="_blank">code</a>]
										</c:if>
										
										
										</span>
									</p>
								</li>
							</c:forEach>
						</ul>
					</div>

					<div id="footer">
						<div id="footer-right">
							<p>
								It doesn't matter whether you are the lion or a gazelle.<br>
									When the sun comes up, you'd better start running.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="cntvlive2-is-installed"></div>
</body>
</html>