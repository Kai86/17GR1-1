package org.news.dao.server;

import java.util.List;
import org.news.entity.News;
import org.news.entity.User;

public interface loginUtil {
	//登录的方法
	public User dengLu(String name,String pwd);
}
