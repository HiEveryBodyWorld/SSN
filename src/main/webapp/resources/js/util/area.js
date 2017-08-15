// 点击新增或编辑按钮调用
function areaDlg(acode){
	// 设置省市县
    var areav = acode; // 县编码
    var cityv = Math.floor(areav/100)*100 ;
    var provincev = Math.floor(areav/10000)*10000 ;
    
	// 编辑div中的
    var province = $('#province').combobox({
        url:'/sys/area/listAll?pareacode=100000',
        editable:false,
        valueField:'areacode',
        textField:'areaname',
        onSelect:function(record){
            //刷新数据，重新读取省份下的城市，并清空当前输入的值
            city.combobox({
                disabled:false,
                url:'/sys/area/listAll?pareacode='+record.areacode,
                valueField:'areacode',
                textField:'areaname',
                onSelect:function(record){
                    //刷新数据，重新读取省份下的城市，并清空当前输入的值
                	area.combobox({
                        disabled:false,
                        url:'/sys/area/listAll?pareacode='+record.areacode,
                        valueField:'areacode',
                        textField:'areaname'
                    }).combobox('clear');
                }
            }).combobox('clear');
            area.combobox('clear');
        }
    });
    var city = $('#city').combobox({
        //disabled:true,
        url:'/sys/area/listAll?pareacode='+provincev,
        valueField:'areacode',
        textField:'areaname'
    });
    var area = $('#area').combobox({
        //disabled:true,
        url:'/sys/area/listAll?pareacode='+cityv,
        valueField:'areacode',
        textField:'areaname'
    });
    
    $('#province').combobox('setValue',provincev) ;
    $('#city').combobox('setValue',cityv) ;
    $('#area').combobox('setValue',areav) ;
}

$(function(){
        // 筛选条件中的
        var pcode = $('#_pcode').combobox({
            url:'/sys/area/listAll?pareacode=100000',
            editable:false,
            valueField:'areacode',
            textField:'areaname',
            onSelect:function(record){
                //刷新数据，重新读取省份下的城市，并清空当前输入的值
                ccode.combobox({
                    disabled:false,
                    url:'/sys/area/listAll?pareacode='+record.areacode,
                    valueField:'areacode',
                    textField:'areaname',
                    onSelect:function(record){
                        //刷新数据，重新读取省份下的城市，并清空当前输入的值
                    	acode.combobox({
                            disabled:false,
                            url:'/sys/area/listAll?pareacode='+record.areacode,
                            valueField:'areacode',
                            textField:'areaname'
                        }).combobox('clear');
                    }
                }).combobox('clear');
                acode.combobox('clear');
            }
        });
        var ccode = $('#_ccode').combobox({
            disabled:true,
            url:'/sys/area/listAll?pareacode='+pcode.val(),
            valueField:'areacode',
            textField:'areaname'
        });
        var acode = $('#_acode').combobox({
            disabled:true,
            url:'/sys/area/listAll?pareacode='+pcode.val(),
            valueField:'areacode',
            textField:'areaname'
        });
});


