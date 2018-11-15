<%@ page language="java" import="java.util.*,org.news.entity.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.getJSON({
				"url":"/TopicServlet",
				"data":"opr=topicselect",
				"success" : function(obj){
					alert(obj);
					var $json = $(obj);
					$json.each(function(){
					$(".classlist").append(" <li> &#160;&#160;&#160;&#160;"+this.tname+
					"&#160;&#160;&#160;&#160; <a href='../newspages/topic_update.jsp?tid="
					+this.tid+"&name="+this.tname+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../TopicServlet?opr=topicdelete&id="
							+this.tid+"'>删除</a> </li>");
						
					})
				}
				});
		});
	</script>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist">
    
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
