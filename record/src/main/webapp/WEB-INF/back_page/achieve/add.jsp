<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>成果添加</title>
<script type="text/javascript">
//上传文章
function uploadessay(){
	 //定义参数
	var options={
		url:"/upload/uploadEssay1.do",///record
		dataType:"json",
		type:"post",
		success:function(data){
			//回调两个路径
			//url
			//path
			$("#downloadessay").attr("href",data.result.url);
			$("#essaypath").val(data.result.path);
			$("#essay_id").text("上传成功");
		},
		error:function(){
			$("#essay_id").text("上传失败");
		}
	};
	//jquery.form使用
	$("#jvForm").ajaxSubmit(options);
}
function uploadessay1(){
	
	var addr = "";
	//获取上传地址
	$.ajax({
		type : "POST",
		async : false,
		url : "/upload/uploadEssay.do",
		dataType : "json",//数据类型为jsons  
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
			
			$("#downloadessay").attr("href",url);
			$("#essaypath").val(path);
			$("#essay_id").text("上传成功");
		}
	}
	xhr.send(fd); 
}
//上传代码
function uploadcode(){
	//定义参数
	var options={
		url:"/upload/uploadCode.do",///record
		dataType:"json",
		type:"post",
		success:function(data){
			//回调两个路径
			//url
			//path
			$("#downloadcode").attr("href",data.url);
			$("#codepath").val(data.path);

			$("#code_id").text("上传成功");
		},
		error:function(){
			$("#code_id").text("上传失败");
		}
	};
	//jquery.form使用
	$("#jvForm").ajaxSubmit(options);
}
function uploadcode1(){
	
	var addr = "";
	//获取上传地址
	$.ajax({
		type : "POST",
		async : false,
		url : "/upload/uploadCode.do",
		dataType : "json",//数据类型为jsons  
		success : function(data) {
			console.log(data.url);
			addr = data.url;
		},
		error : function() {
			addr = "";
		}
	});

	if (addr == "") {
		$("#code_id").text("上传失败");
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
				$("#code_id").text("上传失败");
				return ;
			}
			var url=res.result[0].url;
			var path=res.result[0].path;
			console.log(res.result[0]);
			
			$("#downloadcode").attr("href",url);
			$("#codepath").val(path);

			$("#code_id").text("上传成功");
		}
	}
	xhr.send(fd);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 成果管理 - 添加/修改</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="add.do" method="post">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
			<input type="hidden" name="uploadtime" value="${student.time }"></input>
			<input type="hidden" name="studentNumber" value="${student.studentNumber }"></input>
			<input type="hidden" name="schoolID" value="${student.schoolID }"></input>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						成果名称:</td><td width="80%"  class="pn-fcontent">
						<input type="text" style="width: 600px" class="required" name="title" maxlength="200" required />
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						上传文章:</td>
						<td width="80%" class="pn-fcontent">
						注:该大小最好控制在5M以内。【
						<label id="essay_id" style="color: red;">上传状态</label>】
						<a target="view_window" id="downloadessay">查看</a>
					</td>
				</tr>
 				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<input type="hidden" name="essay" id="essaypath"/>
						<input type="file" onchange="uploadessay()" name="upload_essay"/>
					</td>
				</tr> 
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						上传代码:</td>
						<td width="80%" class="pn-fcontent">
						注:该大小最好控制在5M以内。【
						<label id="code_id" style="color: red;">上传状态</label>】
						<a target="view_window" id="downloadcode">查看</a>
					</td>
				</tr>
 				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<input type="hidden" name="code" id="codepath" />
						<input type="file" onchange="uploadcode()" name="upload_code" />
					</td>
				</tr> 
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						成果时间:</td><td width="80%" class="pn-fcontent">
						<input type="date" class="required" name="time" maxlength="80" />
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						成果描述:</td><td width="80%" class="pn-fcontent">
						<textarea rows="4" cols="50" name="describe" ></textarea>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>