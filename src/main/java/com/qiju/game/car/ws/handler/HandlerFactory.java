/**
 * 
 */
package com.qiju.game.car.ws.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.qiju.game.car.constant.CmdConstant;
import com.qiju.game.car.constant.Constant;

/**
 * handler工厂,根据消息类型提供对应handler
 * @author Qintingyin
 *
 * 2018-4-2
 */
public class HandlerFactory {
	private final Map<String, BaseClientRequestHandler> cachedHandlers = new ConcurrentHashMap<String, BaseClientRequestHandler>();
	private HandlerFactory(){
		addHandler(CmdConstant.USER_LOGIN,new LoginHandler());
		addHandler(Constant.ERROR,new ErrorHandler());
		addHandler(CmdConstant.USER_LOGOUT, new LogoutHandler());
		addHandler(CmdConstant.USER_BET, new BetHandler());
		addHandler(CmdConstant.USER_REQ_MASTER, new UpMasterHandler());
		addHandler(CmdConstant.USER_QUIT_MASTER, new QuitMasterHandler());
	}
	private static HandlerFactory instance = new HandlerFactory();
	public static HandlerFactory getInstance(){
		return instance;
	}
	public void addHandler(String name,BaseClientRequestHandler handler){
		this.cachedHandlers.put(name, handler);
	}
	
	public BaseClientRequestHandler findHandler(String name){
		BaseClientRequestHandler handler = this.cachedHandlers.get(name);
		if(handler==null){
			//客户端发出的错误请求,统一交给Constant.ERROR对应的handler处理
			handler = this.cachedHandlers.get(Constant.ERROR);
		}
		return handler;
	}
}
