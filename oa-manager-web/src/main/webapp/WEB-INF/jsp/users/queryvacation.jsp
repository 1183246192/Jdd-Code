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
<title>年假管理</title>

<script type="text/javascript">
	//datagrid列定义
	/*id;userid;have;used;remain;starttime;stoptime;previousremain;previousstoptime;total*/
	var columns_v = [ [ {
		field : 'ck',
		checkbox : true 
	},{
		field : 'id',//对应json中的key
		title : 'id',
		hidden : true
//		width : 20
	}, {
		field : 'year',//对应json中的key
		title : '年份',
		width : 80
	},{
		field : 'deptName',//deptName
		title : '部门名称',
		width : 80,
	},{
		field : 'name',
		title : '姓名',
		width : 80,
	}, {
		field : 'have',
		title : '今年总天数(天)',
		width : 100
	}, {
		field : 'used',
		title : '今年已用(天)',
		width : 100
	} , {
		field : 'remain',
		title : '今年剩余(天)',
		width : 100
	}, {
		field : 'statime',
		title : '开始时间',
		width : 120
	}, {
		field : 'stotime',
		title : '结束时间',
		width : 120
	}, {
		field : 'previousremain',
		title : '上年结余(天)',
		width : 100
	}, {
		field : 'pretime',
		title : '结余截止时间',
		width : 120
	}, {
		field : 'total',
		title : '总天数(天)',
		width : 100
	}] ];

	//定义 datagird工具
	var toolbar_v = [{//工具栏
		id : 'btnadd',
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			//打开一个窗口，用户添加页面
			//参数：窗口的title、宽、高、url地址
			createmodalwindow("添加年假信息", 800, 290, '${baseurl}users/addvacation');
		}
	},{
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#vacationlist').datagrid('getSelections');
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!','info');
        		return ;
        	}
//			alert(ids.indexOf(','));
        	if(ids.length > 1){
        		$.messager.alert('提示','只能选择一个用户!','info');
        		return ;
        	}
 //       	console.info(ids);
			data = ids[0];
			createmodalwindow("编辑用户年假信息", 800, 320, '${baseurl}users/editvacation?id='+data.id);
		}
	},{
		id : 'btndel',
		text : ' 删除',
		iconCls : 'icon-remove',
		handler: function(){
			var ids = $('#vacationlist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能删除!','info');
        		return ;
        	}
        	/* if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	} */
//       	console.info(ids);
        	var len = ids.length;
//			data = ids[0];
			$.messager.confirm('确认','确定删除这'+len+'条数据吗？',function(r){
    	    if (r){
		    	var s='';
		      	for(var j=0;j<ids.length;j++){
		            var sal=ids[j];
	                if (s == '') {
	                	s += sal.id;
	                }else{
	                	s += ','+sal.id;
	                }
		        }
    	    	var params = {"id":s};
            	$.post("/users/delvacation",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#vacationlist").datagrid("reload");
//							window.location.reload(true);
        				});
        			}
        		});
    	    }
    	});
		}
	}];

	//加载datagrid

	$(function() {
		$('#vacationlist').datagrid({
			title : '年假查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
//			singleSelect : true,
			url : '${baseurl}users/queryvacation_result',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[20,30,50],
			toolbar : toolbar_v
		});
		
		$('#deptName').combobox({ 
		    url:'/users/getDeptName', 
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    valueField:'id',   
		    textField:'name'
	   });
	});
	
	//查询方法
	function queryvacation(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#vacationqueryForm").serializeJson();
		$('#vacationlist').datagrid('load',formdata);
	}
	
	//清空查询条件
	function clearSearchConditionForm(){
		$('#vacationqueryForm').form('clear');
		queryvacation();
	}
	
</script>

</head>
<body>

  <!-- html的静态布局 -->
  <form id="vacationqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_sear">
		<TBODY>
			<TR> 
				<TD class="left">姓名：<INPUT class="table_sinpt" type="text" id="name" name="name" /></TD>
				<TD class="left combo_sel" >部门：<!-- <INPUT type="text" name="deptName" /> -->
				<input class="easyui-combobox" name="deptName" id="deptName" style="height: 25px">
				</TD>
				<TD class="left">年份：<INPUT class="table_sinpt" type="text" id="year" name="year" /></TD>
				<td class="search_l"><a id="btn" href="#" onclick="queryvacation()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a>
					<a href="javascript:void(0)" onclick="clearSearchConditionForm();"
						class="easyui-linkbutton" iconCls="icon-cancel">清空</a>
				</td>
				<td></td>
			</TR>


		</TBODY>
	</TABLE>
	</form>
	
	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center>
		<TBODY>
			<TR>
				<TD>
					<table id="vacationlist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</body>
</html>