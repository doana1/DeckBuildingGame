package com.doanan.gameCards;

public class Ammunition implements Card{
	
	public int COST, AMMO, GOLD;
	public String NAME;
	
	public Ammunition(String name, int cost, int ammo, int gold){
//		super(name, cost);
		
		this.AMMO = ammo;
		this.GOLD = gold;
		this.COST = cost;
		this.NAME = name;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
}
