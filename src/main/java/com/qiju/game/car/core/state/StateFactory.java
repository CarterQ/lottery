package com.qiju.game.car.core.state;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StateFactory {

	/** 预期执行任务的线程池 **/
	private static final ScheduledExecutorService scheduleService = Executors
			.newScheduledThreadPool(1);

	/** 游戏押注状态 **/
	private static BetState betState = new BetState();

	/** 游戏准备开始状态 **/
	private static ReadyState readyState = new ReadyState();

	/** 开奖状态 **/
	private static LotteryState lotteryState = new LotteryState();

	public static BetState getBetState() {
		return betState;
	}

	public static ReadyState getReadyState() {
		return readyState;
	}

	public static ScheduledExecutorService getScheduleservice() {
		return scheduleService;
	}

	public static LotteryState getLotteryState() {
		return lotteryState;
	}
	public static void changeState(BaseState state,int time){
		scheduleService.schedule(state, time, TimeUnit.SECONDS);
	}
	public static void startGame(){
		scheduleService.schedule(readyState, 0, TimeUnit.SECONDS);
	}

}
