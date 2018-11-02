<%@ page language="java" import="java.util.*,org.news.entity.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- <script src="\news_chapter03\WebRoot\WEB-INF\lib\jquery-1.12.4.js">
</script>
<script type="text/javascript">
   $(function(){
	   $("ul>li").children().click(function(){
		   alert($(this).next().html());
	   })
   })

</script> -->
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist">
      <%
        List<Topic> list = (ArrayList<Topic>) request.getAttribute("list");
        for(Topic tempTopic: list){ 
     %>
      <li> &#160;&#160;&#160;&#160; <%=tempTopic.getTname() %> &#160;&#160;&#160;&#160; <a href='../newspages/topic_update.jsp?tname=<%=tempTopic.getTname()%> &tid=<%=tempTopic.getTid() %>'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/do_delete_topic.jsp?tname=<%=tempTopic.getTname()%> &tid=<%=tempTopic.getTid() %>'>删除</a> </li>
      <%}%>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
