package com.doanan.gameCards;

public class Monster {
	
	/*
	 * Monster attributes
	 * Card Type
	 * Monster Name (From Card Class)
	 * Health
	 * Effect
	 * Damage
	 * Decoration Reward
	 */

	public String NAME;
    public int HEALTH, DAMAGE, DECORATIONS;
	public boolean EFFECT;

//	public Monster(String name, int cost, int health, int ammo,int ammorequirement, int damage, boolean effect, int reward, int cardIndex, int gold) {
//		super(name, cost, ammo,ammorequirement, damage,cardIndex, gold, "royalty.png");
////		this.NAME = name;
////		this.COST = cost;
//		this.HEALTH = health;
//		this.DAMAGE = damage;
//		this.REWARD = reward;
//		this.EFFECT = effect;
//	}

    public Monster(String name, int health, int damage, int decorations, boolean effect){
        this.NAME = name;
        this.HEALTH = health;
        this.DAMAGE = damage;
        this.DECORATIONS = decorations;
        this.EFFECT = effect;
    }
	
	public void doubleDamage(){
		this.DAMAGE *= 2;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
	
}
