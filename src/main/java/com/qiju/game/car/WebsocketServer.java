package com.qiju.game.car;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import org.apache.log4j.Logger;

import com.qiju.game.car.constant.Constant;
import com.qiju.game.car.ws.channel.WebSocketServerHandler;
import com.qiju.game.car.ws.handler.HandlerFactory;
import com.qiju.game.car.ws.handler.LoginHandler;

public class WebsocketServer {
	private static final Logger logger = Logger
			.getLogger(WebsocketServer.class);

	public static void main(String[] args) throws InterruptedException {
		int port = 8888;
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch)
								throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							pipeline.addLast("http-codec",
									new HttpServerCodec());
							pipeline.addLast("aggregator",
									new HttpObjectAggregator(65536));
							// pipeline.addLast("http-chunked", new
							// ChunkedWriteHandler());
							pipeline.addLast("handler",
									new WebSocketServerHandler());
						}
					});
			logger.info("Web socket server started at port " + 8888 + '.');
			Channel ch = b.bind(port).sync().channel();

			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public void startServer(int port) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch)
								throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							pipeline.addLast("http-codec",
									new HttpServerCodec());
							pipeline.addLast("aggregator",
									new HttpObjectAggregator(65536));
							// pipeline.addLast("http-chunked", new
							// ChunkedWriteHandler());
							pipeline.addLast("handler",
									new WebSocketServerHandler());
						}
					});
			b.option(ChannelOption.RCVBUF_ALLOCATOR,new AdaptiveRecvByteBufAllocator());
			logger.info("Web socket server started at port " + port + '.');
			Channel ch = b.bind(port).sync().channel();
			ch.closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("error at startServer...", e);
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}

	}

}
