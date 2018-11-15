package org.news.dao.server.imp;

import java.util.List;

import org.news.dao.NewsDao;
import org.news.dao.impl.NewsDaoImpl;
import org.news.dao.impl.TopicsDaoImpl;
import org.news.dao.server.TopicUtil;
import org.news.entity.Topic;

public class TopicServer implements TopicUtil{

	TopicsDaoImpl tp = new TopicsDaoImpl();
	NewsDaoImpl nes = new NewsDaoImpl();
	
	public int topicUpdate(int tid, String tname) {
		Topic topic = tp.findTopicByName(tname);
		if (topic != null) {
			return 0;
		} else {
			topic = new Topic();
			topic.setTid(tid);
			topic.setTname(tname);
			int f = tp.updateTopic(topic);
			return f;
		}
	}
	public int topicDelete(int tid) {
		int g = nes.getNewsCountByTID(tid);
		if(g>=1){
			return 0;
		}else{
			int s = tp.deleteTopic(tid);
			return s;
		}
	}
	public int topicInser(String tname) {
		Topic topic = tp.findTopicByName(tname);
		if(topic != null){
			return 0;
		}else{
			int addTopic = tp.addTopic(tname);
			return addTopic;
		}
	}
	public List<Topic> topicSelect() {
		List<Topic> allTopics = tp.getAllTopics();
		return allTopics;
	}
}
