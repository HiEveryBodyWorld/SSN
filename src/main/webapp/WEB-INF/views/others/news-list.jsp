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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/js/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>资讯列表</title>
</head>
<style>
*{margin:0;padding:0;list-style:none;}
body{font-size:14px;}


.nav{width:200px;height:30px;margin:20px auto;}
.nav p{display:block;padding-left:10px;line-height:30px;border:1px solid #CCC;}
.set{background:url(images/btn_2.png) 165px 10px no-repeat;}
.select{background:url(images/btn_1.png) 165px 10px no-repeat;}
.new{width:198px;position:absolute;border:1px solid #CCC;display:none;}
.nav ul li{line-height:30px;padding-left:10px;}
.nav ul li:hover{background:#CCC;color:#FFF;}
</style>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资讯管理 <span class="c-gray en">&gt;</span> 资讯列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<form id="list_form" action="/sys/news/tolist" method="post">
	<div class="text-c">
			新闻类型：
				 <select  class="nav" name="status" id="newType">
				    <option value="" selected>状态</option>
				    <option value="1">上架</option>
				    <option value="0">下架</option>
				  </select>
	 	日期范围：
		<input name="startDate" type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input name="endDate" type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">
		<input type="text" name="title" id="" placeholder=" 新闻名称" style="width:250px" class="input-text">
		
		
		<button name="search_news" id="search_news" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜新闻</button>
	</div>
</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" data-title="添加新闻" data-href="/sys/news/toadd" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加新闻</a></span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="80">ID</th>
					<th>标题</th>
					<th width="80">副标题</th>
					<th width="120">更新时间</th>
					<th width="60">发布状态</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="newa" items="${news.rows}" varStatus="vs">
					<tr class="text-c">
					<td>${vs.index+1}</td>
					<td class="text-l"><u style="cursor:pointer" class="text-primary" data-href="/sys/others/toshow/+${newa.manageId}" onclick="Hui_admin_tab(this)" href="javascript:;" data-title="查看">${newa.title}</u></td>
					<td>${newa.subtitle}</td>
					<td><fmt:formatDate value="${newa.updateTime}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
					
					<td class="td-status">
					<c:if test="${newa.status==0}">
					<span class="label label-success radius">未发布</span>
					</c:if>
					<c:if test="${newa.status==1}">
					<span class="label label-success radius">已经发布</span>
					</c:if>
					</td>
					
					
					
					<td class="f-14 td-manage">
					<c:if test="${newa.status==0}">
					<a style="text-decoration:none" onClick="article_start(this,${newa.manageId})" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe6de;</i></a> 
					</c:if>
					<c:if test="${newa.status==1}">
					<a style="text-decoration:none" onClick="article_stop(this,${newa.manageId})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> 
					</c:if>
					<a style="text-decoration:none" class="ml-5" data-href="/sys/others/toedit/+${newa.manageId}" onclick="Hui_admin_tab(this)" href="javascript:;" data-title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
					</td>
					</tr>


				</c:forEach>
			
			</tbody>
		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/css/h-ui/js/H-ui.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/css/h-ui.admin/js/H-ui.admin.page.js"></script>
		<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/css/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validation/1.14.0/validate-methods.js"></script> 

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ueditor/1.4.3/ueditor.all.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ueditor/1.4.3/ueditor.parse.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ueditor/1.4.3/ueditor.parse.min.js"> </script>   
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[1,5]}// 不参与排序的列
	]
});

/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: '<%=request.getContextPath()%>'+url
	});
	layer.full(index);
}
/*资讯-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*资讯-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*资讯-下架*/
function article_stop(obj,id){
	var user = {
			manageId:id,
			status:0
	}
	layer.confirm('确认要下架吗？',
			function(index) {
			$.ajax({
			type : 'POST',
			url : '/sys/others/update',
			contentType : 'application/json',
			dataType : 'json',
			data:JSON.stringify(user),
			success : function(data) {
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,'+id+')" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
				$(obj).remove();
				layer.msg('已下架!',{icon: 5,time:1000});
			},
			error : function(data) {
				console.log(data.msg);
			},
		})
	});
}

/*资讯-发布*/
function article_start(obj,id){
	var user = {
			manageId:id,
			status:1
	}
	layer.confirm('确认要发布吗？',function(index) {
		$.ajax({
			type : 'POST',
			url : '/sys/others/update',
			contentType : 'application/json',
			dataType : 'json',
			data:JSON.stringify(user),
			success : function(data) {
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,'+id+')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
				$(obj).remove();
				layer.msg('已发布!',{icon: 6,time:1000});
			},
			error : function(data) {
				console.log(data.msg);
			},
		})
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>
</html>