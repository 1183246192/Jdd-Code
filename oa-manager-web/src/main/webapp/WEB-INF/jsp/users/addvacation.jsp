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
  function vacationsave(){
	  if(document.addvacationform.username.value == "" ){
		var obj = document.getElementById("username");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('username').focus();
	    return;
	  }
	  document.getElementById("username").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.addvacationform.password.value =="" ){
 		  var obj = document.getElementById("password");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('password').focus();
	      return;
	  }
	  document.getElementById("password").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.addvacationform.did.value==""){
		  var obj = document.getElementById("did");
  		  obj.style.cssText = "border: 1px solid #f00;"
// 		  document.getElementById('did').focus();
	      return;
	  }  
	  document.getElementById("did").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.addvacationform.email.value==""){
		  var obj = document.getElementById("email");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('email').focus();
	      return;
	  }  
	  document.getElementById("email").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.addvacationform.phone.value==""){
		  var obj = document.getElementById("phone");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('phone').focus();
	      return;
	  }  
	  document.getElementById("phone").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.addvacationform.telephone.value==""){
		  var obj = document.getElementById("telephone");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('telephone').focus();
	      return;
	  }  
	  document.getElementById("telephone").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  
	  if(document.addvacationform.address.value==""){
		  var obj = document.getElementById("address");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('address').focus();
	      return;
	  }  
	  document.getElementById("address").style.cssText = "border: 1px solid #d4d4d4;" 
	  
//	  $("body").mask("提交中...");
//	  document.getElementById("addvacationform").submit();
//	  jquerySubByFId('addvacationform',vacationsave_callback,null,"json");
	  $.post("/users/insertuser",$("#addvacationform").serialize(), function(data){
			if(data.status == 200){
//		  		alert("新增用户成功!");
				$.messager.alert('提示信息',''+data.msg,'info',function () {
	            	document.getElementById('closebtn').click();
		        });
//				$('#addvacationform').window('close');//closebtn
//				document.getElementById('closebtn').click();
				//$('#addvacationform').form('reset');
			}
			if(data.resultInfo.status == 500){
				$.messager.alert('提示信息',''+data.resultInfo.msg,'error');
			}
			
		});

  }
   
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="addvacationform" name="addvacationform"  method="post"> <%-- action="${baseurl}user/insertuser" --%>
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
   			<!-- <TR class="table_ubg"> -->
   			<TR>
			<td class="table_title">年假基本信息</td>
			</TR>
			
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 align=center >
						<TBODY>
							<!--id;userid;year;have;used;remain;starttime;stoptime;previousremain;previousstoptime;total-->
							<TR>
								<TD height="30px" width="130px" align=right >姓名：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="text" id="name" name="name"  /></TD>
								
								<TD height="30px" width="150px" align=right >年份：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="text" id="year" name="year"  /></TD>
								
							</TR>
							<TR>
								<TD height="30px" width="130px" align=right >今年总天数：</td>
								<td style="padding-left: 5px">
								<input type="text" id="have" name="have" /></TD>
								
								<TD height="30px" width="150px" align=right >今年已用天数：</td>
								<td style="padding-left: 5px">
								<input type="text" id="used" name="used" /></TD>
								
							</TR>
							<TR>
								<TD height="30px" width="130px" align=right >今年剩余天数：</td>
								<td style="padding-left: 5px">
								<input type="text" id="remain" name="remain" /></TD>
								
								<TD height="30px" width="150px" align=right >开始时间：</td><td style="padding-left: 5px">
								<input type="text" id="statime" name="statime" class="easyui-datebox" required="required" /></TD>
							</TR>
							<TR>
							    <TD height="30px" width="130px" align=right >结束时间：</td><td style="padding-left: 5px">
								<input type="text" id="stotime" name="stotime" class="easyui-datebox" required="required" /></TD>
								<TD height="30px" width="150px" align=right>上年结余天数：</td><td style="padding-left: 5px">
								<input type="text" id="address" name="address" /></TD>
							</TR>
							<TR>
							    <TD height="30px" width="130px" align=right >结余截止时间：</td><td style="padding-left: 5px">
								<input type="text" id="pretime" name="pretime" class="easyui-datebox" required="required" /></TD>
								<!-- <TD height="30px" width="150px" align=right>上年结余天数：</td><td style="padding-left: 5px">
								<input type="text" id="address" name="address" /></TD> -->
							</TR>
							<tr>
							  <td colspan=4 align=center class="table_sub">
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="vacationsave()">提交</a>
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