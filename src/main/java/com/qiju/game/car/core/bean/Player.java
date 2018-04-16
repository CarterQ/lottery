package com.qiju.game.car.core.bean;


/**
 * 玩家基础信息
 * @author Qintingyin
 *
 * 2018-4-10
 */
public class Player {
	/**
	 * 唯一标识,平台的用户ID
	 */
	private long id;
	/**
	 * 平台标识
	 */
	private int site;
	/**
	 * 平台用户的等级
	 */
	private int level;
	/**
	 * 玩家余额
	 */
	private long amount;
	/**
	 * 名称
	 */
	private String name;
	
	
	public Player(long id,int site){
		this.id = id;
		this.site = site;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSite() {
		return site;
	}
	public void setSite(int site) {
		this.site = site;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
