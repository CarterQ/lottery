/**
 * 
 */
package com.qiju.game.car.economy;

import java.math.BigDecimal;

import com.qiju.game.car.economy.bean.MoneyHandleResult;


/**
 * @author Qintingyin
 *
 * 2018-4-9
 */
public abstract class BaseVasService {
	public abstract int getSiteId();
	/**
	 * 获取玩家余额
	 * @param site
	 * @param userId
	 * @return
	 */
	public abstract long getUserGameMoney(int site,long userId);
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
	public abstract MoneyHandleResult addAndSubtractUserMoney(
			long roundID,int counter,int site,long userId,BigDecimal money,int oemId);
	
}
