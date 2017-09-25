<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>更改领导</title>
<script type="text/javascript">
  function editleader(){
	  if(document.leaderform.name.value == "" ){
		var obj = document.getElementById("name");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('name').focus();
	    return;
	  }
	  document.getElementById("name").style.cssText = "border: 1px solid #d4d4d4;"
	  

//	  alert("OK");
	  $.post("/dept/updateleader",$("#leaderform").serialize(), function(data){
			if(data.status == 200){
//				$.messager.alert('提示','修改用户成功!');
		  		$.messager.alert('提示信息','修改部门领导成功!','info',function () {
	            	document.getElementById('closebtn').click();
		        });
//				$('#userform').window('close');//closebtn
				//$('#userform').form('reset');
//				$('#sysuserlist').datagrid('reload');   
//				window.opener.document.getElementById('sysuserqueryForm').click(); 
//				var url = window.location.protocol + '//' + window.location.host + '/' + 'dept/querydept_result';
				parent.location.reload();
			}else if(data.status == 500){
				alert(data.msg);
				return;
			}
		});

  }
   
</script>

</head>
<body>


<form id="leaderform" name="leaderform"  method="post"> <%-- action="${baseurl}user/insertuser" --%>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
   			<!-- <TR class="table_ubg"> -->
   			<TR>
			<td class="table_title">部门信息</td>
			</TR>
			
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 align=center >
						<TBODY>
							<TR>
								<TD height="30px" width="100px" align=right >部门名称：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="hidden" id="id" name="id" value="${department.id}" />
								<input type="text" id="name" name="name" value="${department.name}" /></TD>
								
								<%-- <TD height="30px" width="150px" align=right >部门领导：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input disabled="true" name="leader" id="leader" value="${record}" />
								<select name="leader" id="leader" >
									<option value="">请选择</option>
									<c:forEach var="user" items="${list}" >
										<option value="${user.username}">${user.username}</option>
										<!-- 当前对象 -->
									</c:forEach>
								</select>
								</TD> --%>
								<!-- <div id="sysuser_usernameTip"></div> -->
							</TR>
							<tr height="20px"></tr>
							<tr>
								<TD height="30px" width="150px" align=right >部门领导：</td>
								<td height="30px" width="300px" style="padding-left: 5px">
								<c:forEach var="user" items="${list}" varStatus="status">
									<c:if test="${user.isleader=='1'}">
										<input type="checkbox" name="lid" checked="checked" value="${user.id}"/>&nbsp;${user.username}&nbsp;&nbsp;&nbsp;
									</c:if>
									<c:if test="${user.isleader=='0'}">
										<input type="checkbox" name="lid" value="${user.id}"/>&nbsp;${user.username}&nbsp;&nbsp;&nbsp;
									</c:if>
									<c:if test="${(status.index+1) %3 == 0}"><br></c:if>
								</c:forEach>
								
								</TD>
								<!-- <div id="sysuser_usernameTip"></div> -->
							</tr>
							
							<tr>
							  <td colspan=4 align=center class="table_sub">
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="editleader()">提交</a>
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