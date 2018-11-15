package org.news.dao;

import java.util.List;

import org.news.entity.News;

public interface NewsDao{
	//获取所有新闻
	public List<News> getAllnews();	
	//获取某主题下的所有新闻
	public List<News> getAllnewsByTID(int Tid);	
	//获取某主题下的新闻数量
	public int getNewsCountByTID(int Tid);
	//删除的方法。
	public int getNewsID(int id);
	//新增新闻
	public int inrsertnews(News news);
	//更新新闻
	public int newsupdate(News news);
	//获取新闻数量。
	public int getNews();
	//获取当前页的新闻。
	public  List<News> getnewsAll(Object[] obj);	
}