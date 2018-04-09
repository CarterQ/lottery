/**
 * 
 */
package com.qiju.game.car.economy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.qiju.game.car.economy.bean.MoneyHandleResult;

/**
 * @author Qintingyin
 *
 * 2018-4-9
 */
public class VasServiceProxy {
	private Map<Integer, BaseVasService> map = new HashMap<Integer, BaseVasService>();
	
	/**
	 * 获取玩家余额
	 * @param site
	 * @param userId
	 * @return
	 */
	public long getUserGameMoney(int site,long userId){
		return map.get(site).getUserGameMoney(site, userId);
	}
	/**
	 * 给玩家加减币
	 * @param roundID 局ID
	 * @param counter 事务ID
	 * @param site 用户来源
	 * @param userId
	 * @param money
	 * @param oemId
	 * @return
	 */
	public MoneyHandleResult addAndSubtractUserMoney(
			long roundID,int counter,int site,long userId,BigDecimal money,int oemId){
		return null;
	}
}
