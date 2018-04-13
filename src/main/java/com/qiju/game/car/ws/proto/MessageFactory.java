package com.qiju.game.car.ws.proto;

import com.qiju.game.car.constant.Constant;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class MessageFactory {
	/**
	 * @return 指令解析错误消息
	 */
	public static MessageBody getErrorCode(){
		MessageBody body = new MessageBody();
		body.setOP(Constant.ERROR);
		return body;
	}
	/**
	 * @param op 当前操作指令ID
	 * @return 操作成功
	 */
	public static MessageBody getSuccessMsg(String op){
		MessageBody body = new MessageBody();
		body.setOP(op);
		body.setStat(Constant.SUCCESS);
		return body;
	}
	/**
	 * 
	 * @param op 当前操作指令ID
	 * @param msg 错误信息
	 * @return
	 */
	public static MessageBody getFailMsg(String op,String msg){
		MessageBody body = new MessageBody();
		body.setOP(op);
		body.setStat(Constant.FAIL);
		return body;
	}
	
	public static MessageBody newMessageBody(String op){
		MessageBody body = new MessageBody();
		body.setOP(op);
		return body; 
	}
}
