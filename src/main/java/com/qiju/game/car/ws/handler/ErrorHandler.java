/**
 * 
 */
package com.qiju.game.car.ws.handler;

import com.qiju.game.car.ws.proto.MessageBody;
import com.qiju.game.car.ws.session.IoSession;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class ErrorHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(IoSession session, MessageBody msg) {
		logger.error(msg.toString());
//		ctx.channel().write(MessageFactory.getErrorCode());
	}

}
