package com.qiju.game.car.core.state;

import org.apache.log4j.Logger;

/**
 * 
 * @author Qintingyin
 *
 * 2018-4-8
 */
public abstract class BaseState implements Runnable{
	protected Logger logger = Logger.getLogger(BaseState.class);
	public abstract void init();
}
