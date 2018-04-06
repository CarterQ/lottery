package com.qiju.game.car.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @author qintingyin 2018年3月31日
 */
public class DBManager {
	private static DBManager instance = new DBManager();
	private static final Logger logger = Logger.getLogger(DBManager.class);
	private DataSource dataSource;
	public static DBManager getInstance(){
		return instance;
	}
	private DBManager(){
		init();
	}
	public void init(){
		Properties pr = new Properties();
		try {
			pr.load(DBManager.class.getClassLoader().getResourceAsStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(pr);
		} catch (Exception e) {
			logger.error("error at init dbmanager...", e);
		}
	
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBManager.getInstance().getConnection();
	        //2,执行数据库语句
	        String sql="SELECT * FROM role";
	        PreparedStatement ps=conn.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        while (rs.next()) {
	            System.out.println(rs.getInt("rid")+" "+rs.getString("rname"));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
