package com.qiju.game.car.ws.proto;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import com.alibaba.fastjson.JSONObject;
import com.qiju.game.car.constant.Constant;

/**
 * @author Qintingyin
 *
 * 2018-4-3
 */
public class MessageBody{
	private JSONObject ob;
	public MessageBody(JSONObject ob){
		this.ob = ob;
	}
	public MessageBody(){
		this.ob = new JSONObject();
	}
	/**
	 * @return 获取指令ID
	 */
	public String getOP(){
		return this.ob.getString(Constant.OPTION);
	}
	/**
	 * @param op 指令ID
	 */
	public void setOP(String op){
		this.ob.put(Constant.OPTION, op);
	}
	/**
	 * @param stat 指令执行状态
	 */
	public void setStat(String stat){
		this.ob.put(Constant.STAT, stat);
	}
	
	/**
	 * @param stat 指令执行状态
	 */
	public void setParam(Object value){
		this.ob.put(Constant.VALUE, value);
	}
	
	public void put(String key,Object value){
		this.ob.put(key, value);
	}
	
	public TextWebSocketFrame build(){
		return new TextWebSocketFrame(this.ob.toJSONString());
	}
}
