package com.doanan.gameCards;

public class Item extends Card{
	
	/*
	 * Item Attributes
	 * Card Type
	 * Cost to Buy
	 * Item Name
	 * Effect
	 */
	public String NAME;
	public int COST;

	public Item(String name, int cost, int ammo,int ammorequirement,int damage,int cardIndex, int gold) {
		super(name, cost,ammo,ammorequirement,damage, cardIndex, gold);
		// TODO Auto-generated constructor stub
//		this.NAME = name;
//		this.COST = cost;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}

}
