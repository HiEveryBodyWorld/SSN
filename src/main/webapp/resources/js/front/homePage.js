//加载数据
$(function(){
	hootCity();
});

//热门城市
function  hootCity(){
	jQuery.ajax({
        type : 'POST',
        contentType : 'application/json',
        url : '/front/hootCity',
        dataType : 'json',
        async:false,
        success : function(data) {
        	var count = '';
        	for(var i = 0 ; i < data.length ; i ++){
        		var apo = data[i] ;
        		count += '<div id="sca1" class="warp-pic-list" style="margin-bottom:10px;margin-top:15px;border-top:1px solid rgba(186, 186, 186, 0.59);padding-top:2px;">';
        		count += '<div class="name_T" style="border-left:4px solid red;padding-left:6px;margin-bottom:4px;">'+apo.cityName+'</div>';
        		count += '<div id="wrapBox1" class="wrapBox">';
        		count += '<ul id="count1" class="count clearfix">';
        		for(var j=0 ; j<apo.spaceList.length ; j++){
        			var space = apo.spaceList[j];
        			count +='<li style="margin-right:8px;"><a href="/front/toCBDDetail/'+space.id+'" class="img_wrap"><img src="'+space.spaceImageUrl[0]+'" border="0"></a><span class="qh_title">'+space.spaceName+'</span><span class="qh_title01" style="padding-bottom:20px;">'+space.address+'</span></li>'
        		}
        		count += '</ul>';
        		count +='</div>';
        		count +='<a id="right1" class="prev icon btn"></a><a id="left1" class="next icon btn"></a>';
        		count +='</div>';
        		
        	}
        	
        	$("#hootCity").empty() ;
        	$("#hootCity").append(count) ;
        }
	})
}

//新闻
