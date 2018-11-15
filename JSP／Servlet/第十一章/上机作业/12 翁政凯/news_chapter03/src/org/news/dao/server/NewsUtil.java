package org.news.dao.server;
import java.util.Date;
import java.util.List;

import org.news.entity.Comment;
import org.news.entity.News;

public interface NewsUtil {
	//更新新闻
	public int newsUpdate(News news);
	//删除新闻
	public int newsDelete(int tid);
	//添加新闻
	public int newsInser(News news);
	//查询新闻
	public List<News> newsSelect();
	//根据ID查询新闻
	public List<News> news_Topic_Select(int tid);
	//分页的方法
	public List<News> pageyumian(int pageInt);
}
