<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="sysMenuItems" class="easyui-accordion" data-options="fit:true">
<c:forEach items="${userMenus}" var="um">
    <div title="${um.text}">
      	<c:forEach items="${um.children}" var="menu">
           <a href="javascript:addTab('${menu.attributes.code}','${menu.text}','${menu.attributes.url}')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-blank'" style="width:90%;text-align:left;">${menu.text}</a>
      	</c:forEach>
    </div>
</c:forEach>
</div>