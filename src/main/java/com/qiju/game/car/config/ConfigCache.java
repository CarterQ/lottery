package com.qiju.game.car.config;

import java.util.HashMap;
import java.util.Map;
import com.qiju.game.car.config.bean.ChooseTypes;
/**
 * 
 * 所有配置数据都存在这里<br>
 * 数据为集合的需要封装
 * @see ChooseTypes
 * @author Qintingyin
 *
 * 2018-4-9
 */
public class ConfigCache {
	private Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();
	private ConfigCache(){}
	private static ConfigCache instance = new ConfigCache();
	public static ConfigCache getInstance(){
		return instance;
	}
	@SuppressWarnings("unchecked")
	public <T> T getConfig(Class<T> clazz){
		return (T)map.get(clazz);
	}
	
	public void setConfig(Class<?> clazz,Object object){
		map.put(clazz, object);
	}
}
