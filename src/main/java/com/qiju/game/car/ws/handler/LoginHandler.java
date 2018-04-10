package com.qiju.game.car.ws.handler;


import io.netty.channel.ChannelHandlerContext;

import com.qiju.game.car.core.bean.Player;
import com.qiju.game.car.core.manager.ManagerFactory;
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
		
		Player player = new Player(0,1);
		player.setConnect(ctx.channel());
		ManagerFactory.getPlayerManager().userLogin(player);
		ctx.channel().write(MessageFactory.getSuccessMsg(msg.getOP()));
	}

}
