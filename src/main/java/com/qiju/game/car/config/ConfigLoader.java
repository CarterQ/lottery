package com.qiju.game.car.config;

import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * @author qintingyin
 * 2018年3月30日
 */
public abstract class ConfigLoader {
	protected static final Logger logger = Logger.getLogger(ConfigLoader.class);
	protected String dir = "config/";
	/**
	 * 配置加载方法<br> 
	 * PS:该方法禁止抛出异常，需要对所有可能出现异常的代码进行try/catch
	 */
	public abstract void load();
	public abstract String getName();
	/**
	 * 获取config目录下的资源
	 * @param name
	 * @return
	 */
	public InputStream getConfigInputStream(String name){
		return ConfigLoader.class.getClassLoader().getResourceAsStream(dir+name);
	}
	
}
