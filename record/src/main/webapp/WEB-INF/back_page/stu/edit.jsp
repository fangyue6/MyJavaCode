<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>个人资料</title>
<script type="text/javascript">
	//上传图片
	function uploadPic() {

		//定义参数
		var options = {
			url : "/upload/uploadPic1.do",///record
			dataType : "json",
			type : "post",
			success : function(data) {
				//回调两个路径
				//url
				//path
				concole.log(data);
				$("#allImgUrl").attr("src", data.result.url);
				$("#path").val(data.result.path);
			}
		};
		//jquery.form使用
		$("#jvForm").ajaxSubmit(options);
	}
	//上传图片
	/* function uploadPic1() {
	 var addr = "";
	 //获取上传地址
	 $.ajax({
	 type : "POST",
	 async : false,
	 url : "/upload/uploadPic.do",
	 dataType : "json",//数据类型为json  
	 success : function(data) {
	 console.log(data.url);
	 addr = data.url;
	 },
	 error : function() {
	 addr = "";
	 }
	 });

	 if (addr == "") {
	 alert("请重试！");
	 return;
	 }
	 // 原生js跨域  上传文件
	 var fd = new FormData(document.getElementById("jvForm"));
	 var xhr = new XMLHttpRequest();
	 xhr.open("POST", addr, "true");
	 xhr.onreadystatechange = function() {
	 if (this.readyState == 4) {
	 var res = JSON.parse(this.responseText);
	 if(res==null || res.result==null || res.result.length<1){
	 alert("请重试！");
	 return ;
	 }
	 var url=res.result[0].url;
	 var path=res.result[0].path;
	 console.log(res.result[0]);
	 //回调两个路径 url path
	 $("#allImgUrl").attr("src", url);
	 $("#path").val(path);
	 }
	 }
	 xhr.send(fd);
	 } */

	function check() {
		var p1 = $("#password1").val();
		var p2 = $("#password2").val();
		if (p1 != p2) {
			alert("两次密码不一致");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 人员管理- 编辑</div>
		<!-- 	<form class="ropt">
		<input type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form> -->
		<div class="clear"></div>
	</div>
	<div class="body-box" style="float: right">
		<form id="jvForm" method="post" enctype="multipart/form-data">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 上传图片(220x230尺寸):</td>
						<td width="80%" class="pn-fcontent">注:该尺寸图片必须为220x230。</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent"><img width="100"
							height="100" id="allImgUrl" src="${student.pic1 }" /> <input
							type="file" onchange="uploadPic()" name="up_pic" /> <input
							type="hidden" name="time" value="${student.time} "></input> <input
							type="hidden" name="studentNumber"
							value="${student.studentNumber} "></input></td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="modify_myinfo.do" method="post">
			<!-- enctype="multipart/form-data" -->
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							学校:${student.schoolID }</td>
						<td width="80%" class="pn-fcontent"><input type="hidden"
							class="required" name="schoolID" maxlength="100"
							value="${student.schoolID } " /></td>
					</tr>
					<input type="hidden" name="pic" id="path" value="${student.pic }" />
					<input type="hidden" name="id" value="${student.id }" />
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">学 号:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" readOnly="true" name="studentNumber"
							maxlength="80" size="60" value="${student.studentNumber }" /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">入学年份:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="time" maxlength="80" size="60"
							value="${student.time} " /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">姓 名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="name" maxlength="80" size="60"
							value="${student.name }" /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">年 龄:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="year" maxlength="80" size="60" value="${student.year }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">性 别:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="sex" maxlength="80" size="60" value="${student.sex }" /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">手 机:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="phone" maxlength="80" size="60" value="${student.phone }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">Q Q:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="qq" maxlength="80" size="60" value="${student.qq }" /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">微 信:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="wechat" maxlength="80" size="60" value="${student.wechat }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">邮 箱:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="email" maxlength="80" size="60" value="${student.email }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">主 页:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="homepage" maxlength="200" size="60" value="${student.homepage }" />
						</td>
					</tr>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">是否毕业:</td>
						<td width="80%" class="pn-fcontent">
							<c:if test="${student.graduated==1 }">
							<label>
								<input type="radio" name="graduated" value="1" checked="checked"/>
								是
							</label>|
							<label>
								<input type="radio" name="graduated" value="0" >
								否
							</label>
						    </c:if>
						    
						    <c:if test="${student.graduated==0 }">
							<label>
								<input type="radio" name="graduated" value="1" />
								是
							</label>|
							<label>
								<input type="radio" name="graduated" value="0" checked="checked"/>
								否
							</label>
						    </c:if>
						
						</td>
					</tr>
					
					<c:if test="${!empty sessionScope.superadmin}">
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">是否在网站显示:</td>
						<td width="80%" class="pn-fcontent">
							<c:if test="${student.isshow==1 }">
							<label>
								<input type="radio" name="isshow" value="1" checked="checked"/>
								是
							</label>|
							<label>
								<input type="radio" name="isshow" value="0"/>
								否
							</label>
						    </c:if>
						    
						    <c:if test="${student.isshow==0 }">
							<label>
								<input type="radio" name="isshow" value="1" />
								是
							</label>|
							<label>
								<input type="radio" name="isshow" value="0" checked="checked"/>
								否
							</label>
						    </c:if>
						
						</td>
					</tr>
					</c:if>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">去 向:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							name="place" maxlength="80" size="60" value="${student.place }" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">描 述:</td>
						<td width="80%" class="pn-fcontent"><textarea rows="3"
								cols="80" name="describe">${student.describe }</textarea></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">密 码:</td>
						<td width="80%" class="pn-fcontent"><input type="password"
							id="password1" class="required" name="passwd" maxlength="80"
							value="${student.passwd }" /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">重复密码:</td>
						<td width="80%" class="pn-fcontent"><input type="password"
							id="password2" class="required" maxlength="80"
							value="${student.passwd }" /></td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2"><input type="submit"
							class="submit" value="提交" onclick="return check()" /> &nbsp; <input
							type="reset" class="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>