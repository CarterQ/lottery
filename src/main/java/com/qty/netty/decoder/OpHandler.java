package com.qty.netty.decoder;

import com.alibaba.fastjson.JSONObject;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class OpHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("-------channelRead------");
		System.out.println("server:"+msg.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("123","321");
		for(int i=0;i<100;i++){
			ByteBuf buf = Unpooled.copiedBuffer(jsonObject.toJSONString().getBytes());
			ctx.writeAndFlush(buf);
		}
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("----------channelActive-------");
	}
	
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
}
