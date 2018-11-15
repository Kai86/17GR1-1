package org.news.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.news.dao.BaseDao;
import org.news.dao.NewsDao;
import org.news.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    // 获取所有新闻
    public List<News> getAllnews() {
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
                + " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
                + " WHERE `NEWS`.`ntid` = `TOPIC`.`tid`"
                + " ORDER BY `ncreateDate` DESC";
        try {
            rs = this.executeQuery(sql);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getDate("ncreateDate"));
                news.setNsummary(rs.getString("nsummary"));
                news.setNtname(rs.getString("tname"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return list;
    }

    // 获取某主题下的所有新闻
    public List<News> getAllnewsByTID(int tid) {
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
                + " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
                + " WHERE `NEWS`.`ntid` = `TOPIC`.`tid` AND `NEWS`.`ntid` = ?"
                + " ORDER BY `ncreateDate` DESC";
        try {
            rs = this.executeQuery(sql, tid);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getDate("ncreateDate"));
                news.setNsummary(rs.getString("nsummary"));
                news.setNtname(rs.getString("tname"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return list;
    }

    public int getNewsCountByTID(int tid) {
        ResultSet rs = null;
        String sql = "SELECT COUNT(`ntid`) FROM `news` WHERE `ntid` = ?";
        int count = -1;
        try {
            rs = this.executeQuery(sql, tid);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return count;
    }

	@Override
	public int getNewsID(int id) { 
		String sql = "delete from news where nid = ?";
		int executeUpdate = super.executeUpdate(sql, id);
		return executeUpdate;
	}
	
	public int inrsertnews(News news) {
		String sql = "insert into news(ntid,ntitle,nauthor,nsummary,ncreateDate,ncontent,nmodifyDate) " +
					 "values(?,?,?,?,?,?,?)";
		String ncreateDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String nmodifyDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int executeUpdate = super.executeUpdate(sql,news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),ncreateDate,news.getNcontent(),nmodifyDate);
		return executeUpdate;
	}
	public int newsupdate(News news) {
		String sql = "update news set ntid=?,ntitle=?,nauthor=?,nsummary=?,ncreateDate=?,ncontent=?,nmodifyDate=? where nid=?";
		String ncreateDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String nmodifyDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Object[] obj ={}; 
		int executeUpdate = super.executeUpdate(sql,news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),ncreateDate,news.getNcontent(),nmodifyDate,news.getNid());
		return executeUpdate;
	}

	@Override
	public int getNews() {
		  ResultSet rs = null;
	      String sql = "SELECT COUNT(ntid) FROM news";
	      int count = -1;
	      try {
	          rs = this.executeQuery(sql);
	          rs.next();
	          count = rs.getInt(1);
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           closeAll(conn, null, rs);
	       }
	       return count;
	}
	public List<News> getnewsAll(Object[] obj) {
		 List<News> list = new ArrayList<News>();
	        ResultSet rs = null;
	        String sql = "select * from news limit ?,? ";
	        try {
	            rs = this.executeQuery(sql,obj);
	            News news = null;
	            while (rs.next()) {
	                news = new News();
	                news.setNid(rs.getInt("nid"));
	                news.setNtid(rs.getInt("ntid"));
	                news.setNtitle(rs.getString("ntitle"));
	                news.setNauthor(rs.getString("nauthor"));
	                news.setNcreatedate(rs.getDate("ncreateDate"));
	                news.setNsummary(rs.getString("nsummary"));
	                list.add(news);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll(conn, null, rs);
	        }
	        return list;
	    }
	
}
