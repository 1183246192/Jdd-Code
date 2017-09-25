<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>编辑申请</title>
<script type="text/javascript">
	
  function approvaleditsave(){
	  
	  $.post("/users/updateapproval",$("#editapprovalform").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示',''+data.msg,'info');
				document.getElementById('closebtn').click();
				parent.location.reload();
			}
			if(data.resultInfo.status == 500){
				$.messager.alert('提示',data.resultInfo.msg);
		  		
			}
		});

  }
  
  $(function() {//value="${applicationQueryVo.type}"
  	
  	$.ajax({
  		url:"/users/validateappro?id="+${applicationQueryVo.id},
  		success:function(data){
  			if(data.status == 500){
				$.messager.alert('提示',''+data.msg,'info',function(){
   					document.getElementById('closebtn').click();
					window.parent.close();
   				});
			}
  		}
  	});
  	
  	var a = ${applicationQueryVo.type}
  	if(a != '' || a != null){
  		if(a == 1){////1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他
  			var t = "年假"
  		}else if(a == 2){
  			var t = "公假"
  		}else if(a == 3){
  			var t = "事假"
  		}else if(a == 4){
  			var t = "病假"
  		}else if(a == 5){
  			var t = "其他"
  		}
	$('#type').combobox('setValue',t);
  	}
  	
  	$('#sp_result').combobox({
	    editable:false, //不可编辑状态
	    cache: false,
	    panelHeight: 'auto',//自动高度适合
	    valueField:'id',   
	    textField:'text',
	    data:[{    
		    "id":2,    
		    "text":"审批通过"   
		},{    
		    "id":3,    
		    "text":"审批不通过"   
		}],
		required:true
   });
  	
  });
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="editapprovalform" name="editapprovalform"  method="post"> 
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
  	  <TR>
		<td class="table_title">申请信息</td>
		</TR>
		
		<TR>
			<TD>
				<TABLE cellSpacing=0 cellPadding=0 align=center >
					<TBODY>
		 			<TR>
						<TD height="30px" width="130px" align=right >姓名：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input class="easyui-textbox" disabled="disabled" id="name" name="name" style="height: 25px" value="${applicationQueryVo.name}" />
						</TD>
						<TD height="30px" width="150px" align=right >部门：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input class="easyui-textbox" disabled="disabled" id="deptName" name="deptName" style="height: 25px" value="${applicationQueryVo.deptName}" /></TD>
						
					</TR>
					<TR><!-- type 1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他 -->
						<TD height="30px" width="130px" align=right >请假类别：</td>
						<td style="padding-left: 5px">
						<input id="type" name="type" class="easyui-combobox" disabled="disabled" style="height: 25px" />
						</TD>
						
						<TD height="30px" width="150px" align=right >请假事由说明：</td>
						<td style="padding-left: 5px">
						<input class="easyui-textbox" id="reason" name="reason" title="${applicationQueryVo.reason}" value="${applicationQueryVo.reason}" disabled="disabled" style="height: 25px"/></TD>
						
					</TR>
					<TR>
						<TD height="30px" width="130px" align=right >申请时间：</td>
						<td style="padding-left: 5px">
						<input id="apptime" name="apptime" class="easyui-datebox" value="${applicationQueryVo.apptime}" disabled="disabled" style="height: 25px"/></TD>
						
						<TD height="30px" width="150px" align=right >申请天数：</td><td style="padding-left: 5px">
						<input id="days" name="days" class="easyui-textbox" value="${applicationQueryVo.days}" disabled="disabled" style="height: 25px"/>
						</TD>
					</TR>
					<tr height="20px"></tr>
					<tr>
						<TD height="30px" width="130px" align=right >审批结果：</td>
						<td style="padding-left: 5px">
						<input type="hidden" id="id" name="id" value="${applicationQueryVo.id}" />
						<input id="sp_result" name="sp_result" class="easyui-combobox" style="height: 25px"/></TD>
						
						<TD height="30px" width="150px" align=right >审批意见：</td><td style="padding-left: 5px">
						<input id="sp_opinion" name="sp_opinion" class="easyui-textbox" style="height: 25px"/>
						</TD>
					</tr>
					<tr>
					  <td colspan=4 align=center class="table_sub">
						<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="approvaleditsave()">提交</a>
						<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick="parent.closemodalwindow()">关闭</a>
					  </td>
					</tr>
				
					</TBODY>
				</TABLE>
			</TD>
		</TR>
   </TBODY>
</TABLE>
</form>
</body>
</html>