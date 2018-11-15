package org.news.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.news.dao.impl.UserDaoImpl;
import org.news.dao.server.imp.UserServer;
import org.news.entity.News;
import org.news.entity.Page;
import org.news.entity.User;

public class loginServlet extends HttpServlet {
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String parameter = request.getParameter("opr");
		UserServer us = new UserServer();
		System.out.println(parameter);
		if(parameter.equals("index")){//登录
			System.out.println("登录"+parameter);
			String parameter1 = request.getParameter("uname");
			String parameter2 = request.getParameter("upwd");
			User findUser = us.dengLu(parameter1, parameter2);
			if(findUser!=null){
				response.sendRedirect("/news_chapter03/util/do_news_list.jsp");
			}else{
				response.sendRedirect("/news_chapter03/index.jsp");
			}
		}
	}
	public void init() throws ServletException {
	}

}
