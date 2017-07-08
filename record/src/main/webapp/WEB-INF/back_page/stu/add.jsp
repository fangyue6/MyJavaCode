<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>注册</title>
<!-- /record -->
<link rel="shortcut icon" href="/res/tech/images/favicon.ico"
	type="image/x-icon">
<script src="/res/common/js/jquery.js" type="text/javascript"></script>
<style type="text/css">
div {
	width: 35%;
	margin-left: 32%;
}
</style>
<script type="text/javascript">
	function check() {
		//这里还要验证
		var p1=$("#password1").val();
		var p2=$("#password2").val();
		
		if(p1!=p2){
			//$("#error").attr("visible", true);
			alert("密码不一致");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div>

		<form class="f1" action="add.do" method="post">
<!-- 		<fieldset>
			<a href="/user/tologin.do">已有账号请点这登陆</a>
		</fieldset> -->
		<hr />
			<fieldset>
				<legend>快速注册</legend>
				
				<table width=100%>
					<tbody>
						<tr id="error" <c:if test="${empty error }"> style="display: none;"</c:if>>
							<td class="left" width=40% align="right">
							<em  style="color: red">${error }</em>
							</td>
						</tr>
						<tr>

							<td class="left" width=40% align="right">学 校：</td>
							<td><select id="selc" name="schoolID">
									<option value="0001">广西师范大学</option>
							</select></td>
						</tr>

						<tr>
							<td class="left" width=40% align="right"><label for="t1">学
									号：</label></td>
							<td class="right"><input type="text" id="t1"
								name="studentNumber" required value="${student.studentNumber }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label for="t1">入学年份：</label></td>
							<td class="right"><input type="number" id="t1" name="time" required value="${student.time }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label for="t1">姓
									名：</label></td>
							<td class="right"><input type="text" id="t1" name="name" required value="${student.name }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label for="t1">电
									话：</label></td>
							<td class="right"><input type="text" id="t1" name="phone" required value="${student.phone }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label for="t1">Q
									Q：</label></td>
							<td class="right"><input type="text" id="t1" name="qq" required value="${student.qq }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label for="t1">email：</label></td>
							<td class="right"><input type="email" id="t1" name="email" required value="${student.email }"></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label
								for="Password1">密 码：</label></td>
							<td class="right"><input id="password1" type="password"
								name="passwd" required value="${student.passwd }"/></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right"><label
								for="Password1">重复密码：</label></td>
							<td class="right"><input id="password2" type="password" required value="${student.passwd }"/></td>
						</tr>
						<tr>
							<td class="left" width=40% align="right" rowspan=2><input
								id="Submit1" type="submit" value="提 交" onclick="return check()" /></td>
							<td><input type="reset" value="重 置" /></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>

