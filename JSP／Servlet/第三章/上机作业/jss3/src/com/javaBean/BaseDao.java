package com.javaBean;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import com.mysql.jdbc.Driver;
/**
 * @author ��
 *	���ݿ��������
 */
public class BaseDao {
	public static String url;//�������ݿ⡣
	public static String driver; //����������
	public static String name;//���ݿ��û�����
	public static String password;//���ݿ������롣
	//��̬����飬����ͬ�¼��ء�
	static{
		//����Properties����
		Properties po = new Properties();
		//ʹ���������������kai.properties�ļ�������IO�쳣
		InputStream io = BaseDao.class.getClassLoader().getResourceAsStream("kai.properties");
		try {
			//ʹ��load������ȡkai.properties�ļ���
			if(po!=null){
				po.load(io);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		//��������
		driver=po.getProperty("Stringdriver");
		//�������ݿ�
		url=po.getProperty("Stringurl");
		//���ݿ��û���
		name=po.getProperty("Stringname");
		//���ݿ�����
		password=po.getProperty("Stringpassword");
	}
	//������������ȡ���ӵķ�����
	public static Connection quDong() {
		Connection connection = null;
		//����������쳣�쳣
		try {
			//��������
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//�������ݿ�
			connection = DriverManager.getConnection(url, name, password);
//			String sql = null;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return connection;
	}
	
	//�ر����������ӺͲ�ѯ��� �ķ���
	public static void colseall(Connection connection,PreparedStatement ps,ResultSet rs){
		//����SQL�쳣
		try {
			//if�ж��Ƿ�Ϊ�գ���Ϊ��ʱ�ر����Ӻ�����
			if(connection!=null){
				connection.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//���µķ�����sql��ִ�е�mysql��䣬obj[]��ִ��mysql����������������Ӱ���������
	public int update(String sql,Object[] obj) {
		//�õ����ݿ�
		Connection conne = quDong();
		//ͳ��Ӱ���������
		int executeUpdate = 0;
		//Ԥ���룬��ֹSQLע�롣
		PreparedStatement ps = null;
		try {
			//�õ�PreparedStatement����
			ps = conne.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject((i+1), obj[i]);
			}
			//ִ��SQL��䣬����executeUpdate
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return Ӱ���������
		return executeUpdate;
	}
	
	public static ArrayList<User> selectUser(){
		ArrayList<User> al = new ArrayList<User>();
		Connection quDong = quDong();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "select uname,upwd from news_users";
			 ps = quDong.prepareStatement(sql);
			 rs= ps.executeQuery(sql);
			User user = null;
			while(rs.next()){
				user = new User(rs.getString(1), rs.getString(2));
				System.out.println(user.getName()+user.getPassword());
			}
			al.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		colseall(quDong , ps , rs);
 		return al;
	}
	public static void main(String[] args) {
		BaseDao sb = new BaseDao();
		ArrayList<User> selectUser = sb.selectUser();
		for (int i = 0; i < selectUser.size(); i++) {
			User user = selectUser.get(i);
			System.out.println(user.getName());
		}
	}
}
