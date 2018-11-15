package org.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.news.dao.BaseDao;
import org.news.dao.TopicsDao;
import org.news.entity.Topic;

public class TopicsDaoImpl extends BaseDao implements TopicsDao {
    public List<Topic> getAllTopics() {
        List<Topic> list = new ArrayList<Topic>();
        ResultSet rs = null;
        // 获取所有主题
        String sql = "select * from topic";
        try {
            rs = executeQuery(sql);
            Topic topic = null;
            while (rs.next()) {
                topic = new Topic();
                topic.setTid(rs.getInt("tid"));
                topic.setTname(rs.getString("tname"));
                list.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return list;
    }
    
    public int deleteTopic(int tid) {
        int result = 0;
        String sql = "DELETE FROM `TOPIC` WHERE `tid` = ?";
        try {
            result = executeUpdate(sql, tid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, null);
        }
        return result;
    }

    public int updateTopic(Topic topic) {
        String sql = "UPDATE `TOPIC` SET `tname` = ? WHERE `tid` = ?";
        int result = 0;
        try {
            result = executeUpdate(sql, topic.getTname(), topic.getTid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, null);
        }
        return result;
    }

    public Topic findTopicByName(String name) {
        String sql = "select * from topic where tname=?";
        ResultSet rs = null;
        Topic topic = null;
        try {
            rs = executeQuery(sql, name);
            if (rs.next()) {
                topic = new Topic();
                topic.setTid(rs.getInt("tid"));
                topic.setTname(rs.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return topic;
    }

    public int addTopic(String name) {
        String sql = "insert into topic(TNAME) values(?)";
        int result = 0;
        try {
            result = executeUpdate(sql, name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, null);
        }
        return result;
    }
}
