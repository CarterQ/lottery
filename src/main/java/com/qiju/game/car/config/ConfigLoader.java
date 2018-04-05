package com.qiju.game.car.config;

import org.apache.log4j.Logger;

import com.qiju.game.car.constant.Constant;

/**
 * @author qintingyin
 * 2018年3月30日
 */
public abstract class ConfigLoader {
	protected static final Logger logger = Logger.getLogger(ConfigLoader.class);
	protected String dir = Constant.BASE_DIR + "config/";
	public abstract void load();
	public abstract String getName();
}
