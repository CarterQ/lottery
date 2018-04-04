/**
 * 
 */
package com.qiju.game.car.ws.channel;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Qintingyin
 *
 * 2018-4-2
 */
public class ChannelHolder {
	public final static ConcurrentHashMap<String, Channel> channels = new ConcurrentHashMap<String, Channel>();
	static{
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					for(Channel channel:channels.values()){
						channel.writeAndFlush(new TextWebSocketFrame("测试中,你的ID是:"+channel.id().asShortText()));
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
