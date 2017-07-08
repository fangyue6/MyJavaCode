<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>babasport-list</title>
<script type="text/javascript">
function checkBox(name,checked){
	//全选
	$("input[name='"+name+"']").attr("checked",checked);
}
//批量删除
function optDelete(name,isDisplay){
	//请选择一个
	var s=$("input[name='ids']:checked").size();
	if(s<=0){
		alert("请至少选择一个");
		return ;
	}
	if(!confirm("你确定删除吗？")){
		return ;
	}
	//删除
	$("#jvForm").attr("action","deletes.do");
	$("#jvForm").attr("method","post").submit();
}
</script>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 成果管理 - 列表</div>
		<form class="ropt">
			<input class="add" type="button" value="添加"
				onclick="javascript:window.location.href='toAdd.do'" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box">
<%-- 		<form action="/brand/list.do" method="post" style="padding-top: 5px;">
			品牌名称: <input type="text" name="name" value="${name}" /> <select
				name="isDisplay">
				<option value="1"
					<c:if test="${isDisplay==1 }">selected="selected"</c:if>>是</option>
				<option value="0"
					<c:if test="${isDisplay==0 }">selected="selected"</c:if>>不是</option>
			</select> <input type="submit" class="query" value="查询" />
		</form> --%>
		<form id="jvForm">
		<table cellspacing="1" cellpadding="0" border="0" width="100%"
			class="pn-ltable">
			<thead class="pn-lthead">
				<tr>
					<th width="20"><input type="checkbox"
						onclick="checkBox('ids',this.checked)" /></th>
					<th>成果序号</th>
					<th>成果标题</th>
					<th>成果时间</th>
					<th>成果描述</th>
					<th>成果文章</th>
					<th>成果代码</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<tbody class="pn-ltbody">

				<c:forEach items="${pagination.list }" var="entry">

					<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'"
						onmouseover="this.bgColor='#eeeeee'">
						<td><input type="checkbox" value="${entry.id }" name="ids" /></td>
						<td align="center" width="5%">${entry.id }</td>
						<td align="center" width="20%">${entry.title }</td>
						<td align="center">${entry.time }</td>
						<td align="center" width="30%">${entry.describe }</td>
						<td align="center"><a href="${entry.essay1 }"  target="view_window">查看</a></td>
						<td align="center"><a href="${entry.code1 }"  target="view_window">查看</a></td>
						
						<td align="center"><a class="pn-opt"
							href="javascript:void(0)"
							onclick="window.location.href='toEdit.do?id=${entry.id}'">修改</a>
							| <a class="pn-opt"
							onclick="if(!confirm('您确定删除吗？')) {return false;} window.location.href='delete.do?id=${entry.id }'"
							href="javascript:void(0)">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
		<!-- 分页  start -->
		<div class="page pb15">
			<span class="r inb_a page_b"> <c:forEach
					items="${pagination.pageView }" var="page">
				${page }
			</c:forEach>
			</span>

		</div>
		<!-- 分页  end -->

		<div style="margin-top: 15px;">
			<input class="del-button" type="button" value="删除"
				onclick="optDelete('xxx','yyy');" />
		</div>
	</div>
</body>
</html>