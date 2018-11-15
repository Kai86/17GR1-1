package org.news.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.news.dao.impl.NewsDaoImpl;
import org.news.dao.impl.TopicsDaoImpl;
import org.news.dao.server.TopicUtil;
import org.news.dao.server.imp.TopicServer;
import org.news.entity.Topic;

import com.alibaba.fastjson.JSON;

public class TopicServlet extends HttpServlet {
	public void destroy() {
		super.destroy(); 
	}
	TopicsDaoImpl tp = new TopicsDaoImpl();
	NewsDaoImpl nes = new NewsDaoImpl();
	TopicServer ns = new TopicServer();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String parameter = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		System.out.println(parameter);
		if(parameter.equals("topicdelete")){//删除主题
			System.out.println("删除主题：Opr="+parameter);
			String ss = (String)request.getParameter("id");
			int sg = Integer.parseInt(ss);
			int delete = ns.topicDelete(sg);
			if(delete==0){
				response.sendRedirect("../util/do_topic_list.jsp");
			}else{
				response.sendRedirect("util/do_topic_list.jsp");
			}
		}else if(parameter.equals("select")){//查询主题
			System.out.println("查询主题：Opr="+parameter);
			List<Topic> topicSelect = ns.topicSelect();
			request.setAttribute("list1", topicSelect);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(parameter.equals("bianji")){//编辑主题
			System.out.println("编辑主题：Opr="+parameter);
			List<Topic> topicSelect = ns.topicSelect();
			request.setAttribute("list1", topicSelect);
			request.getRequestDispatcher("/newspages/topic_list.jsp").forward(request, response);
		}else if(parameter.equals("topicselect")){
			System.out.println("查询主题：Opr="+parameter);
			List<Topic> topicSelect = ns.topicSelect();
			String obj = JSON.toJSONString(topicSelect);
			System.out.println(obj);
			out.print(obj);//输出集合。
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String parameter = request.getParameter("opr");
		
		System.out.println(parameter);
		if (parameter.equals("topicupdate")){//修改主題
			System.out.println("修改主題：Opr="+parameter);
			String ti = (String) request.getParameter("tid");
			int tid = Integer.parseInt(ti);
			String tname = request.getParameter("tname");
			int update = ns.topicUpdate(tid, tname);
			if (update == 0) {
				response.sendRedirect("../news_chapter03/util/do_topic_list.jsp");
			} else {
				response.sendRedirect("../news_chapter03/util/do_topic_list.jsp");
			}
		}else if(parameter.equals("topicinsert")){//添加主題
			System.out.println("添加主題：Opr="+parameter);
			String tname = request.getParameter("tname");
			int inser = ns.topicInser(tname);
			if(inser == 0){
				response.sendRedirect("newspages/topic_add.jsp");
			}else{
				response.sendRedirect("util/do_topic_list.jsp");
			}
		}
	}
	public void init() throws ServletException {
	}
}
