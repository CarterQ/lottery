package com.qiju.game.car.ws.proto;

import java.util.Iterator;

import com.qiju.game.car.core.manager.ManagerFactory;
import com.qiju.game.car.ws.session.IoSession;

/**
 * @author Qintingyin
 * 
 *         2018-4-12
 */
public class MessageSender {
	
	/**
	 * 玩家操作回包时调用
	 * @param session
	 * @param body
	 */
	public static void response(IoSession session, MessageBody body) {
		session.getConnect().write(body.build());
	}
	/**
	 * 给所有在线用户发送消息
	 * @param body
	 */
	public static void sendToAll(MessageBody body){
		Iterator<IoSession> iterator = ManagerFactory.getSessionManager().getAllSession();
		if(iterator.hasNext()){
			iterator.next().getConnect().write(body.build());
		}
	
	}
}
