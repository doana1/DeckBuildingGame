package com.doanan.gamePlayer;

public class Player {
	/*
	 * Counters to keep track of a players information
	 */
	String NAME, CHARACTERNAME;
	int HEALTH, ACTION, BUY, EXPLORE;
	
	public Player(String name, String charactername, int health, int action, int buy, int explore){
		this.NAME = name;
		this.CHARACTERNAME = charactername;
		this.HEALTH = health;
		this.ACTION = action;
		this.BUY = buy;
		this.EXPLORE = explore;
	}
}
