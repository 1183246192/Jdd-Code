<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>

<script type="text/javascript">
  function editpassword(){
	  if(document.passform.password.value == "" ){
		var obj = document.getElementById("password");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('password').focus();
	    return;
	  }
	  document.getElementById("password").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.passform.password2.value==""){
		  var obj = document.getElementById("password2");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('password2').focus();
	      return;
	  }  
	  document.getElementById("password2").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  var pass1 = document.passform.password.value;
	  var pass2 = document.passform.password2.value;
	  if(!(pass1 == pass2)){
	  	alert("两次输入的密码不相同！");
	  	return ;
	  }
	  $.post("/user/updatepass",$("#passform").serialize(), function(data){
	   	    console.info(data);
			if(data.status == 200){
				$.messager.alert('提示信息','修改用户成功!','info',function () {
					document.getElementById('closebtn').click();
		        });
			}
		});

  }
   
</script>


<form id="passform" name="passform"  method="post"> 
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu" style="width: 480px;">

   <TBODY>
   			<!-- <TR class="table_ubg"> -->
   			<TR>
			<td class="table_title">修改密码</td>
			</TR>
			
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 align=center >
						<TBODY>
							<TR>
								<TD height="30px" width="120px" align=right >姓名：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="hidden" id="id" name="id" value="${user.id}" />
								<input disabled="disabled" type="text" id="username" name="username" value="${user.username}" /></TD>
							</TR>
							<TR>	
								<TD height="30px" width="120px" align=right >密码：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="password" name="password" id="password"  />
								
							</TR>
							<tr>
								<TD height="30px" width="120px" align=right >确认密码：</td>
								<td height="30px" width="190px" style="padding-left: 5px">
								<input type="password" name="password2" id="password2"  />
								</TD>
							</tr>
							
							<tr>
							  <td colspan=4 align=center class="table_sub">
								<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="editpassword()">提交</a>
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
