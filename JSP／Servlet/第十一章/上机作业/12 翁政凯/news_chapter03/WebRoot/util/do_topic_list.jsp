<%@page import="org.news.dao.TopicsDao"%>
<%@page import="org.news.dao.impl.TopicsDaoImpl,org.news.entity.*"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	TopicsDao topicsDao = new TopicsDaoImpl();
    List<Topic> list = topicsDao.getAllTopics();    
    request.setAttribute("list", list);
    request.getRequestDispatcher("/newspages/topic_list.jsp").forward(request,response);
%>