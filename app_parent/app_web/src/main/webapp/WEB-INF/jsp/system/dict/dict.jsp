<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!-- 字典类型表格设置 -->
<div class="panel panel-primary">
	<div class="panel-heading">
		<!-- 列表标题 -->
		<h3 class="panel-title">
			 <a data-toggle="collapse" href="#dictTypeDiv">字典类型</a>
			 <div class="pull-right">
			 	<!-- <span class="badge btn-warning" data-toggle="modal" data-target="#myModal">查询</span> -->
			    <span class="badge btn-warning" data-toggle="collapse" data-target="#dictTypeQueryDiv">查询</span>
			    <span class="badge btn-info" onclick="dictTypeAdd();">新增</span>
			    <span class="badge btn-success">修改</span>
			    <span class="badge btn-danger">删除</span>
			    <span class="badge btn-default">查看</span>
			</div>
		</h3>
	</div>
	<div id="dictTypeDiv" class="collapse in">
		<!-- 查询条件 -->
		<div id="dictTypeQueryDiv" class="collapse">
			<br>
			 <form class="form-horizontal" role="form" id="queryForm">
		        <div class="form-group">
			      <label for="queryDictType" class="col-sm-2 control-label">编码：</label>
			      <div class="col-sm-3">
			         <input type="text" class="form-control" name="dictType" id="queryDictType"  placeholder="请输入编码">
			      </div>
		      	 <label for="queryDictDesc" class="col-sm-2 control-label">名称：</label>
		      	 <div class="col-sm-3">
		         	<input type="text" class="form-control"  name="dictDesc" id="queryDictDesc"  placeholder="请输入名称">
		         </div>
		      </div>
		   </form>
		   <div class="text-center">
		  	 <button type="button" class="btn btn-primary btn-xs" onclick="query();">确定</button>
		  	 <button type="button" class="btn btn-primary btn-xs" onclick="reset();">重置</button>
		   </div>
		   <br>
		</div>	
		<!-- jqGrid表格 -->
		<table id="dictTypeTable"></table>
		<div id="dictTypeTable_pager"></div>
	</div>
</div>

<!-- 字典明细表格 -->
<div class="panel panel-primary">
	<!-- 表格标题 -->
	<div class="panel-heading">
		<h3 class="panel-title">
			 <a data-toggle="collapse" href="#dictEntryDiv" >字典明细</a>
			 <div class="pull-right">
			    <span class="badge btn-info">新增</span>
			    <span class="badge btn-success">修改</span>
			    <span class="badge btn-danger">删除</span>
			    <span class="badge btn-default">查看</span>
			</div>
		</h3>
	</div>
	<!-- jqGrid表格 -->
	<div id="dictEntryDiv" class="collapse in">
		<table id="dictTypeEntry"></table>
		<div id="dictTypeEntry_pager"></div>
	</div>
</div>
<div id="optDiv"></div>
<script type="text/javascript">
var mainGrid = null;
var detailGrid = null;
$(document).ready(function(){
	var grid_selector = "#dictTypeTable";
	var pager_selector = "#dictTypeTable_pager";
	$(window).on('resize.jqGrid', function () {
		//subgrid列的宽度
		$(grid_selector).jqGrid( 'setGridWidth', $(".page-content").width()-20 );
		$("#dictTypeEntry").jqGrid( 'setGridWidth', $(".page-content").width()-20);
    })
    //字典类型
	  mainGrid = $(grid_selector).jqGrid({
	        url:"dict/loadDictType.do",
	        datatype:"json", //数据来源，本地数据
	        mtype:"POST",//提交方式
	        height:'auto',//高度，表格高度。可为数值、百分比或'auto'
	        autowidth:true,//自动宽
	        colNames:['编码', '名称', '备注'],
	        colModel:[
	            {name:'dictType',width:'30%',index:'dictType',align:'left'},
	            {name:'dictDesc',width:'35%',align:'left',sortable:false},
	            {name:'remark',width:'30%',align:"left",sortable:false}
	        ],
	        rowNum : 10,
	        rowList : [ 5,10, 20, 30 ],
	        pager : pager_selector,
	        sortname : 'id',
	        mtype : "post",
	        viewrecords : true,
	        sortorder : "desc",
	           onSelectRow : function(rowid) {
	           	var row = mainGrid.getRowData(rowid);
	           	detailGrid.setGridParam({
	           		 postData:{"condition":{"dictType":row.dictType}}
	           	});
	           	detailGrid.trigger("reloadGrid");
	           }
	    })
    	//字典明细
	   detailGrid =  $("#dictTypeEntry").jqGrid({
	        url:"dict/loadDictEntry.do",
	        datatype:"json", //数据来源，本地数据
	        mtype:"POST",//提交方式
	        height:'auto',//高度，表格高度。可为数值、百分比或'auto'
	        autowidth:true,//自动宽
	        colNames:['类型', '编码', '名称','序号','备注'],
	        colModel:[
	            {name:'dictType',width:'20%',index:'dictType',align:'left'},
	            {name:'dictCode',width:'20%',index:'dictCode',align:'left'},
	            {name:'dictName',width:'25%',align:"left",sortable:false},
	            {name:'dictOrder',width:'10%', index:'dictOrder',align:"left"},
	            {name:'remark',width:'10%',align:"left",sortable:false}
	        ],
	        rowNum : 5,
	        rowList : [ 5,10, 20, 30 ],
	        pager : "#dictTypeEntry_pager",
	        sortname : 'id',
	        mtype : "post",
	        viewrecords : true,
	        sortorder : "desc"
	    })
	    //触发列表自动调整宽度
	    $(window).triggerHandler('resize.jqGrid');
});

/**
 * 字典类型查询
 */
function query(){
	var form = $("#queryForm");
	var dictType = $("#queryDictType",form).val();
	var dictDesc = $("#queryDictDesc",form).val();
	var params = {};
	if(!StringUtils.isBlank(dictType)){
		params.dictType = dictType;
	}if(!StringUtils.isBlank(dictDesc)){
		params.dictDesc = dictDesc;
	}
	//必须设置，否则会将上次的查询条件添加到本次(本次没有的变量)
	$("#dictTypeTable").jqGrid("getGridParam","postData").condition=null;
	$("#dictTypeTable").jqGrid("setGridParam",{
		 postData:{"condition":params}
		}
	).trigger("reloadGrid");
}
/**
 * 字典类型查询重置
 */
function reset(){
	var form = $("#queryForm");
	$("#queryDictType",form).val(null);
	$("#queryDictDesc",form).val(null);
	query();
}

/**
 * 字典类型新增
 */
function dictTypeAdd(){
	Dialog.open({
		 url: "dict/forward.do",
		 data:"path=system/dict/dictTypeAdd",
		 showDiv:"#optDiv",
		 modal:"#dictTypeAddModal"
	});
}
</script>