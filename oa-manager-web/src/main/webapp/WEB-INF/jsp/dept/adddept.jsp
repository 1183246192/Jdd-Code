<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>添加用户</title>
<script type="text/javascript">
  function deptsave(){
	  if(document.deptform.name.value == "" ){
		var obj = document.getElementById("name");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('name').focus();
	    return;
	  }
	  document.getElementById("name").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.deptform.description.value =="" ){
 		  var obj = document.getElementById("description");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('description').focus();
	      return;
	  }
	  document.getElementById("description").style.cssText = "border: 1px solid #d4d4d4;"
	  
	
//	  $("body").mask("提交中...");
//	  document.getElementById("userform").submit();
//	  jquerySubByFId('userform',sysusersave_callback,null,"json");
	  $.post("/dept/insertdept",$("#deptform").serialize(), function(data){
//	  		alert("OK");
			if(data.status == 200){
				$.messager.alert('提示信息','新增部门成功!','info',function () {
	            	document.getElementById('closebtn').click();
		        });
//				alert("新增部门成功!");
//				$('#userform').window('close');//closebtn
//				document.getElementById('closebtn').click();
				//$('#userform').form('reset');
//				$('#sysuserlist').datagrid('reload');   
//				window.opener.document.getElementById('sysuserqueryForm').click(); 
				window.parent.location.reload(true);
				
//				var url = window.location.protocol + '//' + window.location.host + '/' + 'dept/querydept_result';
//				parent.location.reload(url);
			}
		});

  }
   
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="deptform" name="deptform"  method="post"> <%-- action="${baseurl}user/insertuser" --%>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
   			<!-- <TR class="table_ubg"> -->
   			<TR>
			<td class="table_title">部门基本信息</td>
			</TR>
			
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 align=center >
						<TBODY>
							<TR>
								<TD height="30px" width="100px" align=right >部门名称：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="text" id="name" name="name"  /></TD>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<!-- <div id="sysuser_useridTip"></div> -->
								<%-- <TD height="30px" width="150px" align=right >部门领导：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<select name="leader" id="leader">
									<option value="">请选择</option>
									<c:forEach var="user" items="${list}" >
										<option value="${user.username}">${user.username}</option>
										  <!-- 当前对象 -->
									</c:forEach>
								</select>
								</TD> --%>
							</TR>
							<tr>
								<TD height="30px" width="150px" align=right >部门描述：</td>
								<td height="30px" width="300px" style="padding-left: 5px">
								<textarea  id="description" name="description" ></textarea></TD>
								<!-- <div id="sysuser_usernameTip"></div> -->
							</tr>
							<tr>
							  <td colspan=4 align=center class="table_sub">
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="deptsave()">提交</a>
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