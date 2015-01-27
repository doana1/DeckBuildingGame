package com.doanan.gameCards;

public class Ammunition extends Card{
	
	public int AMMO, GOLD;
	
	public Ammunition(String name, int cost, int ammo, int gold){
		super(name, cost);
		this.AMMO = ammo;
		this.GOLD = gold;
	}
}
