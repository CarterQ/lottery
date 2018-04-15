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
 * 连接池管理，负责连接池初始化，数据库连接的获取
 * @author qintingyin 2018年3月31日
 */
public class DBManager {
	private static DBManager instance = new DBManager();
	private static final Logger logger = Logger.getLogger(DBManager.class);
	private DataSource dataSource;

	public static DBManager getInstance() {
		return instance;
	}

	private DBManager() {
		init();
	}

	public void init() {
		Properties pr = new Properties();
		try {
			pr.load(DBManager.class.getClassLoader().getResourceAsStream("druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(pr);
		} catch (Exception e) {
			logger.error("error at init dbmanager...", e);
		}

	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (SQLException e) {
			logger.error("error at close...", e);
		}

	}
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getInstance().getConnection();
			String sql = "SELECT * FROM role";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("rid") + " " + rs.getString("rname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
	}
}
