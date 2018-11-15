<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zuoye01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  $("#min").blur(function(){
		 var min =  $("#min").val();
	  $.get({
		  "url"     :  "TsetServlet",
		  "data"    :  "opr="+min,
		  "success" :  sss
		  });
	 	/* 
		 $.post({
			  "url"     :  "TsetServlet",
			  "data"    :  "opr="+min,
			  "success" :  sss
			  });
		*/
	  function sss(result){
		 if(result=="face"){
			 $("#sp").html("可以注册！");
		 }else if(result=="cafg"){
			 $("#sp").html("不能注册！");
		 }
	  }
	  
	  });
  });
  </script>
  <body>
  <div id="sp"></div>
  	<form>
  		邮箱：<input type="text" name="eminl" id="min"><span> </span><br/>
  		姓名：<input type="text" name="username"><span></span><br/>
  		密码：<input type="password" name="pwd"><span></span><br/>
 	 </form>
 	<input type="submit" value="注册">
  </body>
</html>
