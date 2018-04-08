/**
 * 
 */
package com.qiju.game.car.core.state;


/**
 * 下注阶段
 * @author Qintingyin
 *
 * 2018-4-8
 */
public class BetState extends BaseState {
	@Override
	public void init() {
		logger.info("BetState init....");
	}

	@Override
	public void run() {
		init();
		logger.info("BetState start...");
		StateFactory.changeState(StateFactory.getLotteryState(), 20);
	}

}
