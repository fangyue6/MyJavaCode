<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>成果新闻</title>

<script type="text/javascript">
	function sleep(numberMillis) {
		var now = new Date();
		var exitTime = now.getTime() + numberMillis;
		while (true) {
			now = new Date();
			if (now.getTime() > exitTime)
				return;
		}
	}

	//上传图片
	function uploadnews() {
		//定义参数
		var options = {
			url : "/upload/uploadNews1.do",///record
			dataType : "json",
			type : "post",
			success : function(data) {
				//回调两个路径
				//url
				//path
				//$("#showimage").append("<img src='" +data.url+"'/>");
				var url=data.result.url;
				var path=data.result.path;
				
				
				$("#newspath").val(path);
				$("#news_id").text("上传成功");
			},
			error : function() {
				$("#news_id").text("上传失败");
			}
		};
		//jquery.form使用
		$("#jvForm").ajaxSubmit(options);
	}
	function uploadnews1() {
		$('#example').modal({
			backdrop : 'static',
			keyboard : false
		});
		var addr = "";
		//获取上传地址
		$.ajax({
			type : "POST",
			async : false,
			url : "/upload/uploadNews.do",
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
			$('#example').modal('hide');
			return;
		}

		// 原生js跨域  上传文件
		var fd = new FormData(document.getElementById("jvForm"));
		var xhr = new XMLHttpRequest();
		xhr.open("POST", addr, "true");
		xhr.onreadystatechange = function() {
			if (this.readyState == 4) {
				var res = JSON.parse(this.responseText);
				if (res == null || res.result == null || res.result.length < 1) {
					alert("请重试！");
					return;
				}
				var url = res.result[0].url;
				var path = res.result[0].path;
				console.log(res.result[0]);

				$("#newspath").val(path);
				$("#news_id").text("上传成功");
				//sleep(30000);
				$('#example').modal('hide');
			}
		}
		xhr.send(fd);
	}
</script>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 新闻管理 - 添加/修改</div>
		<form class="ropt">
			<input type="submit" onclick="this.form.action='list.do';"
				value="返回列表" class="return-button" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box" style="float: right">
		<form id="jvForm" action="add.do" method="post">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 新闻标题:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							style="width: 600px" class="required" name="title"
							maxlength="100" required /></td>
					</tr>

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">新闻摘要:</td>
						<td width="80%" class="pn-fcontent"><textarea rows="4"
								cols="50" name="abstracts" maxlength="200"></textarea></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 报告人:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							style="width: 600px" class="required" name="reporter"
							maxlength="100" required /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 报告题目:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							style="width: 600px" class="required" name="reporttitle"
							maxlength="100" required /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 承办单位:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							style="width: 600px" class="required" name="organizer"
							maxlength="100" required /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">内容简介:</td>
						<td width="80%" class="pn-fcontent"><textarea rows="4"
								cols="50" name="contentintroduction"></textarea></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">报告人简介:</td>
						<td width="80%" class="pn-fcontent"><textarea rows="4"
								cols="50" name="reporterintroduction"></textarea></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 报告人主页:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							style="width: 600px" class="required" name="reporterindex"
							maxlength="200" required /></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 报告时间:</td>
						<td width="80%" class="pn-fcontent"><input type="date"
							class="required" name="time" required /></td>
					</tr>

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">上传图片:</td>
						<td width="80%" class="pn-fcontent">注:每张大小最好控制在5M以内。【 <label
							id="news_id" style="color: red;">上传状态</label>】
						</td>
					</tr>
					<tr>
						<input type="hidden" name="pic" id="newspath" />
						<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent"><input type="file"
							onchange="uploadnews()" name="upload_news" /></td>
					</tr>
					<!-- <div id="showimage"></div> -->
				</tbody>

				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2"><input type="submit"
							class="submit" value="提交" /> &nbsp; <input type="reset"
							class="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


<!-- 	<link href="/res/common/css/bootstrap.css" rel="stylesheet">
		<div id="example" class="modal hide fade" style="display: none;"
			aria-hidden="true" data-backdrop="static">

			<div class="modal-body">
				<h2>正在上传，请稍候......</h2>
			</div>
		</div>
		<script
			src="http://www.runoob.com/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
		<script src="/res/common/js/bootstrap-modal.js"></script> -->
</body>
</html>