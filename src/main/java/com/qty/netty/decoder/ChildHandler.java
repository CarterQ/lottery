package com.qty.netty.decoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class ChildHandler extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new CustomEncoder());
		ch.pipeline().addLast(new StringDecoder());
		ch.pipeline().addLast(new OpHandler());
	}

}
