package org.news.dao.server.imp;

import java.util.List;

import org.news.dao.impl.NewsDaoImpl;
import org.news.dao.server.NewsUtil;
import org.news.entity.News;
import org.news.entity.Page;

public class NewsServer implements NewsUtil{
	NewsDaoImpl ns = new NewsDaoImpl();
	//更新新闻
	public int newsUpdate(News news) {
		int f = ns.newsupdate(news);
		if(f == 0){
			return 0;
		}else{
			return f;
		}
	}
	//删除新闻
	public int newsDelete(int tid) {
		int f = ns.getNewsID(tid);
		if(f == 0){
			return 0;
		}else{
			return f;
		}
	}
	//添加新闻
	public int newsInser(News news) {
		int f = ns.inrsertnews(news);
		if(f == 0){
			return 0;
		}else{
			return f;
		}
	}
	//查询所有新闻
	public List<News> newsSelect() {
		return null;
	}
	//查询主题下所有新闻
	public List<News> news_Topic_Select(int tid) {
		List<News> allnewsByTID = ns.getAllnewsByTID(tid);
		return allnewsByTID;
	}
	public List<News> pageyumian(int pageInt){
		Page pa = new Page();
		int yeshu = 0;
		if(pageInt==0){
			yeshu=1;
		}else{
			yeshu = pageInt;
		}
		pa.setCurrPageNo(yeshu);//Set当前页数
		int news = ns.getNews();
		pa.setTotalCount(news);//set总条数
		int s = pa.getTotalCount()/pa.getPageSize();//获取总页数
		if(pa.getTotalCount()%pa.getPageSize()==0){
			pa.setTotalPageCount(s);//set总页数
		}else{
			pa.setTotalPageCount(s+1);//set总页数
		}
		Object[] obj = {(pa.getCurrPageNo()-1)*pa.getPageSize(),pa.getPageSize()}; 
		List<News> list =  ns.getnewsAll(obj);
		System.out.println("当前页数:"+pa.getCurrPageNo());
		System.out.println("每页条数:"+pa.getPageSize());
		System.out.println("总条数:"+pa.getTotalCount());
		System.out.println("总页数:"+pa.getTotalPageCount());
		return list;
	}
}
