package com.doanan.gameCards;

public class Weapon extends Card{
	
	/*
	 * Weapons have the following attributes
	 * Card Type: Weapon
	 * Cost to Buy
	 * Weapon Name (Card Name, from Card class)
	 * Weapon Type (Implement this later?)
	 * Ammo Requirements
	 * Damage
	 * Weapon Effect (Use methods to add and change values as needed?)
	 */
	public boolean EFFECT;
	public int COST;
    public int DAMAGE;

	public Weapon(String name, int cost,int ammoRequirement, int damage, boolean effect, int cardIndex) {
		super(name,cost, ammoRequirement,cardIndex);
//		this.NAME = name;
//		this.COST = cost;
        this.DAMAGE = damage;
		
		this.EFFECT = effect;	
	}
	
	public void addDamage(){
		this.COST += 20;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
	
}
