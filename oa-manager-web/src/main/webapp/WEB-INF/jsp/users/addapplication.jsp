<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<title>休假申请</title>
<script type="text/javascript">
  
  function applicationsave(){
  		var params = '';
	    var groups = $(".table-adu [name=leader]");
//  		console.info(params);
		groups.each(function(i,e){
//	    	console.info(e);
//			var _val = $(e).siblings("input").val();
			var _val = $(".Addparam [name=leader]").eq(i).val();
//			alert(_val);
			if($.trim(_val).length > 0){
				if (params == '') {
	                	params += _val;
	                }else{
	                	params += ','+ _val;
	                }
				/* params.push({
					"group":_val
				}); */					
			}
		});
//		console.info(params);
		document.getElementById("leaderlist").value = params ;
	  
	    $.post("/users/insertapplication",$("#addapplicationform").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示信息',''+data.msg,'info',function () {
	            	document.getElementById('closebtn').click();
					window.parent.location.reload(true);
		        });
			}
			if(data.resultInfo.status == 500){
				$.messager.alert('提示信息',''+data.resultInfo.msg,'error');
			}
			
		});

  }
  
  
  $(document).ready(function(){
       $(".addGroup").click(function(){
//       	var ls = $("#leaders").textbox('getValue');
//       	$("#leader").textbox('setText',ls);
//			console.info(ls);
//			$('#delParam').css('display','');

			var temp = $("#AddTemplate").html();//保存渲染前的模板
//			var temple = $(".AddTemplate li").eq(0).clone();
			$("#AddTemplate select").combobox({panelHeight:"auto"});//渲染
			$(temp).appendTo($(".Addparam")).find(".delParam").click(function(){
				$(this).parent().remove();
			}).siblings("span").css('display','none').parent().find("select").combobox({panelHeight:"auto"});//加载新行并渲染
			
			/* var temple = $(".AddTemplate li").eq(0).clone();
			$(".Addparam").append(temple);
			temple.find(".delParam").click(function(){
				$(this).parent().remove();
			}); */
		});
		
		//这种方式行不通，clone()添加之后的combobox用不了
		/* $('#leaders').combobox({ 
		    url:'/users/getLeaders', 
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    valueField:'username',   
		    textField:'username'
	   }); */
	   
	   /* type 1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他 */
	   $('#type').combobox({
		    editable:false, //不可编辑状态
		    cache: false,
		    panelHeight: 'auto',//自动高度适合
		    valueField:'id',   
		    textField:'text',
		    data:[{    
			    "id":1,    
			    "text":"年假"   
			},{    
			    "id":2,    
			    "text":"公假"   
			},{    
			    "id":3,    
			    "text":"事假"   
			},{    
			    "id":4,    
			    "text":"病假"   
			},{    
			    "id":5,    
			    "text":"其他"   
			}],
			required:true
	   });
		
  });  
   
 
</script>
<style type="text/css">
ul {list-style-type:none;display:inline;}
li {list-style-type:none;display:inline;}
</style>
</head>
<body>


<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" background="#fff" class="table-adu">

   <TBODY>
	<TR>
		<td class="table_title">休假申请信息</td>
	</TR>
	
	<TR>
		<TD>
			<form id="addapplicationform" name="addapplicationform"  method="post"> <%-- action="${baseurl}user/insertuser" --%>
			<TABLE cellSpacing=0 cellPadding=0 align=center >
			<TBODY>
					<!--  -->
					<TR>
						<TD height="30px" width="130px" align=right >姓名：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input class="easyui-textbox" disabled="disabled" id="name" name="name" style="height: 25px" value="${username}" />
						<input type="hidden" id="id" name="id" value="${userid}" /> 	<!-- 用户的ID -->
						</TD>
						<TD height="30px" width="150px" align=right >部门：</td>
						<td height="30px" width="190px" style="padding-left: 5px">
						<input class="easyui-textbox" disabled="disabled" id="deptName" name="deptName" style="height: 25px" value="${deptName}" /></TD>
						
					</TR>
					<TR><!-- type 1：年假 2：公假（产假、婚假、丧假）  3：事假  4：病假  5：其他 -->
						<TD height="30px" width="130px" align=right >请假类别：</td>
						<td style="padding-left: 5px">
						<input id="type" name="type" class="easyui-combobox" style="height: 25px" />
						<!-- <select id="type" name="type" class="easyui-combobox easyui-validatebox" style="height: 25px" required="required" data-options="required:true,editable:false">
						    <option value="">请选择类别</option>
						    <option value="1">年假</option>
						    <option value="2">公假（产、婚、丧）</option>
						    <option value="3">事假</option>
						    <option value="4">病假</option>
						    <option value="5">其他</option>
						</select> -->
						</TD>
						
						<TD height="30px" width="150px" align=right >请假事由说明：</td>
						<td style="padding-left: 5px">
						<input class="easyui-textbox" id="reason" name="reason" style="height: 25px" prompt="" data-options="required:true"/></TD>
						
					</TR>
					<TR>
						<TD height="30px" width="130px" align=right >申请时间：</td>
						<td style="padding-left: 5px">
						<input id="apptime" name="apptime" class="easyui-datebox" required="required" style="height: 25px"/></TD>
						
						<TD height="30px" width="150px" align=right >申请天数：</td><td style="padding-left: 5px">
						<input id="days" name="days" class="easyui-textbox" style="height: 25px" data-options="required:true"/>
						<input type="hidden" id="leaderlist" name="leaderlist" value=""/>
						</TD>
					</TR>
					
					</TBODY>
					
				</TABLE>
				</form>
				<table cellSpacing=0 cellPadding=0 align=center width="660px">
					<tr ><!-- style="border:1px solid #8db2e3;border-radius: 5px;" -->
						<td height="30px" width="130px" align=right >审核顺序：&nbsp;</td>
						<td colspan="3" class="Addparam" width="350px">
						<!-- <span class="Addparam" style="height: 30px;"></span> -->
						</td>
						<td>
							<a class="easyui-linkbutton addGroup" data-options="plain:true,iconCls:'icon-add'"></a>
							<!-- <input style="width:60px;height:25px;" class="easyui-combobox" id="leaders" name="leaders" editable="false"/> -->
							
						</td>
					</tr>
					<tr>
					  <td colspan=4 align=center class="table_sub">
						<a id="submitbtn"  class="easyui-linkbutton"   iconCls="icon-ok" href="#" onclick="applicationsave()">提交</a>
						<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel" href="#" onclick="parent.closemodalwindow()">关闭</a>
					  </td>
					</tr>
					
				</table>
			</TD>
		</TR>
   </TBODY>
</TABLE>
<div id="AddTemplate" class="AddTemplate" style="display: none;" ><!-- style="display: none;" -->
	<ul>
		<li>
		<select id="leader" name="leader" class="easyui-combobox" style="width: 80px;height: 30px;" >
		    <option value="">请选择</option>
		    <c:forEach var="ld" items="${ldslist}" >
				<option value="${ld.id}">${ld.username}</option>
				<!-- 当前对象 -->
			</c:forEach>
		</select>
		<!-- <input style="width:60px;height:25px;" class="easyui-textbox" id="leader" name="leader" editable="false"/> -->
		<a id="delParam" name="delParam" href="javascript:void(0)" class="delParam" title="删除" style="width:22px;height:22px;display: '';"></a>						
		</li>
	</ul>
</div>
				
</body>
</html>