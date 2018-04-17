package com.qiju.game.car.core.manager;

import java.util.concurrent.atomic.AtomicLongArray;

import org.apache.log4j.Logger;

/**
 * 下注管理
 * @author qintingyin
 *
 */
public class BetManager {
	private static final Logger logger = Logger.getLogger(BetManager.class);
	public void bet(long playerId,int chooseType,int moneyIndex){
		//TODO:玩家从playerManager中获取
		
	}
	
	public AtomicLongArray getAllBets(){
		//TODO:获取所有下注区下注金额
		return null;
	}
	
	public AtomicLongArray getNpcBets(){
		//TODO:获取所有下注区NPC下注金额
		return null;
	}
	
	public long getSumBets(){
		//TODO:获取下注总额
		return 0;
	}
}
