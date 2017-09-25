<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>编辑年假</title>
<script type="text/javascript">
  function vacationeditsave(){
	  if(document.vacationform.have.value == "" ){
		var obj = document.getElementById("have");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('have').focus();
	    return;
	  }
	  document.getElementById("have").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.vacationform.used.value =="" ){
 		  var obj = document.getElementById("used");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('used').focus();
	      return;
	  }
	  document.getElementById("used").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.vacationform.remain.value==""){
		  var obj = document.getElementById("remain");
  		  obj.style.cssText = "border: 1px solid #f00;"
// 		  document.getElementById('remain').focus();
	      return;
	  }  
	  document.getElementById("remain").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.vacationform.previousremain.value==""){
		  var obj = document.getElementById("previousremain");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('previousremain').focus();
	      return;
	  }  
	  document.getElementById("previousremain").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  $.post("/users/updatevacation",$("#vacationform").serialize(), function(data){
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
   
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="vacationform" name="vacationform"  method="post"> 
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
  	  <TR>
		<td class="table_title">${vacationQueryVo.year}年${vacationQueryVo.name}的年假信息</td>
		</TR>
		
		<TR>
			<TD>
				<TABLE cellSpacing=0 cellPadding=0 align=center >
					<TBODY>
		<!--id;userid;have;used;remain;starttime;stoptime;previousremain;previousstoptime;total-->
					<TR>
						<TD height="30px" width="100px" align=right >姓名：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input disabled="true" type="text" id="name" name="name" value="${vacationQueryVo.name}" />
						<input type="hidden" id="id" name="id" value="${vacationQueryVo.id}"/>
						</TD>
						<TD height="30px" width="150px" align=right >部门名称：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input disabled="true" type="text" id="deptName" name="deptName" value="${vacationQueryVo.deptName}" /></TD>
					</TR>
					<TR>
						<TD height="30px" width="100px" align=right >今年总天数：</td>
						<td style="padding-left: 5px">
						<input type="text" id="have" name="have" value="${vacationQueryVo.have}" /></TD>
						<TD height="30px" width="150px" align=right >今年已用天数：</td><td style="padding-left: 5px">
						<input type="text" id="used" name="used" value="${vacationQueryVo.used}"/></TD>
					</TR>
					<TR>
						<TD height="30px" width="100px" align=right >今年剩余天数：</td><td style="padding-left: 5px">
						<input type="text" id="remain" name="remain" value="${vacationQueryVo.remain}" /></TD>
						<TD height="30px" width="150px" align=right >开始时间：</td><td style="padding-left: 5px">
						<!-- <input id="dd" type="text" class="easyui-datebox" required="required"></input> -->  
						<input type="text" id="statime" name="statime" class="easyui-datebox" required="required" value="${vacationQueryVo.statime}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="100px" align=right >结束时间：</td><td style="padding-left: 5px">
						<input type="text" id="stotime" name="stotime" class="easyui-datebox" required="required" value="${vacationQueryVo.stotime}"/></TD>
						<TD height="30px" width="150px" align=right>上年结余天数：</td><td style="padding-left: 5px">
						<input type="text" id="previousremain" name="previousremain" value="${vacationQueryVo.previousremain}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="120px" align=right >转余截止时间：</td><td style="padding-left: 5px">
						<input type="text" id="pretime" name="pretime" class="easyui-datebox" required="required" value="${vacationQueryVo.pretime}"/></TD>
						<%-- <TD height="30px" width="150px" align=right>工伤保险：</td><td style="padding-left: 5px">
						<input type="text" id="employmentinjuryinsurance" name="employmentinjuryinsurance" value="${vacationQueryVo.employmentinjuryinsurance}"/></TD> --%>
					</TR>
					<tr>
					  <td colspan=4 align=center class="table_sub">
						<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="vacationeditsave()">提交</a>
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