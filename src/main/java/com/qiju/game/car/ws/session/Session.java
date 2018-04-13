package com.qiju.game.car.ws.session;

import com.qiju.game.car.core.bean.Player;

import io.netty.channel.Channel;

public class Session implements IoSession{
	private Channel channel;
	private Player player = null;
	public Session(Channel channel) {
		this.channel = channel;
	}
	@Override
	public Channel getConnect() {
		return channel;
	}
	@Override
	public boolean hasLogin() {
		return player != null;
	}
	@Override
	public Player getPlayer() {
		return player;
	}
	@Override
	public void userLogin(Player player) {
		this.player = player;
	}
}
