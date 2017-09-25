<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${baseurl}css/login_oa.css" />
	<script type="text/javascript" src="${baseurl}js/jquery-1.4.4.min.js"></script>
	<SCRIPT type="text/javascript" src="${baseurl}js/easyui/jquery.easyui.min.1.2.2.js"></SCRIPT>

	<!-- <link rel="stylesheet" type="text/css" href="style/login_oa.css"> -->
	<script type="text/javascript">
	if (window != top) {
		top.location.href = location.href; 
	}
	
	function changeEnter(){
		var e = e || window.e;
		alert(e.keyCode);
   		if(event.keyCode==13){
   			event.keyCode=9;
   		} 
	} 
	
	$(function() {  
		refresh();
	    $("#frmLogin input").keypress(function(e) {  
		    if (e.which == 13) {// 判断所按是否回车键  
		        var inputs = $("#frmLogin input"); // 获取表单中的所有输入框  
		        var idx = inputs.index(this); // 获取当前焦点输入框所处的位置  
		        if (idx == inputs.length - 1) {// 判断是否是最后一个输入框  
//	  		        if (confirm("最后一个输入框已经输入,是否提交?")) // 用户确认  
		            $("#frmLogin").submit(); // 提交表单  
		        } else {  
		            inputs[idx + 1].focus(); // 设置焦点  
		            inputs[idx + 1].select(); // 选中文字  
		        }  
		        return false;// 取消默认的提交行为  
		    }  
	    });  
	}); 
	
	function refresh() {
		setTimeout("_refresh()", 700);
	}	

	function _refresh() {
		var src = document.getElementById("authImg").src;
		document.getElementById("authImg").src = src + "?now=" + new Date().getTime(); 
	}
	
	function doCheck(){
	  if(document.frmLogin.username.value=="" ){
// 		$.messager.alert('错误提示','请输入正确的用户名！','error');
		alert('请输入正确的用户名！');
 		document.frmLogin.username.focus();
	    return;
	  }
	  if(document.frmLogin.passwd.value=="" ){
// 		  $.messager.alert('错误提示','请输入正确的密码！','error');
 		  alert('请输入正确的密码！');
 		  document.frmLogin.passwd.focus();
	      return;
	  }
	  if(document.frmLogin.authCode.value=="" || document.frmLogin.authCode.value.length < 4){
// 		  $.messager.alert('错误提示','请输入正确的验证码！','error');
 		   alert('请输入正确的验证码！');
		  document.frmLogin.authCode.focus();
	      return;
	  }   
//	  $("body").mask("登录中...");
	  document.frmLogin.submit();
	}
	
	
	</script>

  </head>
  
  <body>
    <div class="bg">
    	<div class="login_bg">
    	<form id="frmLogin" name="frmLogin" action="<%=basePath %>loginSubmit" method="post" autocomplete="off">
    		<div class="login_box">
    			<div class="loginerr_msg">
    				<c:if test="${!empty message}">
						<span class="error_msg">${message}</span>
					</c:if>
					<!-- <span class="error_msg">你错了，哈哈哈</span> -->
    			</div>
	   			<div class="name_box">
	   				<span class="login_name"><input class="login_input" name="username" type="text"  /></span>
	   			</div>
	   			<div class="pass_box">
	   				<span class="login_pass"><input class="login_input" name="passwd"  type="password"  /></span>
	   			</div>
	   			<div class="auth_box">
	   				<span class="login_auth"><input class="login_auinput" name="authCode" type="text"  />
	   				</span>
	   				<img title="看不清?点击刷新" onclick="refresh();" id="authImg" src="authimg" width="80" height="28" class="authImg" />
	   				
	   			</div>
	   			<div class="login_submit" href="javascript:void(0);" onclick="doCheck()">
	   				<span>登录</span>
	   			</div>
	    	</div>
	    </form>
    	</div>
    	
    </div>

  </body>
</html>
