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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加管理员 - 管理员管理 - H-ui.admin v2.4</title>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-role-edit">
	<input id="roleId" name="roleId" type="hidden" value='${role.id}'>
	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${role.name}"  id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  value="${role.description}" id="description" name="description">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">分配权限：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<dl class="permission-list">
				   <c:forEach var="entity" items="${resourcesList }">
				<fieldset>
				<legend>
					<input type="checkbox" class="firstLevel" name="resourcesIds" id="resourcesIds_${entity.id }"  value="${entity.id }-${entity.name }"/>${entity.name }(<b>菜单</b>)
				</legend>
				<c:forEach var="child" items="${entity.childList }">
					<input type="checkbox" class="secondLevel" name="resourcesIds" id="resourcesIds_${child.id }" value="${child.id }-${child.name }"/>${child.name }(<b>菜单</b>)
					<span>
					【
						<c:if test="${child.actionList.size() == 0 }">无动作</c:if>
						<c:forEach var="action" items="${child.actionList }">
							<input type="checkbox" class="thirdLevel" name="resourcesIds" id="resourcesIds_${action.id }"  value="${action.id }-${action.name }"/>${action.name }(<i>动作</i>)
						</c:forEach>
					 】
					</span>
		</c:forEach>
		</fieldset>
	</c:forEach>
				</dl>
			</div>
		</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/css/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/css/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$('.firstLevel').click(function(){
    	if($(this).is(':checked')){
    		$(this).parent().parent().find("input[type=checkbox]").prop("checked",true);
    	}else{
    		$(this).parent().parent().find(".secondLevel").removeAttr("checked");
    		$(this).parent().parent().find(".thirdLevel").removeAttr("checked");
    	}
    });
    $('.secondLevel').click(function(){
    	if($(this).is(':checked')){
    		$(this).parent().find(".firstLevel").prop('checked',true);
    		$(this).next().next().find("input[type=checkbox]").prop("checked",true);
    	}else{
    		$(this).next().next().find("input[type=checkbox]").removeAttr("checked");
    	}
    });
    $('.thirdLevel').click(function(){
    	if($(this).is(':checked')){
    		$(this).parent().parent().find(".firstLevel").eq(0).prop("checked",true);
    		$(this).parent().prev().prev().prop("checked",true);
    	}else{
    	}
    });
	
	$("#form-admin-role-edit").validate({
		rules:{
			name:{
				required:true,
			},
			description:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url ='/sys/role/update';
			$(form).ajaxSubmit({
						type: 'post',
						url: url ,
						success: function(data){
								layer.msg('添加成功!',{icon:1,time:10000});
								var index = parent.layer.getFrameIndex(window.name);
								window.parent.location.reload();
								parent.layer.close(index);
						},
		                error: function(XmlHttpRequest, textStatus, errorThrown){
							layer.msg('error!',{icon:1,time:1000});
						}
			});
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>