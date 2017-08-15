$(function(){

    $(".dp").click(function(){
        if($(".dp").css("white-space") == "nowrap"){
            $(".dp").css("white-space","inherit");
        }else{
            $(".dp").css("white-space","nowrap");
        }
    })
})