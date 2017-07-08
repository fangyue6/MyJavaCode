<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta charset="UTF-8" />

<title>登陆</title>
<!-- /record -->
<link rel="stylesheet" href="/res/css/login/style.css" media="screen"
	type="text/css" />
<script>
	function check() {
		//alert("我出来了");
		//return false;

		//定义参数
		var options = {
			url : "/user/login.do",///record
			dataType : "json",
			type : "post",
			success : function(data) {
				console.log(data);
				//回调两个路径
				//url
				//path
				//$("#allImgUrl").attr("src", data.url);
				//$("#path").val(data.path);
			}
		};
		//jquery.form使用
		$("#contact").ajaxSubmit(options);

	}
</script>
</head>

<body>
	<div class="container">
	<!-- /record -->
		<form id="contact" action="/user/login.do" method="post">
			<h3>快速登录</h3>
			<h4>使用你的学号和密码登陆</h4>
			<input type="hidden" value="${param.returnUrl }" name="returnUrl" />
			<label <c:if test="${empty error }">style="display: none;"</c:if> >${error }</label> 
<%-- 			<select name="schoolID">
				<c:forEach items="${allSchool}" var="school">
					<option value="${school.schoolID }">${school.schoolName }</option>
				</c:forEach>
			</select> --%>
			<fieldset>
				<input placeholder="学号" type="text" tabindex="1"
					name="studentNumber" required autofocus/>
			</fieldset>
			<fieldset>
				<input placeholder="密码" type="password" tabindex="2" name="passwd"
					required/>
			</fieldset>

			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">登陆</button>
			</fieldset>
					<hr />
			<fieldset>
					<a href="/user/regist.do">去注册</a><!-- /record -->
			</fieldset>
		

		</form>
	</div>

	<div style="text-align: center; clear: both"></div>
</body>

</html>