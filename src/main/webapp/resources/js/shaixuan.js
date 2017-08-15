/*    var dlNum  =$("#selectList").find("dl");
 //for (i = 0; i < dlNum.length; i++) {
 //   $(".hasBeenSelected .clearList").append("<div class=\"selectedInfor selectedShow\" style=\"display:none\"><span></span><label></label><em></em></div>");
 // }

 var refresh = "true";*/

// $(".listIndex label").live("click",function(){
//		var Asele=$(".listIndex").find("a");
//        var text =$(this).text();
//        var selectedShow = $(".selectedShow");
//        var textTypeIndex =$(this).parents("dl").index();//父级dl 的索引值
//        var textType =$(this).parent("dd").siblings("dt").text();//取上一层的文本
//        index = textTypeIndex;
//        $(".clearDd").show();
//        $(".selectedShow").eq(index).show();
//		$(this).find("a").addClass("selected");
//
//		$(this).find("input").attr("checked",true);
//		var infor='<div class=\"selectedInfor selectedShow\"><span>'+textType+'</span><label>'+text+'</label><em></em></div>'
//         $(".hasBeenSelected .clearList").append(infor);
//		selectedShow.eq(index).find("span").text(textType);
//        selectedShow.eq(index).find("label").text(text);
//		判断个数显示
//       var show = $(".selectedShow").length - $(".selectedShow:hidden").length;
//		if (show > 1) {
//         $(".eliminateCriteria").show();
//    	}
//       
//    });
/*	 $(".listIndex label").toggle(function(){
 var Asele=$(".listIndex").find("a");
 var text =$(this).text();
 var selectedShow = $(".selectedShow");
 var textTypeIndex =$(this).parents("dl").index();//父级dl 的索引值
 var textType =$(this).parent("dd").siblings("dt").text();//取上一层的文本
 index = textTypeIndex;
 $(".clearDd").show();
 $(".selectedShow").eq(index).show();
 $(this).find("a").addClass("selected");

 $(this).find("input").attr("checked",true);
 var infor='<div class=\"selectedInfor selectedShow\"><span>'+textType+'</span><label>'+text+'</label><em></em></div>';
 $(".hasBeenSelected .clearList").append(infor);

 },function(){
 $(this).find("a").removeClass("selected");
 $(this).find("input").attr("checked",false);
 });*/

//	 $(".listIndex label").toggle(function(){
//			 var text =$(this).text();
//        var selectedShow = $(".selectedShow");
//       var textTypeIndex =$(this).parents("dl").index();
//       var textType =$(this).parent("dd").siblings("dt").text();
//	           index = textTypeIndex -(2);
//			 $(this).find("a").addClass("selected");
//			 $(this).find("input").attr("checked",true);
//			 selectedShow.eq(index).find("span").text(textType);
//			 $(".selectedShow").eq(index).show();
//			  $(".clearDd").show();
//			  var show = $(".selectedShow").length - $(".selectedShow:hidden").length;
//			//if (show > 1) {
////					   $(".eliminateCriteria").show();
////				}
//		 },function(){
//			 $(this).find("a").removeClass("selected");
//	     	 $(this).find("input").attr("checked",false);
//			 });
/*
 $(".selectedShow em").live("click",function(){
 $(this).parents(".selectedShow").remove();
 var textTypeIndex =$(this).parents(".selectedShow").index();
 index = textTypeIndex;
 $("#selectList").eq(index).find("a").removeClass("selected");
 $("#selectList").eq(index).find("input").attr("checked",false);

 //if($(".listIndex .selected").length < 2){
 //    $(".eliminateCriteria").hide();
 //}
 });
 $(".eliminateCriteria").live("click",function(){
 $(".selectedShow").remove();
 //$(this).hide();
 $(".listIndex a ").removeClass("selected")
 $(".listIndex a ").prev().attr("checked",false);
 }); */


// 选项枚举
var priceEnum = {
    price0:0,                   // 0-1000元
    price1:1,                   // 1000-2000元
    price2:2,                   // 2000-3000元
    price3:3,                   // 3000-5000元
    price4:4                    // 5000元以上
};
var pointEnum = {
    point0:'中庭',
    point1:'连廊',
    point2:'外广场',
    point3:'LED',
    point4:'小点位'
};
var areaEnum = {
    area0:'50-80',
    area1:'80-150',
    area2:'150-300',
    area3:'300以上'
};
var featureEnum = {
    feature0:'购物中心',
    feature1:'百货商场',
    feature2:'主题式广场',
    feature3:'商业步行街',
    feature4:'公共广场',
    feature5:'主题乐园',
    feature6:'lifestyle中心'
};

var sourceData=[];                       // 源数据
var fitlerData=[];                      // 过滤后的数据
var curPageData=[];                     // 过滤后的数据 - 当前页显示的数据
var filterMap = {                       // 选中的过滤项
    price: [],
    point:[],
    area:[],
    feature:[]
};                  // 已选的过滤项
var page = {                    // 页数
    curPage:1,
    totalPage:1,
    numPrePage:5
}

function init(){
	var data = {
	        spaceName:$("#spaceName").val(),
	        businessArea:$("#businessArea").val(),
	        price:$("#price").val(),
	        space:$("#space").val(),
	        province:$("#province").val(),
	        city:$("#city").val(),
	        area:$("#area").val(),
	    };
	    jQuery.ajax({
	        type : 'POST',
	        url : '/front/serch',
	        data:data,
	        dataType:'json',
	        success : function(data) {
	            sourceData = data;
	            fitlerData = sourceData;
	            initPage();
	            showFilter();
	        }
	    });
}                                           // 初始化数据
function filter(){              // 过滤

    var arr = [];
    var inputStr = ''.trim();
    for(var index in sourceData){
        var inputBol = false;
        var priceBol = false;
        var pointBol = false;
        var areaBol = false;
        var featureBol = false;
        var result = false;

        var item = sourceData[index];
        // 输入文字
        inputBol = (inputStr==='') || item.xx.indexOf(inputStr) !== -1?true:false;
        priceBol = filter_price(item,filterMap.price);          // 价格
        pointBol = filter_point(item,filterMap.point);          // 点位
        areaBol = filter_area(item,filterMap.area);             // 面积
        featureBol = filter_feature(item,filterMap.feature)     // 特色


        result = inputBol && priceBol && pointBol && areaBol && featureBol;
        if(result){
            arr.push(sourceData[index]);
        }
    }
    console.log('过滤后数组：');
    console.log(arr);
    return arr;

}                                         // 过滤
function filter_price(item,priceFilterArr){
    var isClude = false;
    var locations = item.locations;
    var obj = locations?locations[0]:null;
    var itemPrice = obj?obj.price:null;

    if(priceFilterArr.length === 0){
        isClude = true;
    }else{
        if(itemPrice){
            var selectPrice = priceFilterArr[0];
            switch (selectPrice){
                case priceEnum.price0:
                    isClude = (itemPrice<1000)?true:false;
                    break;
                case priceEnum.price1:
                    isClude = (itemPrice>=1000 && itemPrice<2000)?true:false;
                    break;
                case priceEnum.price2:
                    isClude = (itemPrice>=2000 && itemPrice<3000)?true:false;
                    break;
                case priceEnum.price3:
                    isClude = (itemPrice>=3000 && itemPrice<5000)?true:false;
                    break;
                case priceEnum.price4:
                    isClude = (itemPrice>=5000)?true:false;
                    break;
            }
        }

    }
    return isClude;
}
function filter_point(item,pointFilterArr){
    var isClude = false;
    var locations = item.locations;
    var obj = locations?locations[0]:null;
    var itemPoint = obj?obj.locationName:null;

    if(pointFilterArr.length === 0){
        isClude = true;
    }else{
        if(itemPoint){
            for(var index in pointFilterArr){
                var selectPoint = pointFilterArr[index];
                if(itemPoint.indexOf(selectPoint)!= -1){
                    isClude = true;
                    break;
                }
            }
        }


    }
    return isClude;
}
function filter_area(item,areaFilterArr){
    var isClude = false;
    var locations = item.locations;
    var obj = locations?locations[0]:null;
    var itemArea = obj?obj.locationArea:null;
    if(areaFilterArr.length === 0){
        isClude = true;
    }else{
        if(itemArea){
            for(var index in areaFilterArr){
                var selectArea = areaFilterArr[index];
                switch (selectArea){
                    case areaEnum.area0:
                        isClude = (itemArea>=50 && itemArea<80)?true:false;
                        break;
                    case areaEnum.area1:
                        isClude = (itemArea>=80 && itemArea<150)?true:false;
                        break;
                    case areaEnum.area2:
                        isClude = (itemArea>=150 && itemArea<300)?true:false;
                        break;
                    case areaEnum.area3:
                        isClude = (itemArea>=300)?true:false;
                        break;
                }
                if(isClude)
                    break;
            }
        }
    }
    return isClude;
}
function filter_feature(item,featureFilterArr){
    var isClude = false;
    var itemFeature = item.features;
    if(featureFilterArr.length === 0 ){
        isClude = true;
    }else{
        if(itemFeature){
            for(var index in featureFilterArr){
                var selectFeature = featureFilterArr[index];
                if(itemFeature.indexOf(selectFeature)!= -1){
                    isClude = true;
                    break;
                }
            }
        }
    }
    return isClude;
}

function showFilter(){
    var listGourp = $("#tab-left-top");
    listGourp.html('');

    var info = ''
    for (var i = 0, size = curPageData.length; i < size; i++) {
        var areaNum =  curPageData[i].locations.length>0?(curPageData[i].locations[0].locationArea):'暂无';
        
        info += 
        	'<a onclick="allMap('+curPageData[i].longitude+','+curPageData[i].dimensions+')" ><div class="tab-left-xt " >' +
            '<h3 class="name">' + curPageData[i].spaceName + '</h3>' +
            '<div class="adress">所属商圈：' +curPageData[i].businessCircle + '</div>' +
            '<div class="city">面积：' + areaNum + '</div>' +
            '<div class="platform">所属类型：' + curPageData[i].type + '</div>' +
            '<div class="platform">客流量：' + curPageData[i].traffic + '</div>' +
            '<div class="platform">详细地址：' + curPageData[i].address + '</div>' +
            '</div></a>';
    }
    listGourp.html(info);

}                                                              // 显示过滤结果

function  allMap(longitude,dimensions) {
	
	var map = new BMap.Map("allmap");
		
	map.centerAndZoom(new BMap.Point(116.331398,39.897445),11);
    map.enableScrollWheelZoom(true);
	
	if(longitude != "" && dimensions != ""){
		
	    map.clearOverlays(); 
	    var new_point = new BMap.Point(longitude,dimensions);
	    var marker = new BMap.Marker(new_point);  // 创建标注
	    map.addOverlay(marker);              // 将标注添加到地图中
	    map.panTo(new_point);      
	    }
}

var curPageNum = $(".curPageNum");                             // 处理页数
var totalPageNum = $(".totalPageNum");
var previousPage =  $(".previous");
var nextPage =  $(".next");
function initPage(){
    page.curPage = 1;
    var totalNum = fitlerData.length;
    page.totalPage = (totalNum%page.numPrePage === 0 && totalNum != 0)?
        (totalNum/page.numPrePage ) :
    Math.floor(totalNum/page.numPrePage ) + 1;

    curPageData = fitlerData.slice(0, page.numPrePage);

    console.log(page);

    curPageNum.text( page.curPage );
    totalPageNum.text( page.totalPage );
}
function turnPage(num){                                        // 翻页
    if(num<1 || num>page.totalPage)return;
    page.curPage = num;
    var totalNum = fitlerData.length;
    page.totalPage = (totalNum%page.numPrePage === 0 && totalNum != 0)?
        (totalNum/page.numPrePage ) :
    Math.floor(totalNum/page.numPrePage ) + 1;

    curPageData = fitlerData.slice((num-1) * page.numPrePage,(num-1) * page.numPrePage + page.numPrePage);

    //console.log(page);

    curPageNum.text( page.curPage );
    totalPageNum.text( page.totalPage );

}
previousPage.click(function () {
    console.log('点击前一页');
    turnPage(page.curPage -1);
    showFilter();
});
nextPage.click(function () {
    console.log('点击下一页');
    turnPage(page.curPage + 1);
    showFilter();
});

function compareFilterMap(newFilterMap) {                                   // 比较 已选的过滤项 是否变化
    var change = false;
    if(filterMap.price.length != newFilterMap.price.length
        || filterMap.point.length != newFilterMap.point.length
        || filterMap.area.length != newFilterMap.area.length
        || filterMap.feature.length != newFilterMap.feature.length
        || filterMap.price[0] != newFilterMap.price[0]
    ){
        change = true;
        console.log('过滤项有变化')
    }
    return change;
}

init();




$('.clearDd').show();


var okSelect = []; //已经选择好的
var oSelectList = document.getElementById('selectList');

var oClearList = $(".hasBeenSelected .clearList");
var oCustext1 = document.getElementById('custext1');
var oCustext2 = document.getElementById('custext2');
var aItemTxt = oSelectList.getElementsByTagName('a');
var isCusPrice = false;//是否自定义价格
var radioVal = '';


oSelectList.onclick = function (e, a) {
    //alert(aItemTxt)
    var ev = e || window.event;
    var tag = ev.target || ev.srcElement;
    if (!tag)return;
    var tagName = tag.nodeName.toUpperCase();
    var infor = '';
    var aRadio = document.getElementsByName('radio2');      // 价钱单选的集合

    if (isCusPrice) {
        radioVal = oCustext1.value + '-' + oCustext2.value + '元';
    } else {
        radioVal = '';                                     // 价格单价
    }

    if (tagName == 'INPUT') {
        if (tag.getAttribute('type').toUpperCase() == 'CHECKBOX') { //如果点击 的是 input checkbox
            var val = next(tag);
            if (tag.checked) {
                var sType = prev(parents(tag, 'dd')).innerHTML;
                val && okSelect.push(trim(val.innerHTML) + '|' + sType);
                console.log('选中类型：'+sType+'---'+val.innerHTML);
            } else {
                var sType = prev(parents(tag, 'dd')).innerHTML;
                delStr(val.innerHTML + '|' + sType, okSelect);

                console.log('取消选中：'+sType+'---'+val.innerHTML);
            }
        } else if (tag.getAttribute('type').toUpperCase() == 'BUTTON') { //如果点击的是 自定义价格按钮
            radioVal = oCustext1.value + '-' + oCustext2.value + '元';
            isCusPrice = true;

            for (var i = 0; i < aRadio.length; i++) {
                aRadio[i].checked = false;
            }

        }
    } else if (tagName == 'A') { //如果点击 的是 A
        var oPrevInput = prev(tag);

        if (!oPrevInput) { //如果上一个节点没有则认为点击的是 '不限'
            console.log('点击不限');
            var parent = parents(tag, 'dd');
            var aItem = parent.getElementsByTagName('label');
            if (parent.getAttribute('data-more')) {             // 面积、特色
                //var allCheckbox = next(parents(parent, 'dl')).getElementsByTagName('label');
                var allCheckbox = parents(parent, 'dl').getElementsByTagName('label');
                var sType = '';
                for (var i = 0, len = allCheckbox.length; i < len; i++) {
                    sType = prev(parents(allCheckbox[i], 'dd')).innerHTML;
                    delStr(text(allCheckbox[i]) + '|' + sType, okSelect);
                    allCheckbox[i].children[0].checked = false;


                    console.log('取消选中：'+sType+'---'+text(allCheckbox[i]));
                }
            }

            if (trim(prev(parent).innerHTML) == '酒店价格') { //这里是直接根据 text来比较的.建议加个自定义属性作标识符
                //for (var i = 0; i < aRadio.length; i++) {
                //    aRadio[i].checked = false;
                //}
                //isCusPrice = false;
                //a = true;
                //radioVal = '';
            } else {
                var sType = '';
                for (var i = 0, len = aItem.length; i < len; i++) {
                    sType = prev(parents(aItem[i], 'dd')).innerHTML;
                    delStr(text(aItem[i]) + '|' + sType, okSelect);
                    aItem[i].children[0].checked = false;

                    console.log('取消选中：'+sType+'---'+text(aItem[i]));
                }
            }
        } else {
            if (oPrevInput && oPrevInput.getAttribute('type').toUpperCase() == 'RADIO') { //radio
                isCusPrice = false;
                oPrevInput.checked = true;

                console.log('点击了一个价格：'+tag.innerHTML );
            }else if (oPrevInput && oPrevInput.getAttribute('type').toUpperCase() == 'CHECKBOX') { //获取checkbox
                if (oPrevInput.checked) {
                    oPrevInput.checked = false;
                    var sType = prev(parents(tag, 'dd')).innerHTML;
                    delStr(tag.innerHTML + '|' + sType, okSelect);

                    console.log('取消选中：'+sType+'---'+tag.innerHTML);
                } else {
                    oPrevInput.checked = true;
                    var sType = prev(parents(tag, 'dd')).innerHTML;
                    okSelect.push(trim(tag.innerHTML) + '|' + sType)

                    console.log('选中类型：'+sType+'---'+tag.innerHTML);
                }
            }
        }
    }

    var newfilterMap = {
        price: [],
        point:[],
        area:[],
        feature:[]
    }
    for (var i = 0; i < aRadio.length; i++) {
        if (aRadio[i].checked) {
            radioVal = next(aRadio[i]).innerHTML;
            isCusPrice = false;

            newfilterMap.price.push(priceEnum['price' + i]);
            break;
        }
    }

    if (a) {
        isCusPrice = false;
    }

    if (a && a == 2) {
        for (var i = 0; i < aRadio.length; i++) {
            aRadio[i].checked = false;
        }

    } else {
        if (radioVal) infor += '<div class=\"selectedInfor selectedShow\"><span>酒店价格</span><label>' + radioVal + '</label><em p="2"></em></div>';
    }


    var vals = [];



    for (var i = 0, size = okSelect.length; i < size; i++) {
        vals = okSelect[i].split('|');
        infor += '<div class=\"selectedInfor selectedShow\"><span>' + vals[1] + '</span><label>' + vals[0] + '</label><em></em></div>';


        switch (vals[1]){
            case '点位':
                newfilterMap.point.push(vals[0]);
                break;
            case '面积':
                newfilterMap.area.push(vals[0]);
                break;
            case '特色':
                newfilterMap.feature.push(vals[0]);
                break;
        }
    }
    oClearList.html(infor);

    if(compareFilterMap(newfilterMap)){
        filterMap = newfilterMap;
        fitlerData = filter();
        turnPage(1);
        showFilter();
    }

};
$('div.eliminateCriteria').click(function () {                  // 清空全部
    $(oSelectList).find('input').attr('checked', false);
    radioVal = '';
    isCusPrice = false;
    okSelect.length = 0;
    $(oSelectList).trigger('click', 1);
})

$('.clearList').find('em').live('click', function () {          // 已选条件中取消
    var self = $(this);
    var val = self.prev().html() + '|' + self.prev().prev().html();
    var n = -1;
    var a = this.getAttribute('p') || 1;
    self.die('click');
    for (var i = 0, len = aItemTxt.length; i < len; i++) {
        var html = val.split('|')[0];
        if (trim(aItemTxt[i].innerHTML) == html) {
            prev(aItemTxt[i]).checked = false;
            break;
        }
    }
    ;
    delStr(val, okSelect);
    $(oSelectList).trigger('click', a);

})



function delStr(str, arr) { //删除数组给定相同的字符串
    var n = -1;
    for (var i = 0,
             len = arr.length; i < len; i++) {
        if (str == arr[i]) {
            n = i;
            break;
        }
    }
    n > -1 && arr.splice(n, 1);
};
function trim(str) {
    return str.replace(/^\s+|\s+$/g, '')
};
function text(e) {
    var t = '';
    e = e.childNodes || e;
    for (var j = 0; j < e.length; j++) {
        t += e[j].nodeType != 1 ? e[j].nodeValue : text(e[j].childNodes);
    }
    return trim(t);
}

function prev(elem) {                           // 上一个同级元素
    do {
        elem = elem.previousSibling;
    } while (elem && elem.nodeType != 1);       // nodeType  1 元素  2 属性
    return elem;
};

function next(elem) {
    do {
        elem = elem.nextSibling;
    } while (elem && elem.nodeType != 1);
    return elem;
}

function parents(elem, parents) {  //查找当前祖先辈元素需要的节点  如 parents(oDiv, 'dd') 查找 oDiv 的祖先元素为dd 的
    if (!elem || !parents) return;
    var parents = parents.toUpperCase();
    do {
        elem = elem.parentNode;
    } while (elem.nodeName.toUpperCase() != parents);
    return elem;
};


