Dialog = {
		open:function(opt){
			$.ajax({
				  type: 'POST',
				  contentType: "application/x-www-form-urlencoded; charset=utf-8",
				  url: opt.url,
				  data: opt.data,
				  dataType: "html",
				  cache:false, 
				  success: function(data){
					$(opt.showDiv).html(data);
					$(opt.modal).modal('show')
				  },
				/*  beforeSend:function(){
					$(opt.showDiv).html('<div class="alert alert-info" role="alert">数据加载中 。。。</div>');
				  },*/
				  error:function(){
					$(opt.showDiv).html('<div class="alert alert-danger" role="alert">404页面没找到</div>');
				  }
				});
		}
}


StringUtils = {
		isEmpty:function(value){
			if(value == null || value.length <= 0){
				return true;
			} 
			return false;
		},
	   
		isBlank:function(value){
			var strLen;
	        if (value == null || (strLen = value.length) <= 0 || value == "") {
	            return true;
	        }
	        return false;
		}
}