package com.qty.netty.decoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class GameServer {
	private ServerBootstrap sbs;

	public void bind(int port) {
		sbs = new ServerBootstrap();
		EventLoopGroup boss = new NioEventLoopGroup(1);
		EventLoopGroup worker = new NioEventLoopGroup();
		sbs.group(boss, worker).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
				.childHandler(new ChildHandler()).handler(new StringDecoder());
		sbs.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator());
		try {
			ChannelFuture future = sbs.bind(port).sync();
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
