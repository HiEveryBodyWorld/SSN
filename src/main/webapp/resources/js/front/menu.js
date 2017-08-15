function homePage(username){
		if(username!=null){
			document.location.href="/front/homePage?username="+username
		}else{
			document.location.href="/front/homePage"
		}
		
	}
	
	function myCollection(username){
		if(username!=null){
			document.location.href="/front/toMyCollection?username="+username
		}else{
			document.location.href="/front/toMyCollection"
		}
		
	}
	
	function askUs(username){
		if(username!=null){
			document.location.href="/front/askUs?username="+username
		}else{
			document.location.href="/front/askUs"
		}
		
	}
	
	function toProject(type){
	    var username=$("#username").val();
		if(type==3){
			location.href='project?type='+type+'&&username='+username
		}else{
			location.href="news?type="+type
		}
	}

