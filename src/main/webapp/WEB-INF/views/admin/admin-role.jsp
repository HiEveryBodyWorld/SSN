<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--_meta 作为公共模版分离出去-->
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

<title>角色管理 - 管理员管理 - H-ui.admin v3.0</title>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="Hui-article">
		<article class="cl pd-20">
			<div class="cl pd-5 bg-1 bk-gray"> <span class="l"><span class="l">
				<a href="javascript:;" onclick="admin_role_add('添加管理员','toadd','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a>
				</span>
			</span> </div>
			<div class="mt-10">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr>
						<th scope="col" colspan="6">角色列表</th>
					</tr>
					<tr class="text-c">
						<th width="40">ID</th>
						<th width="200">角色名</th>
						<th>用户列表</th>
						<th width="300">描述</th>
						<th width="70">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entity" items="${page.rows}" varStatus="vs">
							<tr class="text-c">
								<td >${page.startIndex + vs.index}</td>
								<td >${entity.name }</td>
								<td >${entity.name }</td>
								<td >${entity.description }</td>
								<td class="td-manage">
								<a title="编辑" href="javascript:;" onclick="admin_role_edit('管理员编辑','toedit/+${entity.id}','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a title="删除" href="javascript:;" onclick="admin_role_del(this,'${entity.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
	  {"orderable":false,"aTargets":[0,4]}// 制定列不参与排序
	]
});
/*管理员-角色-添加*/
function admin_role_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function admin_role_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-删除*/
function admin_role_del(obj,id){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		var url ='/sys/role/delete/'+id
		jQuery.ajax({
	        type : 'POST',
	        contentType : 'application/json',
	        url : url,
	        dataType : 'json',
	        async:false,
	        success : function(data) {
	        	layer.msg('已删除!',{icon:1,time:1000});
	        	location.reload();
	        }
	    });
	});
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>