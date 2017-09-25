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
<title>工资管理</title>

<script type="text/javascript">
	//datagrid列定义
	/*id;userid;month;basicsalary;fsalary;checkingdays;trafficallowance;
	otherallowance;endowmentinsurance;medicalinsurance;unemploymentinsurance;
	employmentinjuryinsurance;maternityinsurance;housingfund;othersdeduct;totaldeduct; */
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
		width : 80,
	},{
		field : 'name',//对应json中的key
		title : '姓名',
		width : 80,
	}, {
		field : 'month',//对应json中的key
		title : '月份',
		width : 80
	}, {
		field : 'basicsalary',//对应json中的key
		title : '基本工资',
		width : 100
	}, {
		field : 'checkingdays',
		title : '出勤天数',
		width : 80
	} , {
		field : 'trafficallowance',
		title : '交通补',
		width : 70
	}, {
		field : 'otherallowance',//对应json中的key
		title : '其他津贴',
		width : 70
	}, {
		field : 'totalallowance',
		title : '津贴总金额',
		width : 80
	}, {
		field : 'endowmentinsurance',
		title : '养老保险',
		width : 70
	}, {
		field : 'medicalinsurance',
		title : '医疗保险',
		width : 70
	}, {
		field : 'unemploymentinsurance',
		title : '失业保险',
		width : 70
	}, {
		field : 'employmentinjuryinsurance',
		title : '工伤保险',
		width : 70
	}, {
		field : 'maternityinsurance',
		title : '生育保险',
		width : 70
	}, {
		field : 'housingfund',
		title : '住房公积金',
		width : 80
	}, {
		field : 'totaldeduct',
		title : '其他应扣',
		width : 80
	}, {
		field : 'othersdeduct',
		title : '总扣费金额',
		width : 80
	}, {
		field : 'fsalary',
		title : '实发工资',
		width : 100
	}] ];

	//定义 datagird工具
	var toolbar_v = [ {//工具栏
		id : 'btnout',
		text : '批量导出',
		iconCls : 'icon-undo',
		handler : function() {
			var params = $("#salaryqueryForm").serializeJson();
			$.post("/users/exportsalary", params, function(data){
				if(data.status == 200){
//        			return data.msg;
        			$.messager.alert('提示','成功导出记录'+data.data.size+'条！<a href='+data.data.webpath+'>点此下载</a>','success');
        		}
			});
		}
	},{
		id : 'btnin',
		text : '批量导入',
		iconCls : 'icon-redo',
		handler : function() {
			//打开一个窗口，用户添加页面
			//参数：窗口的title、宽、高、url地址
			createmodalwindow("批量导入工资信息", 800, 300, '${baseurl}users/importsalary');
		}
	},{
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#salarylist').datagrid('getSelections');
//			alert("OK");
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!','info');
        		return ;
        	}
        	if(ids.indexOf(',') < 0){
        		$.messager.alert('提示','只能选择一个用户!','info');
        		return ;
        	}
//        	console.info(ids);
			data = ids[0];
			createmodalwindow("编辑用户工资信息", 800, 370, '${baseurl}users/editsalary?id='+data.id);
		}
	},{
		id : 'btndel',
		text : ' 删除',
		iconCls : 'icon-remove',
		handler: function(){
			var ids = $('#salarylist').datagrid('getSelections');
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
            	$.post("/users/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#salarylist").datagrid("reload");
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
		$('#salarylist').datagrid({
			title : '用户查询',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
//			singleSelect : true,
			url : '${baseurl}users/querysalary_result',//加载数据的连接，引连接请求过来是json数据
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
	   
		$('#month').combobox({ 
		    valueField:'id',
		    textField:'text',
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    data:data
	   });
	});
	
	//查询方法
	function querysalary(){
		//datagrid的方法load方法要求传入json数据，最终将 json转成key/value数据传入action
		//将form表单数据提取出来，组成一个json
		var formdata = $("#salaryqueryForm").serializeJson();
		$('#salarylist').datagrid('load',formdata);
	}
	
	//清空查询条件
	function clearSearchConditionForm(){
		$('#salaryqueryForm').form('clear');
		querysalary();
	}
	
	var data = [{   "id":"01",
				    "text":"一月"
				},{ "id":"02",
				    "text":"二月"
				},{ "id":"03",
				    "text":"三月"
				},{ "id":"04",
				    "text":"四月"
				},{ "id":"05",
				    "text":"五月"
				},{ "id":"06",
				    "text":"六月"
				},{ "id":"07",
				    "text":"七月"
				},{ "id":"08",
				    "text":"八月"
				},{ "id":"09",
				    "text":"九月"
				},{ "id":"10",
				    "text":"十月"
				},{ "id":"11",
				    "text":"十一月"
				},{ "id":"12",
				    "text":"十二月"
				}]
	
</script>

</head>
<body>

  <!-- html的静态布局 -->
  <form id="salaryqueryForm">
	<!-- 查询条件 -->
	<TABLE class="table_sear">
		<TBODY>
			<TR> 
				<TD class="left">姓名：<INPUT class="table_sinpt" type="text" name="name" /></TD>
				<TD class="left combo_sel" >部门：<!-- <INPUT type="text" name="deptName" /> -->
				<input class="easyui-combobox" name="deptName" id="deptName" style="height: 25px">
				</TD>
				<TD class="left">年份：<INPUT class="table_sinpt" type="text" name="year" /></TD>
				<TD class="left combo_sel">月份：
				<!-- <INPUT class="table_sinpt" type="text" name="month" /> -->
				<input class="easyui-combobox" name="month" id="month" style="height: 25px">
				<!-- <select id="month" class="easyui-combobox" name="month" >
				    <option value=""></option>
				    <option value="01">一月</option>
				    <option value="02">二月</option>
				    <option value="03">三月</option>
				    <option value="04">四月</option>
				    <option value="05">五月</option>
				    <option value="06">六月</option>
				    <option value="07">七月</option>
				    <option value="08">八月</option>
				    <option value="09">九月</option>
				    <option value="10">十月</option>
				    <option value="11">十一月</option>
				    <option value="12">十二月</option>
				</select> -->
				</TD>
				<td class="search_l"><a id="btn" href="#" onclick="querysalary()"
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
					<table id="salarylist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</body>
</html>