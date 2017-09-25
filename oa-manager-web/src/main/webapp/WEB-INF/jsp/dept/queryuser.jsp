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
<title>用户管理</title>

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
		field : 'deptName',//对应json中的key
		title : '部门',
		width : 100,
		/* formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "技术部";
			}else if(value =='2'){
				return "财务部";
			}else if(value =='3'){
				return "客服部";
			}else if(value =='4'){
				return "综合部";
			}else if(value =='5'){
				return "秘书部";
			}
		} */
	}, {
		field : 'username',//对应json中的key
		title : '姓名 ',
		width : 80
	}, {
		field : 'sex',//对应json中的key
		title : '性别',
		width : 60,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "男";
			}else if(value =='2'){
				return "女";
			}
		}

	}, {
		field : 'phone',
		title : '手机号',
		width : 120
	}, {
		field : 'telephone',
		title : '座机',
		width : 120
	}, {
		field : 'email',
		title : '邮箱',
		width : 180
	} , {
		field : 'address',
		title : '地址',
		width : 280
	}, {
		field : 'status',//对应json中的key
		title : '状态',
		width : 60,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "正常";
			}else if(value =='2'){
				return "已失效";
			}else if(value =='3'){
				return "已删除";
			}
		}

	}, {
		field : 'hiredate',
		title : '入职时间',
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
			createmodalwindow("添加用户信息", 800, 290, '${baseurl}user/addsysuser');
		}
	},{
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#sysuserlist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!','info');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!','info');
        		return ;
        	}
//        	console.info(ids);
			data = ids[0];
			createmodalwindow("添加用户信息", 800, 290, '${baseurl}user/editsysuser?id='+data.id);
		}
	},{
		id : 'btndel',
		text : ' 删除',
		iconCls : 'icon-remove',
		handler: function(){
			var ids = $('#sysuserlist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能删除!','info');
        		return ;
        	}
        	if(ids.indexOf(',') < 0){
        		$.messager.alert('提示','只能选择一个用户!','info');
        		return ;
        	}
//        	console.info(ids);
			data = ids[0];
			$.messager.confirm('确认','确定删除 '+data.username+'吗？',function(r){
    	    if (r){
    	    	var params = {"id":data.id};
            	$.post("/user/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#sysuserlist").datagrid("reload");
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
		$('#sysuserlist').datagrid({
			title : '用户查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			singleSelect : true,
			url : '${baseurl}user/queryuser_result',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[20,30,50],
			toolbar : toolbar_v,
			onClickRow:function(rowIndex, rowData) {			
				loadTree(rowData);
			} 
		});
	});
	
	//查询方法
	function queryuser(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#sysuserqueryForm").serializeJson();
		$('#sysuserlist').datagrid('load',formdata);
	}
	
	//清空查询条件
	function clearSearchConditionForm(){
		$('#sysuserqueryForm').form('clear');
		queryuser();
	}
	
	function loadTree(rowData) {
//		var _ele = $(this);
		var userid =rowData.id;
		$("#leftUserPermission").val(rowData.username);
//		$('#UserPerssionTree').tree('reload');
		
    	$("#UserPerssionTree").tree({ 
		    url:'${baseurl}user/getTreeByUserId?userid='+userid,
    		method : "GET",
    		animate:true,
    		checkbox:true,
    		cascadeCheck:true,
    		/* onBeforeExpand:function(node){ 
	        	$("#UserPerssionTree").tree('options').url='${baseurl}user/getTreeByUserId?mid='+node.id;  
	        }, */
		    /* onClick : function(node) {
//		        $('#UserPerssionTree').tree('options').url='${baseurl}user/getTreeByUserId?mid='+node.id;
		        $.ajax({
					type: 'GET',
					url : '${baseurl}user/getTreeByUserId?userid='+userid,
			    	success: function(data) {
		    			$('#UserPerssionTree').tree('append', {
							parent: node.id,
							data: data,
						});
			    	}
				});  
		    }, */
		    onCheck : function(node){
//		    	console.info(node);
		    	var nodes = $('#UserPerssionTree').tree('getChecked');
				var s = '';
				for(var i=0; i<nodes.length; i++){
					if (s != '') s += ',';
					s += nodes[i].id;
				}
//				console.info(s);
		    	$.ajax({
					type: 'GET',
					url : '${baseurl}user/updateTreeById?userid='+userid+'&id='+s,
			    	success: function(data) {
			    		if(data.status == 200){
			    			$.messager.alert('提示','修改用户角色成功！','info');
			    		}
			    	}
				});  
		    },
		    onLoadSuccess:function(node,data){
				var t = $(this);
				if(data){
					$(data).each(function(index,d){
						if(this.state == 'closed'){
							t.tree('expandAll');
						}
					});
				}
			} 
		}); 
	}

	
</script>

</head>
<body class="easyui-layout">   
	
  <div data-options="region:'north',split:true" border="false" style="height:auto;overflow-y: hidden">
  <!-- html的静态布局 -->
  <form id="sysuserqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_search">
		<TBODY>
			<TR> <!-- did; username; password; sex; phone; telephone; email; address; -->
				<TD class="left">姓名：<INPUT type="text" name="username" /></TD>
				<TD class="left">手机号：<INPUT type="text" name="phone" /></TD>

				<TD class="left">座机号：<INPUT type="text" name="telephone" /></TD>
				<TD class="left">邮箱：<INPUT type="text" name="email" /></TD>
				<td class="search_l"><a id="btn" href="#" onclick="queryuser()"
					class="easyui-linkbutton" iconCls='icon-search'>查询</a>
				</td>
				<td></td>
			</TR>
		</TBODY>
	</TABLE>
	</form>
  </div>
	
	<div data-options="region:'center'" border="false" class="easyui-panel" style="padding:0px 5px 0px 5px;">
        <div class="easyui-layout" data-options="fit:true">
        	<!-- 查询列表 -->
			<div data-options="region:'west',split:true" style="width:79%;" >
				<table border=0 cellSpacing=0 cellPadding=0 id="sysuserlist"></table>
			</div>
			<div data-options="region:'center',split:true" style="width:20%" title="用户权限 " >    		       		 		       		
		      	<div class="easyui-layout" data-options="fit:true" border="false">			            	
		      	<div data-options="region:'north'" style="padding: 10px 0 5px 0" border="false">
		        	<span href="javascript:void(0)" class="easyui-linkbutton" disabled="true" plain="true" iconCls="icon-edit">此职员所拥有的角色:</span>	
		       		<input type="text" disabled="disabled"  id="leftUserPermission" style="width:80px; height:22px;" /> 
		       		<!-- <input type="hidden" id="mid" name="mid" />  -->    		           
		   		</div>
				<div data-options="region:'center'"  class="easyui-panel" border="false" style="width:400px;">
					<ul id="UserPerssionTree"  class="easyui-tree" style="margin-left: 20px;"></ul>
				</div>
				</div>					
			</div>
        </div>
    </div>
    
</body>
</html>