$.extend($.fn.validatebox.defaults.rules, {  
    // 手机号码  
	mobile : {
		 validator : function(value) {
			 return /^(13|15|18|17)[0-9]{9}$/i.test(value); 
		},
		message : "手机号码格式不正确"
	},
	
	// 电话号码  
	phone : {
	    validator : function(value) {  
	        return /^([0-9]{3,4}-)?[0-9]{7,8}$/i.test(value);  
	    },  
	    message : "格式不正确,请使用下面格式:010-88888888" 
	},

	// 版本号  
	version : {
	    validator : function(value) {  
	        return /^\d+(\.\d+)*$/i.test(value);  
	    },  
	    message : "版本格式不正确,请使用下面格式:x.x.x" 
	},

	// 密码
	password : {
		 validator : function(value) {
			 return /^\w{5,16}$/i.test(value); 
		},
		message : "密码长度为5-16个字符,只能包含数字,大小写字母及下划线"
	},
	
	// 身份证
	idcard: {
        validator: function (value, param) {
            return idCard(value);
        },
        message:'身份证号码不正确'
    },
    
    //验证英文数字
    ENG: {
        validator: function (value) {
            return /^[a-zA-Z0-9]+$/.test(value);
        },
        message: '只能输入数字及字母'
    },

    //验证英文数字
    ONLY_ENG: {
        validator: function (value) {
            return /^[a-zA-Z]+$/.test(value);
        },
        message: '只能输入大小写字母'
    },

    //验证汉字
    CHS: {
        validator: function (value) {
            var flag = /^[\u0391-\uFFE5]+$/.test(value);
            return flag && !isChsOther(value);
        },
        message: '只能输入正确汉字'
    },

    //验证汉字和数字及字母
    CHS_ENG: {
        validator: function (value) {
            var flag = /^[a-zA-Z0-9\u4e00-\u9fa5]+$/.test(value);
            return flag && !isChsOther(value);
        },
        message: '只能输入正确汉字、数字及字母'
    },
});
//65288,65289 中文括号
var chs_other_code = [183,215,8212,8216,8217,8220,8221,8230,12289,12290,12298,12299,12304,12305,65281,65283,65284,65285,65286,65290,65291,65292,65293,65306,65307,65309,65311,65312,65339,65340,65341,65342,65343,65371,65372,65373,65374];
var isChsOther = function (value) {
	for (var i = 0; i < value.length; i++) {
		if (chs_other_code.contains(value.charCodeAt(i))) {
			return true;
		}
	}
	return false;
}

/** 身份证校验相关 */
var idCard = function (value) {
    if (value.length == 18 && 18 != value.length) return false;
    var number = value.toLowerCase();
    var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
    if (re == null || a.indexOf(re[1]) < 0) return false;
    if (re[2].length == 9) {
        number = number.substr(0, 6) + '19' + number.substr(6);
        d = ['19' + re[4], re[5], re[6]].join('-');
    } else d = [re[9], re[10], re[11]].join('-');
    if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;
    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
}

var isDateTime = function (format, reObj) {
    format = format || 'yyyy-MM-dd';
    var input = this, o = {}, d = new Date();
    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
    var len = f1.length, len1 = f3.length;
    if (len != f2.length || len1 != f4.length) return false;
    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
    o.dd = s(o.dd, o.d, d.getDate(), 31);
    o.hh = s(o.hh, o.h, d.getHours(), 24);
    o.mm = s(o.mm, o.m, d.getMinutes());
    o.ss = s(o.ss, o.s, d.getSeconds());
    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
    d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
    var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
    return reVal && reObj ? d : reVal;
    function s(s1, s2, s3, s4, s5) {
        s4 = s4 || 60, s5 = s5 || 2;
        var reVal = s3;
        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
        if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
        return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
    }
};


/** 校验图片格式及大小 */
function validateImage(obj) {
    var file = obj;
    var tmpFileValue = file.value;
    if(tmpFileValue!=""){
	    //校验图片格式
	    if(/^.*?\.(png|jpg|jpeg|gif)$/.test(tmpFileValue.toLowerCase())){
	    } else {
	    	alertMsg("只能上传jpg、jpeg、png、gif格式的图片！");
	        return false;
	    }
	    if(file.files[0].size > 1024 * 1024 * 1){
	    	alertMsg("图片大小不能超过1M");
	    	return false;
	    }
    }
    return true;
}

