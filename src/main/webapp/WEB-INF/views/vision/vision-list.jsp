<!--_meta 作为公共模版分离出去-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>管理员列表 - 管理员列表 - H-ui.admin v3.0</title>

</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		版本管理
		<span class="c-gray en">&gt;</span>
		版本列表
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="Hui-article">
		<article class="cl pd-20">
		    <form id="list_form" action="/sys/vision/tolist" method="post">
			<div class="text-c"> 日期范围：
				<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" name="startDate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" name="endDate" class="input-text Wdate" style="width:120px;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入版本号" id="visionCode" name="visionCode">
				<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
			</div>
			</form>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a href="javascript:;" onclick="admin_add('添加版本','toadd','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加版本</a>
				</span>
			</div>
			<div class="mt-10">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr>
						<th scope="col" colspan="9">版本列表</th>
					</tr>
					<tr class="text-c">
					    <th width="40"><input name="" type="checkbox" value=""></th>
						<th width="40">序号</th>
						<th width="150">版本号</th>
						<th width="90">版本链接</th>
						<th width="150">版本描述</th>
						<th width="130">创建时间</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="entity" items="${page.rows}" varStatus="vs">
							<tr class="tdChecked">
							    <td ><input id = "isselect"name="isselect" type="checkbox" value="${entity.id }"></td>
								<td >${page.startIndex + vs.index}</td>
								<td >${entity.visionCode }</td>
								<td >${entity.url }</td>
								<td >${entity.describtion }</td>
								<td ><fmt:formatDate value="${entity.visionTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="td-manage">
								<a title="编辑" href="javascript:;" onclick="admin_edit('版本编辑','toedit/+${entity.id}','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			</div>
		</article>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/css/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/css/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[0,6]}// 制定列不参与排序
	]
});
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*编辑*/
function admin_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>