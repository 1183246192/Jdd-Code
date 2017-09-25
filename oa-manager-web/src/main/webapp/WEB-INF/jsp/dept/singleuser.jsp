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
		field : 'createdate',
		title : '入职时间',
		width : 120
	}] ];

	//定义 datagird工具
	var toolbar_v = [ {
		id : 'btnedit',
		text : ' 编辑',
		iconCls : 'icon-edit',
		handler: function(){
			var ids = $('#sysuserlist').datagrid('getSelections');
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
			createmodalwindow("添加用户信息", 800, 290, '${baseurl}user/editsysuser?id='+data.id);
		}
	}];

	//加载datagrid

	$(function() {
		$('#sysuserlist').datagrid({
			title : '个人中心',//数据列表标题
			nowrap : true,//单元格中的数据不换行，如果为true表示不换行，不换行情况下数据加载性能高，如果为false就是换行，换行数据加载性能不高
			striped : true,//条纹显示效果
			singleSelect : true,
			url : '${baseurl}user/query_singleuser',//加载数据的连接，引连接请求过来是json数据
			idField : 'id',//此字段很重要，数据结果集的唯一约束(重要)，如果写错影响 获取当前选中行的方法执行
			loadMsg : '',
			columns : columns_v,
//			pagination : true,//是否显示分页
//			rownumbers : true,//是否显示行号
//			pageList:[15,30,50],
			toolbar : toolbar_v
		});
	});
	
</script>

</head>
<body>
	
	<!-- 查询列表 -->
	<TABLE border=0 cellSpacing=0 cellPadding=0 width="99%" align=center style="padding-top: 10px;">
		<TBODY>
			<TR>
				<TD>
					<table id="sysuserlist"></table>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</body>
</html>