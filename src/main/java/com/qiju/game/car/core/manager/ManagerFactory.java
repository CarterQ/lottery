package com.qiju.game.car.core.manager;

/**
 * @author Qintingyin
 *
 * 2018-4-10
 */
public class ManagerFactory {
	private static PlayerManager playerManager = new PlayerManager();
	public static PlayerManager getPlayerManager(){
		return playerManager;
	}
}
