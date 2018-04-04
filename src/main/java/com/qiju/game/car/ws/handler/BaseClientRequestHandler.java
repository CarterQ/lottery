/**
 * 
 */
package com.qiju.game.car.ws.handler;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.qiju.game.car.ws.proto.MessageBody;

/**
 * @author Qintingyin
 *
 * 2018-4-2
 */
public abstract class BaseClientRequestHandler {
	protected static final Logger logger = Logger.getLogger(BaseClientRequestHandler.class);
	public abstract void handleClientRequest(ChannelHandlerContext ctx, MessageBody msg);
}
