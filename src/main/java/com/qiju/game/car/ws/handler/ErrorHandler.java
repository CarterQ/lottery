/**
 * 
 */
package com.qiju.game.car.ws.handler;

import com.qiju.game.car.ws.proto.MessageBody;
import com.qiju.game.car.ws.proto.MessageFactory;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class ErrorHandler extends BaseClientRequestHandler {
	
	@Override
	public void handleClientRequest(ChannelHandlerContext ctx, MessageBody msg) {
		logger.error(msg.toString());
		ctx.channel().write(MessageFactory.getErrorCode());
	}

}
