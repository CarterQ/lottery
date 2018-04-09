package com.qiju.game.car.config.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 押注区{@link ChooseType}的封装类,提供ChooseType相关筛选工作
 * @author Qintingyin
 *
 * 2018-4-9
 */
public class ChooseTypes {
	private Map<Integer, ChooseType> idMap = new HashMap<Integer, ChooseType>();
	private Map<String, ChooseType> nameMap = new HashMap<String, ChooseType>();
	
	public void addChooseType(ChooseType type){
		idMap.put(type.getId(), type);
		nameMap.put(type.getName(), type);
	}
	/**
	 * 根据ID获取下注区
	 * @param id
	 * @return {@link ChooseType}
	 */
	public ChooseType getChooseTypeById(int id){
		return idMap.get(id);
	}
	/**
	 * 根据名称获取下注区
	 * @param name
	 * @return {@link ChooseType}
	 */
	public ChooseType getChooseTypeByName(String name){
		return nameMap.get(name);
	}
	/**
	 * 获取所有押注区
	 * @return 
	 */
	public Map<Integer, ChooseType> getChooseTypes(){
		return idMap;
	}
}
