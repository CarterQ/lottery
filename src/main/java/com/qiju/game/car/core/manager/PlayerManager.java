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
	private ConcurrentHashMap<String, Player> playerConns = new ConcurrentHashMap<String, Player>();

	public void userLogin(Player player) {
		if (player.getConnect() != null) {
			playerConns.put(player.getConnect().id().asShortText(), player);
			players.put(player.getId(), player);
			logger.info("user login id:"+player.getId()+",channelId:"+player.getConnect().id().asShortText());
		}
	}

	public void userLogout(Player player) {
		if (players.contains(player)) {
			players.remove(player.getId());
		}
		if (player.getConnect() != null
				&& playerConns.contains(player)) {
			playerConns.remove(player.getConnect().id().asShortText());
		}
		logger.info("user userLogout id:"+player.getId()+",channelId:"+player.getConnect().id().asShortText());
	}

	public boolean hasLogin(String channelId) {
		if (playerConns.get(channelId)!=null
				&& channelId.equals(playerConns.get(channelId).getConnect()
						.id().asShortText())) {
			return true;
		}
		return false;
	}
	
	public void userLogout(String channelId){
		Player player = playerConns.get(channelId);
		if(player!=null){
			players.remove(player.getId());
			playerConns.remove(channelId);
			logger.info("user userLogout id:"+player.getId()+",channelId:"+channelId);
		}
	}
}
