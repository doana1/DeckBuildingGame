package com.doanan.gameComponents;

public class Ammunition extends Card{
	
	public int COST, AMMO, GOLD;
	
	public Ammunition(String name, int cost, int ammo, int gold){
		super(name);
		this.COST = cost;
		this.AMMO = ammo;
		this.GOLD = gold;
	}
}
