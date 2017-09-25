<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引用jquery easy ui的js库及css -->
<LINK rel="stylesheet" type="text/css"
	href="${baseurl}js/easyui/styles/default.css">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>部门管理</title>

<script type="text/javascript">
	//datagrid列定义
	/*id; did; username; password; sex; phone; telephone; email; address; */
	var columns_v = [ [ {
		field : 'ck',
		checkbox : true 
	},{
		field : 'id',//对应json中的key
		title : 'id',
		hidden : true
//		width : 20
	},{
		field : 'name',//对应json中的key
		title : '部门名称',
		width : 100,
	}, {
		field : 'description',//对应json中的key
		title : '部门描述',
		width : 140
	}, {
		field : 'leader',//对应json中的key
		title : '部门领导',
		width : 140,
	}, {
		field : 'createdate',
		title : '部门创建时间',
		width : 120
	}] ];

	//定义 datagird工具
	var toolbar_v = [ {//工具栏
		id : 'btnadd',
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			//打开一个窗口，用户添加页面
			//参数：窗口的title、宽、高、url地址
			createmodalwindow("添加部门信息", 800, 290, '${baseurl}dept/adddept');
		}
	},{
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#sysdeptlist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	}
//        	console.info(ids);
			data = ids[0];
			createmodalwindow("编辑部门信息", 800, 290, '${baseurl}dept/editdept?id='+data.id);
		}
	},{
		id : 'btnedit2',
		text : '更改部门领导',
		iconCls : 'icon-edit',
		handler : function() {
			var ids = $('#sysdeptlist').datagrid('getSelections');
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个部门才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') < 0){
        		$.messager.alert('提示','只能选择一个部门!');
        		return ;
        	}
			data = ids[0];
			createmodalwindow("更改部门领导", 800, 290, '${baseurl}dept/editleader?id='+data.id);
		}
	}];

	//加载datagrid

	$(function() {
		$('#sysdeptlist').datagrid({
			title : '部门查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			singleSelect : true,
			url : '${baseurl}dept/querydept_result',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[20,30,50],
			toolbar : toolbar_v
		});
	});
	
	//查询方法
	function queryuser(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#sysudeptqueryForm").serializeJson();
		$('#sysdeptlist').datagrid('load',formdata);
	}
	
	//清空查询条件
	function clearSearchConditionForm(){
		$('#sysudeptqueryForm').form('clear');
		queryuser();
	}
</script>

</head>
<body>

  <!-- html的静态布局 -->
  <form id="sysudeptqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_search">
		<TBODY>
			<TR> <!-- did; username; password; sex; phone; telephone; email; address; -->
				<TD class="nav_search">部门名称：<INPUT type="text" name="name" /></TD>
				<td class="search_l"><a id="btn" href="#" onclick="queryuser()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a>
				</td>
				
			</TR>

		</TBODY>
	</TABLE>
	</form>
	
	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="sysdeptlist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</body>
</html>