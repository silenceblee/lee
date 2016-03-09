<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>

<!-- 模态框（Modal） -->
<div class="modal fade" id="dictTypeAddModal" tabindex="-1" role="dialog"   
	aria-labelledby="dictTypeAddTitle" aria-hidden="true" data-backdrop="static"
	data-keyboard=false>
   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header bg-primary">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="dictTypeAddTitle" >
	           			字典类型
	            </h4>
	         </div>
	         <div class="modal-body">
	                   <form class="form-horizontal" role="form" id="dictTypeAddForm">
						     <div class="form-group">
								<label for="dictType" class="col-sm-2 control-label">编码:</label>
								<div class="col-sm-8">
								 	 <input type="text"  name="dictType" id="dictType" class="form-control" placeholder="请输入编码" required="required" maxlength="6">
								</div>
							</div>
						    <div class="form-group">
						      	 <label for="dictName" class="col-sm-2 control-label">名称:</label>
						      	 <div class="col-sm-8">
						         	<input type="text"   name="dictDesc" id="dictDesc" class="form-control" placeholder="请输入名称" required="required" maxlength="50">
						         </div>
					      	</div>							 
					      <div class="form-group">
					     	    <label for="name"  class="col-sm-2 control-label">备注:</label>
					     	    <div class="col-sm-8">
	  							   	<textarea  name="remark" id="remark" class="form-control" rows="3" maxlength="200"></textarea>
	  							</div>
					      </div>						
				  	 </form>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-primary" onclick="dictTypeAddSubmit();">
	               	确定
	            </button>
	             <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭
	            </button>
	         </div>
	      </div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script>
function dictTypeAddSubmit(){
	 var form = $("#dictTypeAddForm");
	if(form.valid()){
		$.ajax({
			   type: "POST",
			   url: "dict/dictTypeAdd.do",
			   data: form.serialize(),
			   success: function(data){
				  obj = jQuery.parseJSON(data);
			      if(obj != null){
			    	  $('#errorMsgDiv').on('show.bs.modal', function () {
			    		  	$("#errorMsgDiv .modal-body").html(obj.msg);
			    		})
			    	  $("#errorMsgDiv").modal("show");
			      }else{
			    	  
			      }
			   }
			});
	} 
}
</script>

<script>
$(function(){
	$('#dictTypeAddForm').validate({  
        errorElement : 'span',  
        errorClass : 'help-block',  
        focusInvalid : false,  
        highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error');  
        },  
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },  
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },  
        submitHandler : function(form) {  
            form.submit();  
        }  
    });  
    /* $('#dictTypeAddForm input').keypress(function(e) {  
        if (e.which == 13) {  
            if ($('.form-horizontal').validate().form()) {  
                $('.form-horizontal').submit();  
            }  
            return false;  
        }  
    });   */
})
</script>