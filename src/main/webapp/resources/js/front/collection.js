//加载数据
$(function(){
	collection();
});

//我的收藏
function  collection(){
	
	var username = $("#username").val();
		jQuery.ajax({
        type : 'POST',
        contentType : 'application/json',
        url : '/front/myCollection?username='+username,
        dataType : 'json',
        async:false,
        success : function(data) {
        	var count = '';
        	for(var i = 0 ; i < data.length ; i ++){
        		var apo = data[i] ;
        		count +='<div class="brick small">';
        		count +='<a class="delete" href="#">&times;</a><div class="shoucang_neirong"><div class="no01">'+apo.spaceName+'</div>';
        		count +='<div class="suoshushangquan">所属商圈：'+apo.businessCircle+'</div><div class="mianji" >面积：'+apo.businessArea+'</div><div class="suoshuleixing">所属类型：'+apo.type+'</div><div class="keliuliang">客流量：'+apo.traffic+'</div>';
        		count +='<div class="dizhi">地址：'+apo.address+'</div></div></div>';
        	}
        	$("#collections").empty() ;
        	$("#collections").append(count) ;
        }
	})
}

