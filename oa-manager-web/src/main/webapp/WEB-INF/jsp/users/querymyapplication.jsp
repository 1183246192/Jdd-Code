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
<title>请假申请</title>

<script type="text/javascript">
	//datagrid列定义
	/* id;userid;status;applytime;type;reason;days;did;deptstatus;dopinion;lid;lopinion;ldstatus;*/
	var columns_v = [ [ {
		field : 'ck',
		checkbox : true 
	},{
		field : 'id',//对应json中的key
		title : 'id',
		hidden : true
//		width : 20
	},{
		field : 'deptName',//deptName
		title : '部门名称',
		width : 100,
	}, {
		field : 'name',
		title : '姓名',
		width : 100
	}, {//1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他
		field : 'type',
		title : '请假类别',
		width : 150,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "年假";
			}else if(value =='2'){
				return "公假（产假、婚假、丧假）";
			}else if(value =='3'){
				return "事假";
			}else if(value =='4'){
				return "病假";
			}else if(value =='5'){
				return "其他";
			}
		}
	}, {
		field : 'reason',
		title : '请假事由说明',
		width : 200
	} , {
		field : 'apptime',
		title : '申请时间',
		width : 100
	}, {
		field : 'days',
		title : '申请天数',
		width : 70
	},{// 1:审核中 2:审批不通过 3:审批通过
		field : 'status',
		title : '审批状态',
		width : 150,
		formatter : function(value, row, index) {//通过此方法格式化显示内容,value表示从json中取出该单元格的值，row表示这一行的数据，是一个对象,index:行的序号
			if(value =='1'){
				return "待审批";
			}else if(value =='2'){
				return "审批中";
			}else if(value =='3'){
				return "审批不通过";
			}else if(value =='4'){
				return "审批通过";
			}else if(value =='5'){
				return "已撤销";
			}
		}
	}, {
		field : 'schedule',
		title : '审批进度',
		width : 150,
	}, {
		field : 'opinion',
		title : '审批意见',
		width : 200,
	}] ];

	//定义 datagird工具
	var toolbar_v = [{//工具栏
		id : 'btnadd',
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			//打开一个窗口，用户添加页面
			//参数：窗口的title、宽、高、url地址
			createmodalwindow("添加休假申请", 800, 350, '${baseurl}users/addapplication');
		}
	},{
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#applicationlist').datagrid('getSelections');
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
			createmodalwindow("编辑休假申请", 800, 320, '${baseurl}users/editapplication?id='+data.id);
		}
	},{
		id : 'btndel',
		text : '撤销',
		iconCls : 'icon-remove',
		handler: function(){
			var ids = $('#applicationlist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能撤销!','info');
        		return ;
        	}
        	/* if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	} */
//       	console.info(ids);
        	var len = ids.length;
//			data = ids[0];
			$.messager.confirm('确认','确定撤销这'+len+'条数据吗？',function(r){
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
            	$.post("/users/delapplication",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','撤销内容成功!','info',function(){
        					$("#applicationlist").datagrid("reload");
//							window.location.reload(true);
        				});
        			}else if(data.status == 500){
        				$.messager.alert('提示',''+data.msg,'info');
        			}
        		});
    	    }
    	});
		}
	}];

	//加载datagrid

	$(function() {
		$('#applicationlist').datagrid({
			title : '我的申请',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
//			singleSelect : true,
			url : '${baseurl}users/queryapplication_result',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
			pagination : true,//是否显示分页
			rownumbers : true,//是否显示行号
			pageList:[20,30,50],
			toolbar : toolbar_v
		});
		
		$('#spStatus').combobox({
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    valueField:'id',   
		    textField:'text',
		    data:[{    
			    "id":1,    
			    "text":"待审批"   
			},{    
			    "id":2,    
			    "text":"审批中"   
			},{    
			    "id":3,    
			    "text":"审批不通过"
			},{    
			    "id":4,    
			    "text":"审批通过"   
			}]  
		    
	   });
	});
	
	//查询方法
	function queryvacation(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#applicationqueryForm").serializeJson();
		$('#applicationlist').datagrid('load',formdata);
	}
	
	//清空查询条件
	function clearSearchConditionForm(){
		$('#applicationqueryForm').form('clear');
		queryvacation();
	}
	
</script>

</head>
<body>

  <!-- html的静态布局 -->
  <form id="applicationqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_sear">
		<TBODY>
			<TR> 
				<TD class="left combo_sel" style="width: 240px;">审批状态：<!-- <INPUT type="text" name="deptName" /> -->
				<input class="easyui-combobox" name="spStatus" id="spStatus" style="height: 25px">
				</TD>
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
					<table id="applicationlist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</body>
</html>