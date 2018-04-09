/**
 * 
 */
package com.qiju.game.car.core.state;

import com.qiju.game.car.config.ConfigCache;
import com.qiju.game.car.config.bean.ChooseTypes;


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
		ChooseTypes types = ConfigCache.getInstance().getConfig(ChooseTypes.class);
		System.out.println(types.getChooseTypeById(1));
	}

	@Override
	public void run() {
		init();
		logger.info("ReadyState start...");
		StateFactory.changeState(StateFactory.getBetState(), 5);
	}

}
