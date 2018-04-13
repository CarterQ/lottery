package com.qiju.game.car.ws.session;

import com.qiju.game.car.core.bean.Player;

import io.netty.channel.Channel;

/**
 * 玩家session信息,连接player与channel
 * @author Qintingyin
 *
 * 2018-4-12
 */
public interface IoSession {
	/**
	 * 获取channel
	 * @return
	 */
	public Channel getConnect();
	/**
	 * 该连接是否已经完成登录操作
	 * @return
	 */
	public boolean hasLogin();
	/**
	 * 获取玩家信息
	 * @return
	 */
	public Player getPlayer();
	/**
	 * 标记玩家登陆状态
	 * @param player
	 */
	public void userLogin(Player player);
	
}
