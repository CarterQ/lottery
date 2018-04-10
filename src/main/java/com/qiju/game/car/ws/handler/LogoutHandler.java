/**
 * 
 */
package com.qiju.game.car.ws.handler;

import io.netty.channel.ChannelHandlerContext;

import com.qiju.game.car.core.manager.ManagerFactory;
import com.qiju.game.car.ws.proto.MessageBody;

/**
 * @author Qintingyin
 *
 * 2018-4-10
 */
public class LogoutHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(ChannelHandlerContext ctx, MessageBody msg) {
		if(msg==null){
			//玩家断线
			ManagerFactory.getPlayerManager().userLogout(ctx.channel().id().asShortText());
		}
	}

}
