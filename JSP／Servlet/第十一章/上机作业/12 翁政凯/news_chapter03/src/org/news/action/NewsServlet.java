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
import org.news.dao.server.imp.NewsServer;
import org.news.entity.News;

public class NewsServlet extends HttpServlet {
	public void destroy() {
		super.destroy();
	}
	NewsServer ne = new NewsServer();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();	
		String parameter = request.getParameter("opr");
		System.out.println(parameter);
		if(parameter.equals("newsdelete")){//刪除新聞
			System.out.println("刪除新聞：Opr="+parameter);
			  String sd = (String)request.getParameter("id");
			  int ss = Integer.parseInt(sd);
			  int delete = ne.newsDelete(ss);
			  if(delete>=1){
					response.sendRedirect("/news_chapter03/newspages/admin.jsp");
			  }
		}
		if(parameter.equals("topselect")){//查询主题下的新闻
			System.out.println("查询主题下的新闻：Opr="+parameter);
			 String id = (String)request.getParameter("tid");
			 int tid = Integer.parseInt(id);
			 List<News> news_Topic_Select = ne.news_Topic_Select(tid);
			 request.setAttribute("list", news_Topic_Select);
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(parameter.equals("pagesle")){//分页
			System.out.println("分页：Opr="+parameter);
			String ss = (String)request.getParameter("s");
			int pageInt = Integer.parseInt(ss);
			List<News> pageyumian = ne.pageyumian(pageInt);
			request.setAttribute("list", pageyumian);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String parameter = request.getParameter("opr");
		System.out.println(parameter);
		if(parameter.equals("newsupdate")){//修改新聞
			System.out.println("修改新聞：Opr="+parameter);
		  	String id = (String)request.getParameter("id");
			int nid = Integer.parseInt(id);
			String name = (String)request.getParameter("ntid");
			int s = Integer.parseInt(name);
			String ntitle = request.getParameter("ntitle");
			String nauthor = request.getParameter("nauthor");
			String nsummary = request.getParameter("nsummary");
			String ncontent = request.getParameter("ncontent");
			News news = new News();
			news.setNid(nid);
			news.setNtid(s);
			news.setNtitle(ntitle);
			news.setNauthor(nauthor);
			news.setNsummary(nsummary);
			news.setNcontent(ncontent);
			int update = ne.newsUpdate(news);
			if(update>=1){
				response.sendRedirect("/news_chapter03/newspages/admin.jsp");
			}else{
				response.sendRedirect("/news_chapter03/newspages/news_update.jsp");
			}
		}else if(parameter.equals("newsinsert")){//添加新聞
				System.out.println("添加新聞：Opr="+parameter);
				String name = (String)request.getParameter("ntid");
				int s = Integer.parseInt(name);
				String ntitle = request.getParameter("ntitle");
				String nauthor = request.getParameter("nauthor");
				String nsummary = request.getParameter("nsummary");
				String ncontent = request.getParameter("ncontent");
				News news = new News();
				news.setNtid(s);
				news.setNtitle(ntitle);
				news.setNauthor(nauthor);
				news.setNsummary(nsummary);
				news.setNcontent(ncontent);
				int inser = ne.newsInser(news);
				if(inser>=1){
					response.sendRedirect("/news_chapter03/newspages/admin.jsp");
				}else{
					response.sendRedirect("/news_chapter03/newspages/news_add.jsp");
				}
		}
	}
	public void init() throws ServletException {
	}
}
