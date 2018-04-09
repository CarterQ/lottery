package com.qiju.game.car.economy.bean;


public class MoneyHandleResult {
	
	/**币值**/
	private long balance;
	
	/**计费局ID**/
	private long roundID;

	/**计费信息**/
	private String vasErrorInfo; 
	
    private int result = -1;

	public long getRoundID() {
		return roundID;
	}

	public void setRoundID(long roundID) {
		this.roundID = roundID;
	}

	public String getVasErrorInfo() {
		return vasErrorInfo;
	}

	public void setVasErrorInfo(String vasErrorInfo) {
		this.vasErrorInfo = vasErrorInfo;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
