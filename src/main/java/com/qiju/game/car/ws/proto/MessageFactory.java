package com.qiju.game.car.ws.proto;

import com.qiju.game.car.constant.CmdConstant;
import com.qiju.game.car.constant.Constant;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class MessageFactory {
	/**
	 * @return 指令解析错误消息
	 */
	public static TextWebSocketFrame getErrorCode(){
		MessageBody body = new MessageBody();
		body.setOP(Constant.ERROR);
		return body.build();
	}
	/**
	 * @param op 当前操作指令ID
	 * @return 操作成功
	 */
	public static TextWebSocketFrame getSuccessMsg(String op){
		MessageBody body = new MessageBody();
		body.setOP(op);
		body.setStat(Constant.SUCCESS);
		return body.build();
	}
	/**
	 * 
	 * @param op 当前操作指令ID
	 * @param msg 错误信息
	 * @return
	 */
	public static TextWebSocketFrame getFailMsg(String op,String msg){
		MessageBody body = new MessageBody();
		body.setOP(op);
		body.setStat(Constant.FAIL);
		return body.build();
	}
	
	/**
	 * @param state 游戏状态
	 * @return
	 */
	public static TextWebSocketFrame getGameStateChangeMsg(int state){
		MessageBody body = new MessageBody();
		body.setOP(CmdConstant.GAME_STATE);
		body.setParam(state);
		return body.build();
	}
}
