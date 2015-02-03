package com.doanan.gameCards;

public class Monster extends Card{
	
	/*
	 * Monster attributes
	 * Card Type
	 * Monster Name (From Card Class)
	 * Health
	 * Effect
	 * Damage
	 * Decoration Reward
	 */
	public int COST, HEALTH, DAMAGE, REWARD;
	public String NAME;
	public boolean EFFECT;

	public Monster(String name, int cost, int health, int damage, boolean effect, int reward, int cardIndex) {
		super(name, cost, cardIndex);
//		this.NAME = name;
//		this.COST = cost;
		this.HEALTH = health;
		this.DAMAGE = damage;
		this.REWARD = reward;
		this.EFFECT = effect;
	}
	
	public void doubleDamage(){
		this.DAMAGE *= 2;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
	
}
