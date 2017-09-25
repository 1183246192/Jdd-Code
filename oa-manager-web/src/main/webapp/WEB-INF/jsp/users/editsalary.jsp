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
  function salaryeditsave(){
	  if(document.salaryform.checkingdays.value == "" ){
		var obj = document.getElementById("checkingdays");
// 		obj.setAttribute("class", "table_alert");
		obj.style.cssText = "border: 1px solid #f00;"
//	  	alert("OK");
 		document.getElementById('checkingdays').focus();
	    return;
	  }
	  document.getElementById("checkingdays").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.salaryform.basicsalary.value =="" ){
 		  var obj = document.getElementById("basicsalary");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('basicsalary').focus();
	      return;
	  }
	  document.getElementById("basicsalary").style.cssText = "border: 1px solid #d4d4d4;"
	  
	  if(document.salaryform.trafficallowance.value==""){
		  var obj = document.getElementById("trafficallowance");
  		  obj.style.cssText = "border: 1px solid #f00;"
// 		  document.getElementById('trafficallowance').focus();
	      return;
	  }  
	  document.getElementById("trafficallowance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.otherallowance.value==""){
		  var obj = document.getElementById("otherallowance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('otherallowance').focus();
	      return;
	  }  
	  document.getElementById("otherallowance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.endowmentinsurance.value==""){
		  var obj = document.getElementById("endowmentinsurance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('endowmentinsurance').focus();
	      return;
	  }  
	  document.getElementById("endowmentinsurance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.medicalinsurance.value==""){
		  var obj = document.getElementById("medicalinsurance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('medicalinsurance').focus();
	      return;
	  }  
	  document.getElementById("medicalinsurance").style.cssText = "border: 1px solid #d4d4d4;" 
//	  unemploymentinsurance;employmentinjuryinsurance;maternityinsurance;housingfund;othersdeduct;
	  if(document.salaryform.unemploymentinsurance.value==""){
		  var obj = document.getElementById("unemploymentinsurance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('unemploymentinsurance').focus();
	      return;
	  }  
	  document.getElementById("unemploymentinsurance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.employmentinjuryinsurance.value==""){
		  var obj = document.getElementById("employmentinjuryinsurance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('employmentinjuryinsurance').focus();
	      return;
	  }  
	  document.getElementById("employmentinjuryinsurance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.maternityinsurance.value==""){
		  var obj = document.getElementById("maternityinsurance");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('maternityinsurance').focus();
	      return;
	  }  
	  document.getElementById("maternityinsurance").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.housingfund.value==""){
		  var obj = document.getElementById("housingfund");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('housingfund').focus();
	      return;
	  }  
	  document.getElementById("housingfund").style.cssText = "border: 1px solid #d4d4d4;" 
	  
	  if(document.salaryform.othersdeduct.value==""){
		  var obj = document.getElementById("othersdeduct");
  		  obj.style.cssText = "border: 1px solid #f00;"
 		  document.getElementById('othersdeduct').focus();
	      return;
	  }  
	  document.getElementById("othersdeduct").style.cssText = "border: 1px solid #d4d4d4;" 
	  
//	  $("body").mask("提交中...");
//	  document.getElementById("salaryform").submit();
//	  jquerySubByFId('salaryform',sysusersave_callback,null,"json");
	  $.post("/users/updatesalary",$("#salaryform").serialize(), function(data){
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


<form id="salaryform" name="salaryform"  method="post"> 
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
  	  <TR>
		<td class="table_title">${salaryQueryVo.month} 工资信息</td>
		</TR>
		
		<TR>
			<TD>
				<TABLE cellSpacing=0 cellPadding=0 align=center >
					<TBODY>
<!-- id;userid;month;basicsalary;fsalary;checkingdays;mealallowance;txallowance;
trafficallowance;otherallowance;endowmentinsurance;medicalinsurance;unemploymentinsurance;
employmentinjuryinsurance;maternityinsurance;housingfund;othersdeduct;totaldeduct; -->
					<TR>
						<TD height="30px" width="100px" align=right >姓名：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input disabled="true" type="text" id="name" name="name" value="${salaryQueryVo.name}" />
						<input type="hidden" id="id" name="id" value="${salaryQueryVo.id}"/>
						</TD>
						<TD height="30px" width="150px" align=right >部门名称：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input disabled="true" type="text" id="deptName" name="deptName" value="${salaryQueryVo.deptName}" /></TD>
					</TR>
					<TR>
						<TD height="30px" width="100px" align=right >出勤天数：</td>
						<td style="padding-left: 5px">
						<input type="text" id="checkingdays" name="checkingdays" value="${salaryQueryVo.checkingdays}" /></TD>
						<TD height="30px" width="150px" align=right >基本工资：</td><td style="padding-left: 5px">
						<input type="text" id="basicsalary" name="basicsalary" value="${salaryQueryVo.basicsalary}"/></TD>
					</TR>
					<TR>
						<TD height="30px" width="100px" align=right >交通补：</td><td style="padding-left: 5px">
						<input type="text" id="trafficallowance" name="trafficallowance" value="${salaryQueryVo.trafficallowance}" /></TD>
						<TD height="30px" width="150px" align=right >其他津贴：</td><td style="padding-left: 5px">
						<input type="text" id="otherallowance" name="otherallowance" value="${salaryQueryVo.otherallowance}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="100px" align=right >养老保险：</td><td style="padding-left: 5px">
						<input type="text" id="endowmentinsurance" name="endowmentinsurance" value="${salaryQueryVo.endowmentinsurance}"/></TD>
						<TD height="30px" width="150px" align=right>医疗保险：</td><td style="padding-left: 5px">
						<input type="text" id="medicalinsurance" name="medicalinsurance" value="${salaryQueryVo.medicalinsurance}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="100px" align=right >失业保险：</td><td style="padding-left: 5px">
						<input type="text" id="unemploymentinsurance" name="unemploymentinsurance" value="${salaryQueryVo.unemploymentinsurance}"/></TD>
						<TD height="30px" width="150px" align=right>工伤保险：</td><td style="padding-left: 5px">
						<input type="text" id="employmentinjuryinsurance" name="employmentinjuryinsurance" value="${salaryQueryVo.employmentinjuryinsurance}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="100px" align=right >生育保险：</td><td style="padding-left: 5px">
						<input type="text" id="maternityinsurance" name="maternityinsurance" value="${salaryQueryVo.maternityinsurance}"/></TD>
						<TD height="30px" width="150px" align=right>住房公积金：</td><td style="padding-left: 5px">
						<input type="text" id="housingfund" name="housingfund" value="${salaryQueryVo.housingfund}"/></TD>
					</TR>
					<TR>
					    <TD height="30px" width="100px" align=right >其他应扣：</td><td style="padding-left: 5px">
						<input type="text" id="othersdeduct" name="othersdeduct" value="${salaryQueryVo.othersdeduct}"/></TD>
						<TD height="30px" width="150px" align=right>月份：</td><td style="padding-left: 5px">
						<input type="text" id="month" name="month" value="${salaryQueryVo.month}"/></TD>
					</TR>
					<tr>
					  <td colspan=4 align=center class="table_sub">
						<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="salaryeditsave()">提交</a>
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