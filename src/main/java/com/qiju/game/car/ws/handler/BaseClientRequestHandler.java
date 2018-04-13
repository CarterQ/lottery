/**
 * 
 */
package com.qiju.game.car.ws.handler;

import org.apache.log4j.Logger;

import com.qiju.game.car.ws.proto.MessageBody;
import com.qiju.game.car.ws.session.IoSession;

/**
 * @author Qintingyin
 *
 * 2018-4-2
 */
public abstract class BaseClientRequestHandler {
	protected static final Logger logger = Logger.getLogger(BaseClientRequestHandler.class);
	/**
	 * 玩家操作类handler重写并实现该方法
	 * @param session
	 * @param msg
	 */
	public abstract void handleClientRequest(IoSession session, MessageBody msg);
}
