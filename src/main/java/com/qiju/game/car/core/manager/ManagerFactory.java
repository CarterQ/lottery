package com.qiju.game.car.core.manager;

import com.qiju.game.car.db.DBManager;
import com.qiju.game.car.ws.session.SessionManager;

/**
 * includes: <br>
 * {@link SessionManager}<br>
 * {@link PlayerManager}<br>
 * {@link DBManager}<br>
 * 
 * @author Qintingyin
 * 
 *         2018-4-10
 */
public class ManagerFactory {
	private static PlayerManager playerManager = new PlayerManager();
	private static SessionManager sessionManager = new SessionManager();
	private static DBManager dbManager = DBManager.getInstance();

	public static PlayerManager getPlayerManager() {
		return playerManager;
	}

	public static SessionManager getSessionManager() {
		return sessionManager;
	}

	public static DBManager getDBManager() {
		return dbManager;
	}
}
