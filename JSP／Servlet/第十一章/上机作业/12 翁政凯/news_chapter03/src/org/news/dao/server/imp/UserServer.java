package org.news.dao.server.imp;

import java.util.List;
import org.news.entity.News;
import org.news.dao.impl.NewsDaoImpl;
import org.news.dao.impl.UserDaoImpl;
import org.news.dao.server.loginUtil;
import org.news.entity.Page;
import org.news.entity.User;

public class UserServer implements loginUtil{
	UserDaoImpl us = new UserDaoImpl();
	NewsDaoImpl nd = new NewsDaoImpl();
	public User dengLu(String name, String pwd) {
		User findUser = us.findUser(name, pwd);
		return findUser;
	}
}
