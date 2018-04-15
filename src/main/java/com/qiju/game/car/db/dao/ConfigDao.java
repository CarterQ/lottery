package com.qiju.game.car.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qiju.game.car.db.DBManager;

public class ConfigDao {

	public List<String> queryAllChanges() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = DBManager.getInstance().getConnection();
			String sql = "SELECT c_name FROM config where c_change > 0";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public void resetChanges(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getInstance().getConnection();
			String sql = "update config set c_change = 0;";
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, null);
		}
	}
	
	public static void main(String[] args) {
		ConfigDao dao = new ConfigDao();
		System.out.println(dao.queryAllChanges());
	}
}
