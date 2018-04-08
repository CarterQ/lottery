/**
 * 
 */
package com.qiju.game.car.core.state;


/**
 * 准备阶段
 * @author Qintingyin
 *
 * 2018-4-8
 */
public class ReadyState extends BaseState {
	@Override
	public void init() {
		logger.info("ReadyState init....");
	}

	@Override
	public void run() {
		init();
		logger.info("ReadyState start...");
		StateFactory.changeState(StateFactory.getBetState(), 5);
	}

}
