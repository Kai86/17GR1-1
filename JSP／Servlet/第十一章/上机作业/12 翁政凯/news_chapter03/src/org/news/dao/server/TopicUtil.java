package org.news.dao.server;
import java.util.List;

import org.news.entity.Topic;

public interface TopicUtil {
	//更新主题
	public int topicUpdate(int tid,String tname);
	//删除主题
	public int topicDelete(int tid);
	//添加主题
	public int topicInser(String tname);
	//查询主题
	public List<Topic> topicSelect();
}
