package com.doanan.gamePlayer;

import com.doanan.gameCards.Action;
import com.doanan.gameCards.Ammunition;

public class Player {
	/*
	 * Counters to keep track of a players information
	 */
	public String NAME, CHARACTERNAME;
	public int HEALTH, ACTION, BUY, EXPLORE, GOLD, AMMO;
	
	/**
	 * Creates a Player.
	 * <p>
	 * 
	 * 
	 * @param name Name of the person playing the game.
	 * @param charactername Name of the character the player is using.
	 * @param health Amount of health the player has left.
	 * @param action Amount of actions the player can use.
	 * @param buy Amount of buys the player can use.
	 * @param explore Amount of explores the player can use.
	 * @param gold Amount of gold the player has.
	 * @param ammo Amount of ammo the player has.
	 */
	public Player(String name, String charactername, int health, int action, int buy, int explore, int gold, int ammo){
		this.NAME = name;
		this.CHARACTERNAME = charactername;
		this.HEALTH = health;
		this.ACTION = action;
		this.BUY = buy;
		this.EXPLORE = explore;
		this.GOLD = gold;
		this.AMMO = ammo;
	}
	
	/**
	 * Adds an extra Action to the player.
	 * Each Action allows the player to play another Action card.
	 */
	public void addAction(Action actionCard){
		this.ACTION = actionCard.ACTION;
	}
	
	/**
	 * Adds GOLD to a PLAYER from an ammunition card.
	 * @param card An ammunition card.
	 */
	public void addAmmoGold(Ammunition card){
		this.GOLD = card.GOLD;
	}
	
	/**
	 * Returns player gold.
	 * 
	 * @return Amount of GOLD a player has.
	 */
	public int getPlayerGOLD(){
		return GOLD;
	}
	
	/**
	 * Returns player ammo.
	 * 
	 * @return Amount of AMMO a player has.
	 */
	public int getPlayerAMMO(){
		return AMMO;
	}
	
}
