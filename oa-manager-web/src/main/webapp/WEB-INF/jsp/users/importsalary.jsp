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

  function jquerySubByFId(formId,callbackFn,param,dataType){
	var formObj = jQuery("#" + formId);
	var options = {
            dataType:  ("undefined"!=dataType && null!=dataType)?dataType:"json",
			success: function(responseText) {
				if(param === null){
					callbackFn(responseText);
				}else{
					callbackFn(responseText,param);
				}
			}
	};
	formObj.ajaxSubmit(options); 
  }
  function salaryimport(){
  	  var fil = $("#salaryimportfile").val();
//  	  console.info(fil);
 	  if(fil == null || fil == ''){
 	  	$.messager.alert('提示信息','请选择导入文件！','error');
 	  	return;
 	  }
  	  jquerySubByFId('salaryimportform',importsubmit_callback,null);
  }
  function importsubmit_callback(data){
  		if(data.status == 200){
  			if(data.data.fnum != 0){
  				$.messager.alert('提示信息','成功导入'+data.data.snum+'条数据,<a href='+data.data.webpath+'>失败'+data.data.fnum+'条</a>','info',function () {
	            	document.getElementById('closebtn').click();
		        });
  			}else{
	  			$.messager.alert('提示信息','成功导入'+data.data.snum+'条数据,失败'+data.data.fnum+'条','info',function () {
	            	document.getElementById('closebtn').click();
		        });
  			}
  		}
  		
		if(data.resultInfo.status == 500){
			$.messager.alert('提示信息',data.resultInfo.msg,'error');
		}
  }
 
</script>
<style type="text/css">


</style>
</head>
<body>


<form id="salaryimportform" name="salaryimportform" action="/users/importsalaryinfo" method="post" enctype="multipart/form-data">
<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
 	<TR>
	<td class="table_title">模板导入信息提示</td>
	</TR>
	
	<TR>
		<TD>
			<TABLE cellSpacing=0 cellPadding=0 align=center >
				<TBODY>
					<!-- id; did; username; password; sex; phone; telephone; email; address; -->
					<TR>
						<TD width="670" align=left style="line-height: 30px;">
						1、导入文件为Excel 97-2003版本，文件扩展名为.xls，如果使用高版本的Excel请另存为<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Excel 97-2003版本。
						<br>2、点击 <a class="blue" href="${baseurl}template/salary_template.xls"><u>导入信息模板</u></a> 下载，并按照相应格式录入信息。
						<br>3、导入文件内容填写完毕请在下方选择导入文件，点击导入按钮。
						</TD>
					</TR>
					<TR>
						<TD height="40" align=left style="padding-left: 25px;">
						选择导入文件:<input type="file" id="salaryimportfile" name="salaryimportfile" />					
						</TD>
					</TR>
					<tr>
					  <td colspan=4 align=center class="table_sub">
						<!-- <button type="submit">提交</button> -->
						<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="salaryimport()">提交</a>
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