package com.qiju.game.car.config;

import com.qiju.game.car.config.bean.ChooseType;
@SuppressWarnings("rawtypes")
public enum ConfigType {
	ChooseType("chooseType",ChooseType.class);
	String name;
	Class clazz;
	ConfigType(String name,Class clazz){
		this.name = name();
		this.clazz = clazz;
	}
}
