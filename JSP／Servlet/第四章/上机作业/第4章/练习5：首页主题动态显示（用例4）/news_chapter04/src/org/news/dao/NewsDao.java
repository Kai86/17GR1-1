﻿package org.news.dao;

import java.util.List;

import org.news.entity.News;

public interface NewsDao {
    // 获取所有新闻
    public List<News> getAllnews();
    // 获取某主题下的所有新闻（根据主题id）
    public List<News> getAllnewsByTID(int Tid);
    // 获取某主题下的所有新闻（根据主题名称）
    public List<News> getAllnewsByTname(String tname);
    // 获取某主题下的新闻数量
    public int getNewsCountByTID(int Tid);
    // 获取某主题下的最新新闻
    public List<News> getLatestNewsByTID(int tid, int limit);
}