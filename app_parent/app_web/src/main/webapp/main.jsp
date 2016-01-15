<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resource/img/favicon.png">
    <title>监控中心</title>

    <link href="resource/ui/plugins/grid/css/ui.jqgrid-bootstrap.css" rel="stylesheet">
    <link href="resource/ui/plugins/tree/css/metroStyle/metroStyle.css" rel="stylesheet">
    <link href="resource/ui/css/bootstrap.css" rel="stylesheet"> 
    <link href="resource/ui/css/elusive-webfont.css" rel="stylesheet"> 
    <style type="text/css">
		@font-face {
		  font-family: 'Glyphicons Halflings';
		  src: url('resource/ui/fonts/glyphicons-halflings-regular.eot');
		  src: url('resource/ui/fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('resource/ui/fonts/glyphicons-halflings-regular.woff') format('woff'), url('resource/ui/fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('resource/ui/fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
		}
    
    	body{
    		background: #E9E9E9;
    		color: #000;
			font-size: 12px;
			font-family: "Helvetica Neue",Helvetica,STheiti,微软雅黑,宋体,Arial,Tahoma,sans-serif,serif;
    	}
    	.pull-down-menu{
    		width: 100%;
    		font-size: 12px;
    	}
    	.pull-down-menu dt {
    		width: 100%;
    		font: 13px;
    		border-bottom: 1px solid #ccc;
    	}
    	.pull-down-menu dd{
    		float: left;
    		margin:5px;
    	}
    	
    	#top_nav{
    		border-top:1px solid red;
    		border-bottom:2px solid green;
    	}
    	
    	#wrapper {
    		width:100%;
    		margin: 0px;
    		padding: 0px;
		 	padding-top: 50px;
		}
		
		#left_nav_menu{
/* 			-moz-box-shadow:-5px 0px 5px #ccc inset;             */
/* 			-webkit-box-shadow:-5px 0px 5px #ccc inset;          */
/* 			box-shadow:-5px 0px 5px #ccc inset; */
			border-right: 1px solid #ccc;
			padding:0px;
			overflow-y: auto;
			overflow-x: hidden;
			background: #E9E9E9;
		}
		
		#content{
			overflow: auto;
			background:#FFFFFF;
			min-height:200px;
		}
		
		#footer{
			height: 40px;margin: 0px;padding: 0px;background-color: #009F95;min-height: 40px;max-height:40px;
			text-align: center;
			border-top: 2px solid green;
		}
		
		.navbar-inverse .navbar-nav > .open > a, .navbar-inverse .navbar-nav > .open > a:hover, .navbar-inverse .navbar-nav > .open > a:focus {
/* 		    background-color: #008000; */
		    background-color: #008EAD;
/* 		    color: #fff; */
		}
		
    </style>
    <link rel="shortcut icon" href="resource/ui/img/favicon.ico">
    
</head>
<body>
    <nav id="top_nav" class="navbar navbar-inverse navbar-fixed-top">
         <div class="navbar-header fixed-brand">
             <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
               <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
             </button>
             <a class="navbar-brand" href="#" style="height:30px;color:#66c3ec;font-size: 15px;font-weight: 100;text-align: center;padding-bottom: 10px;text-shadow: 1px 1px 0 #666, 2px 2px 0 #eee;"><i class="fa fa-rocket fa-4"></i> 监控中心</a>
         </div>

         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="background:#009F95;">
             <ul class="nav navbar-nav navbar-right">
             	<li><a href="#" style="margin-right: 10px;color:#66c3ec;" onclick="javascript:quitSystem()">退出</a></li>
             </ul>
         </div>
    </nav>
    
    <div id="wrapper" class="row">
    	<div id="left_nav_menu" class="col-md-2">
    		<div class="row" style="height: 35x;border-bottom: 2px solid red;margin: 0px;padding: 0px;">
    			<p style="margin-top: 10px;margin-left:30px;"><img src="resource/img/manage.png" width="20" height="20"/><span style="color:red;padding-left:15px;"><c:if test="${!empty loginUser}">${loginUser}</c:if></span>,你好</p>
<!--     			<img src="resource/img/dbcenter.png" width="64" height="64"/> -->
<!--     			<p style="height:30px;color:#66c3ec;font-size: 15px;font-weight: 100;text-align: center;padding-bottom: 10px;text-shadow: 1px 1px 0 #666, 2px 2px 0 #eee;">监控中心</p> -->
    		</div>
    		<div id="accordion" class="accordion" style="margin:0px;padding:0px;width:100%;padding-left:20px;">
    			<ul id="treeDemo" class="ztree"></ul>
			</div>
    	</div>
    	<div class="col-md-10" style="margin:0px;padding:0px;overflow:hidden">
    		<div class="row" style="background:#F5F5F5;max-height:35px;overflow:hidden;font-size: 14px;font-weight: 60;border-bottom: 2px solid red;">
    			<div id="navMenu" class="col-sm-6" style="padding-left:10px;">
    				<ol class="breadcrumb">
					  <li class="active">我的工作台</li>
					</ol>
    			</div>
    			<div class="col-sm-5">
    				<marquee style="width:100%;padding-top: 10px;" scrollamount="3" direction="left" >
<!-- 						<p ><a href="javascript:alert(11)"><font color="red">王五提交请假3天申请、马六吹促你审核2014年的财务报表</font ></a></p > -->
					</marquee >
    			</div>
    			<div class="col-sm-1">&nbsp;</div>
    		</div>
    		<div class="row" id="content" style="overflow:auto;margin:0px;padding:0px;padding-top:15px;">
	    		内容
    		</div>
    	</div>
    </div>
    <div id="footer" class="row">
    	Copyright @ 2012 by hiwan.com. All Rights Reserved.
    </div>
	<script src="resource/jquery-2.1.3.min.js"></script>
	<script src="resource/ui/js/common.js"></script>
	<script type="text/javascript" src="resource/ui/plugins/layer/layer.js"></script>
    <script type="text/javascript" src="resource/ui/plugins/grid/js/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript" src="resource/ui/plugins/grid/js/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="resource/ui/plugins/tree/js/jquery.ztree.core-3.5.js"></script>
    <script src="resource/ui/js/jquery.hashchange.js"></script>
    <script src="resource/ui/js/bootstrap.min.js"></script>
    <script src="resource/ui/js/bootstrap-contextmenu.js"></script>
    <script type="text/javascript">
    	var treeObj ;
    	var setting = {
   			async: {
				enable: true,
				type: "post",
				contentType: "application/json",
				dataType:"json",
                url:'loadNav.do?parentId=0&recursive=true'
  			},
   			data: {
   				simpleData: {
   					enable: true,
   					idKey: "id",  
                    pIdKey: "parentId",
   				}
   			},
   			callback: {
   				onClick: onClick,
   				onAsyncSuccess: zTreeOnAsyncSuccess
   			}
   		};
    	
    	function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
    		if(location.hash != ''){
	   			 $.each(eval(msg),function(i,item){
  	    	    	/*if((location.hash+'').split('?')[0] == item.path){
  	    	    		var node = treeObj.getNodeByParam("id", item.id);
  	    	    		treeObj.selectNode(node);
  	    	    		$('#navMenu').html(item.navMenu);
  	    	    	}*/
	   				if((location.hash+'') == item.path){
	   					document.title = item.name;
  	    	    		var node = treeObj.getNodeByParam("id", item.id);
  	    	    		treeObj.selectNode(node);
  	    	    		$('#navMenu').html(item.navMenu);
  	    	    	}
	   	    	 });
    		}
    		treeObj.expandAll(true);
    	};
    		
   		function onClick(event, treeId, treeNode, clickFlag) {
   			if(undefined != treeNode.path && treeNode.path.length !=0){
   				document.title = treeNode.name;
   				window.location.href=treeNode.path;
   				$('#navMenu').html(treeNode.navMenu);
   			}else{
   				document.title = "页面没找到";
   				window.location.href='#';
   				$('#content').html('<div class="alert alert-danger" role="alert">404页面没找到</div>');
   			}
   		}
   		
//    		function loadNav(){
//    			$.post('loadNav.do?parentId=0&recursive=true',function(data){
//    				treeObj = $.fn.zTree.init($("#treeDemo"), setting, eval(data));
//    			});
//    		}
   		function resetMenu(path){
   			try{
   				var tmp = '#!'+path;
   				/*var array = path.split('?');
   				if(array.length == 2){
   					tmp = '#!'+array[0];
   				}else{
   					tmp = '#!'+path;
   				}*/
   				var node = treeObj.getNodeByParam("path", tmp);
   				treeObj.selectNode(node);
			}catch(e){
				//loadPage(path);
			}
   		}
   		
   		
	    $(function(){
	    	$(window).bind('hashchange', function(e) {
	    		if(location.hash != ''){
	    			var path = (location.hash+'').replace("#!","");
	    			loadPage(path);
	    			{
	    				resetMenu(path);
	    			}
	    		}
	    	});

	    	$(window).trigger( 'hashchange' );
	    	
	    	window_resize();
	    	
	    	treeObj = $.fn.zTree.init($("#treeDemo"), setting);
	    	//loadNav();
	    });
	    
	    $(window).resize(function () {
    		window_resize();
    	});
    	
    	function window_resize(){
    		$('#left_nav_menu').css({'max-height':($(window).height()-90)+'px','height':($(window).height()-90)+'px'});
    		$('#content').css({'max-height':($(window).height()-125)+'px','height':($(window).height()-125)+'px'});
    	}
	    
	    function loadPage(path){
	    	$.ajax({
 				  type: 'GET',
 				  contentType: "application/x-www-form-urlencoded; charset=utf-8",
 				  url: path,
 				  dataType: "html",
 				  cache:false, 
 				  success: function(data){
 					$('#content').html(data);
 				  },
 				  beforeSend:function(){
 					$('#content').html('<div class="alert alert-info" role="alert">数据加载中 。。。</div>');
 				  },
 				  error:function(){
 					$('#content').html('<div class="alert alert-danger" role="alert">404页面没找到</div>');
 				  }
			});
	    }
    
	    function quitSystem(){
	    	cusConfirm(null,'退出提示','你确定要退出系统?',function(){
	    		window.location.href='quitSystem.do?code='+Math.random();
	    	});
	    }
	    
    </script>
</body>
</html>