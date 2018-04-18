package com.qiju.game.car.core.manager;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.qiju.game.car.core.bean.Player;


/**
 * @author Qintingyin
 * 
 *         2018-4-10
 */
public class PlayerManager {
	private static final Logger logger = Logger.getLogger(PlayerManager.class);
	private ConcurrentHashMap<Long, Player> players = new ConcurrentHashMap<Long, Player>();
	public Player getPlayer(long id){
		Player player = players.get(id);
		return player;
	}
	
}
