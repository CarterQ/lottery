package com.qiju.game.car.config.bean;

public class ChooseType {
	/** 押注区索引(与前端flash一致) **/
	private int id;

	/** 押注类型名称 **/
	private String name;

	/** 压中倍数 **/
	private int multiple;

	/** 压中概率 **/
	private int ratio;
	/** 开奖描述 **/
	private String desc;

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
