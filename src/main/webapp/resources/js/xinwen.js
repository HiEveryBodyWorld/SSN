// JavaScript Document
// JavaScript Document
/*.nav*/

$(function(){
	lanrenzhijia(".drop-menu-effect");
});
function lanrenzhijia(_this){
	$(_this).each(function(){
		var $this = $(this);
		var theMenu = $this.find(".submenu");
		var tarHeight = theMenu.height();
		theMenu.css({height:0});
		$this.hover(
			function(){
				$(this).addClass("mj_hover_menu");
				theMenu.stop().show().animate({height:tarHeight},400);
			},
			function(){
				$(this).removeClass("mj_hover_menu");
				theMenu.stop().animate({height:0},400,function(){
					$(this).css({display:"none"});
				});
			}
		);
	});
}


//下拉框
						$(document).ready(function(){
				//子导航展开收缩
				$(".sewvtop").click(function(){
					
					$(this).find("em img").removeClass("lbaxztop2").addClass("lbaxztop").parents(".sewv").siblings().children(".sewvtop").find("em img").removeClass("lbaxztop").addClass("lbaxztop2");
					$(this).next(".sewvbm").toggle().parents(".sewvbm").siblings().find(".sewvbm").hide();
					});
					
				
				
				
				/*鼠标离开下拉框关闭*/
				$(".sewvbm").mouseleave(function(){
					$(".sewvbm").hide();
					$(this).siblings().find("em img").addClass("lbaxztop2");
				});
		
				
				//赋值
				$(".sewvbm>li").click(function(){
					var selva=$(this).text();
					$(this).parents(".sewvbm").siblings(".sewvtop").find("span").text(selva);
					$(this).parent("ul").hide();
					$(this).parents(".sewv").children(".sewvtop").find("em img").addClass("lbaxztop2");
				});
				
			});
//时间控件
$(document).ready(function(){
		$('#demo-1').fdatepicker();
		$('#demo-2').fdatepicker({
			format: 'yyyy-mm-dd hh:ii',
			pickTime: true
		});
		$('#demo-3').fdatepicker();

		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
		var checkin = $('#dpd1').fdatepicker({
			onRender: function (date) {
				return date.valueOf() < now.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function (ev) {
			if (ev.date.valueOf() > checkout.date.valueOf()) {
				var newDate = new Date(ev.date)
				newDate.setDate(newDate.getDate() + 1);
				checkout.update(newDate);
			}
			checkin.hide();
			$('#dpd2')[0].focus();
		}).data('datepicker');
		var checkout = $('#dpd2').fdatepicker({
			onRender: function (date) {
				return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function (ev) {
			checkout.hide();
		}).data('datepicker');
		});
			