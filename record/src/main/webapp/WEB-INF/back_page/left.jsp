<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>babasport-left</title>
</head>
<body class="lbody">
	<div class="left">
		<%@ include file="/WEB-INF/back_page/date.jsp"%>

		<ul class="w-lful">
			<c:if test="${empty superadmin }">
				<li><a href="stu/right_myinfo.do" target="rightFrame">个人资料</a></li>
				<li><a href="ach/list.do" target="rightFrame">个人成果</a></li>
			</c:if>

			<li><a href="news/list.do" target="rightFrame">新闻管理</a></li>
			<c:if test="${!empty superadmin }">
				<li><a href="stu/list.do" target="rightFrame">人员管理</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>