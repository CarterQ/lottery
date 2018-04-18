/**
 * 
 */
package com.qiju.game.car.core.state;

import com.qiju.game.car.core.bean.Player;
import com.qiju.game.car.core.manager.ManagerFactory;
import com.qiju.game.car.ws.session.IoSession;



/**
 * 准备阶段
 * @author Qintingyin
 *
 * 2018-4-8
 */
public class ReadyState extends BaseState {
	@Override
	public void init() {
		long id = ManagerFactory.getMasterManager().getMaster();
		Player player = ManagerFactory.getPlayerManager().getPlayer(id);
		if(id<0){
			//TODO:当前庄为空,首次开启时出现
		}
		IoSession session = ManagerFactory.getSessionManager().getSession(id);
		if(session==null){
			//TODO:玩家断开连接
		}
		
		
	}

	@Override
	public void run() {
		init();
		StateFactory.changeState(StateFactory.getBetState(), 5);
	}

}
