package com.qiju.game.car.ws.session;

import java.util.concurrent.ConcurrentHashMap;

import com.qiju.game.car.core.bean.Player;


/**
 * 
 * 管理所有已登录session信息
 * @author Qintingyin
 *
 * 2018-4-12
 */
public class SessionManager {
	/**
	 * (playerId,session)
	 */
	private ConcurrentHashMap<Long, IoSession> map = new ConcurrentHashMap<Long, IoSession>();
	/**
	 * 根据用户ID获取Session
	 * @param playerId
	 * @return
	 */
	public IoSession getSession(Long playerId){
		return map.get(playerId);
	}
	/**
	 * 标记用户登录状态,记录session
	 * @param session
	 * @param player
	 */
	public void playerLogin(IoSession session,Player player){
		session.userLogin(player);
		map.put(player.getId(), session);
	}
	
	/**
	 * 用户退出,连接断开,连接异常时调用
	 * @param session
	 */
	public void playerLogout(IoSession session){
		map.remove(session);
	}
	
}
