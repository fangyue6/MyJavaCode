<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8" />

<title>登陆</title>
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
<h1>这是主页，可以不登陆的</h1>
	<c:if test="${!flag}">
		<a href="javascript:void(0)" onclick="login()" title="登陆">[登陆]</a>
		<a href="javascript:void(0)" onclick="regist()" title="注册">[注册]</a>
	</c:if>

	<c:if test="${flag}">
		<a href="javascript:void(0)" onclick="myInfo()" title="资料">[我的资料]</a>
		<a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a>
	</c:if>
<form action="/record/show/bbb.do">
<input  type="submit" value="提交"/>
</form>
</body>

</html>