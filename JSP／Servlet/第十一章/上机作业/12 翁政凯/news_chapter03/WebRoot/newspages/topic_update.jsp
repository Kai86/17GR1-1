<%@page import="org.news.dao.impl.TopicsDaoImpl"%>
<%@page import="org.news.entity.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");
		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}
		return true;
	}
</script>
</head>
	<%
  	request.setCharacterEncoding("UTF-8");
  	%>
 </head>
  <body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <h1 id="opt_type"> 更改主题： </h1>
    <form action="../TopicServlet?opr=topicupdate" method="post" onsubmit="return check()">
        <label> 主题名称 </label>
        <input name="tname" type="text" class="opt_input" value="<%=request.getParameter("name")%>"/>
        <input name="tid" type="hidden" class="opt_input" value="<%=request.getParameter("tid")%>"/>
      </p>
      <input name="action" type="hidden" value="addtopic"/>
      <input type="submit" value="提交" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
</html>
