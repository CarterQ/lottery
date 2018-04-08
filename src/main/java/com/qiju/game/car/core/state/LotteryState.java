/**
 * 
 */
package com.qiju.game.car.core.state;


/**
 * 开奖并且公布结果
 * @author Qintingyin
 *
 * 2018-4-8
 */
public class LotteryState extends BaseState{
	@Override
	public void init() {
		logger.info("LotteryState init....");
	}

	@Override
	public void run() {
		init();
		logger.info("LotteryState start...");
		StateFactory.changeState(StateFactory.getReadyState(), 20);
	}

}
