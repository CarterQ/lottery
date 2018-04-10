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
	}

	@Override
	public void run() {
		init();
		StateFactory.changeState(StateFactory.getBetState(), 5);
	}

}
