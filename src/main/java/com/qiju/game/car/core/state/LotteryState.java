/**
 * 
 */
package com.qiju.game.car.core.state;

import java.util.Map;
import java.util.Random;

import com.qiju.game.car.config.ConfigCache;
import com.qiju.game.car.config.bean.ChooseType;
import com.qiju.game.car.config.bean.ChooseTypes;

/**
 * 开奖并且公布结果
 * 
 * @author Qintingyin
 * 
 *         2018-4-8
 */
public class LotteryState extends BaseState {
	@Override
	public void init() {
		logger.info("LotteryState init....");
	}

	@Override
	public void run() {
		init();
		logger.info("LotteryState start...");
		int choose = getChooseType();
		logger.info("开奖结果:"
				+ ConfigCache.getInstance().getConfig(ChooseTypes.class)
						.getChooseTypeById(choose).getName());
		StateFactory.changeState(StateFactory.getReadyState(), 20);
	}

	/** 随机开奖 **/
	private int getChooseType() {
		Map<Integer, ChooseType> map = ConfigCache.getInstance()
				.getConfig(ChooseTypes.class).getChooseTypes();
		Random rSeed = new Random();
		long seed = rSeed.nextLong() * rSeed.hashCode();
		int random = new Random(seed).nextInt(100) + 1;
		int sum = 0;
		int result = 0;
		for (int key : map.keySet()) {
			ChooseType choose = map.get(key);
			sum += choose.getRatio();
			if (sum >= random) {
				result = choose.getId();
				break;
			}
		}
		return result;
	}
}
