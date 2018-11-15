<%@ page language="java" import="java.util.*,java.sql.*,org.news.entity.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <script language="javascript">
	function clickdel(id){
		var far = confirm("删除请点击确认");
		if(far){
		}
	}
</script>
    <ul class="classlist">
      <%	
      List<News> list=( List<News>)session.getAttribute("list");
      if(list==null){
      	response.sendRedirect("../util/do_news_list.jsp");
      	return;
      }else{
	      session.removeAttribute("list");
		  int n=0;
		  for(News tempNew:list){
		    n++;		
	     %> 
	      <li><%=tempNew.getNtitle() %><span> 作者：<%=tempNew.getNauthor() %> &#160;&#160;&#160;&#160; <a href='news_update.jsp?nid=<%=tempNew.getNid()%>'>修改</a> &#160;&#160;&#160;&#160; <a href='../NewsServlet?opr=newsdelete&id=<%=tempNew.getNid()%>' >删除</a> </span> </li>
	      <%if(n%5==0){ %>
	      <li class='space'></li>
	      <%}}}%>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
