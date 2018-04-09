package com.qiju.game.car.ws.handler;

import io.netty.channel.ChannelHandlerContext;

import com.qiju.game.car.ws.proto.MessageBody;
import com.qiju.game.car.ws.proto.MessageFactory;

/**
 * @author Qintingyin
 * 
 *         2018-4-2
 */
public class LoginHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(ChannelHandlerContext ctx, MessageBody msg) {
		logger.info("handleClientRequest:"+msg.toString());
		
		ctx.channel().write(MessageFactory.getSuccessMsg(msg.getOP()));
		
	}

}
