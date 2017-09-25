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
  function sysusersave(){
	  if(document.userform.username.value == "" ){
		var obj = document.getElementById("username");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('username').focus();
	    return;
	  }
	  document.getElementById("username").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.userform.password.value =="" ){
 		  var obj = document.getElementById("password");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('password').focus();
	      return;
	  }
	  document.getElementById("password").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.userform.did.value==""){
		  var obj = document.getElementById("did");
  		  obj.style.cssText = "border: 1px solid #f00;"
// 		  document.getElementById('did').focus();
	      return;
	  }  
	  document.getElementById("did").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.userform.email.value==""){
		  var obj = document.getElementById("email");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('email').focus();
	      return;
	  }  
	  document.getElementById("email").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.userform.phone.value==""){
		  var obj = document.getElementById("phone");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('phone').focus();
	      return;
	  }  
	  document.getElementById("phone").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.userform.telephone.value==""){
		  var obj = document.getElementById("telephone");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('telephone').focus();
	      return;
	  }  
	  document.getElementById("telephone").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  
	  if(document.userform.address.value==""){
		  var obj = document.getElementById("address");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('address').focus();
	      return;
	  }  
	  document.getElementById("address").style.cssText = "border: 1px solid #d4d4d4;" 
	  
//	  $("body").mask("提交中...");
//	  document.getElementById("userform").submit();
//	  jquerySubByFId('userform',sysusersave_callback,null,"json");
	  $.post("/user/insertuser",$("#userform").serialize(), function(data){
			if(data.status == 200){
//		  		alert("新增用户成功!");
				$.messager.alert('提示信息',''+data.msg,'info',function () {
	            	document.getElementById('closebtn').click();
		        });
//				$('#userform').window('close');//closebtn
//				document.getElementById('closebtn').click();
				//$('#userform').form('reset');
			}
			if(data.resultInfo.status == 500){
				$.messager.alert('提示信息',''+data.resultInfo.msg,'error');
			}
			
			/* var data_v = data.resultInfo;
			//提交结果类型
			var type=data_v.type;
			//结果提示信息
			var message=data_v.message;
			//alert(message);
			//如果type等于0表示失败
			if(type==0){
				$.messager.alert('提示信息',message,'error',function () {
	            //	window.parent.location.reload(true);
		        });
			}else if(type==1){
				$.messager.alert('提示信息',message,'success',function () {
		            //console.info(d);
		            window.parent.location.reload(true);
		        });
			} */
		});

  }
   
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="userform" name="userform"  method="post"> <%-- action="${baseurl}user/insertuser" --%>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
   			<!-- <TR class="table_ubg"> -->
   			<TR>
			<td class="table_title">用户基本信息</td>
			</TR>
			
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 align=center >
						<TBODY>
							<!-- id; did; username; password; sex; phone; telephone; email; address; -->
							<TR>
								<TD height="30px" width="100px" align=right >姓名：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="text" id="username" name="username"  /></TD>
								<!-- sysuser_useridTip用于显示提示信息，提示div的id等于校验input的id+Tip -->
								<!-- <div id="sysuser_useridTip"></div> -->
								<TD height="30px" width="150px" align=right >手机号：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="text" id="phone" name="phone"  /></TD>
								<!-- <div id="sysuser_usernameTip"></div> -->
							</TR>
							<TR>
								<TD height="30px" width="100px" align=right >密码：</td>
								<td style="padding-left: 5px">
								<input type="password" id="password" name="password" /></TD>
								<!-- <div id="sysuser_passwordTip"></div> -->
								<TD height="30px" width="150px" align=right >座机：</td><td style="padding-left: 5px">
								<input type="text" id="telephone" name="telephone" /></TD>
								<!-- <div id="sysuser_groupidTip"></div> -->
								
							</TR>
							<TR>
								<TD height="30px" width="100px" align=right >部门：</td><td style="padding-left: 5px">
								<select  name="did" id="did">
									<option value="">请选择</option>
									<c:forEach var="dept" items="${list}" >
										<option value="${dept.id}">${dept.name}</option>
										  <!-- 当前对象 -->
									</c:forEach>
								</select>
								</TD>
								<!-- <div id="sysuser_passwordTip"></div> -->
								<TD height="30px" width="150px" align=right >性别：</td><td style="padding-left: 5px">
								<input type="radio" name="sex" value="1" checked="checked"/>男
								<input type="radio" name="sex" value="2" />女</TD>
								<!-- <div id="sysuser_groupidTip"></div> -->
								
							</TR>
							<TR>
							    <TD height="30px" width="100px" align=right >邮箱：</td><td style="padding-left: 5px">
								<input type="text" id="email" name="email" /></TD>
								<TD height="30px" width="100px" align=right >入职时间：</td><td style="padding-left: 5px">
								<input type="text" id="hiredate" name="hiredate" class="easyui-datebox" required="required"/></TD>
							</TR>
							<TR>
							    <TD height="30px" width="150px" align=right>地址：</td><td style="padding-left: 5px">
								<input type="text" id="address" name="address" /></TD>
							</TR>
							<tr>
							  <td colspan=4 align=center class="table_sub">
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="sysusersave()">提交</a>
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