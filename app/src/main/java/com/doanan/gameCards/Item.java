package com.doanan.gameCards;

public class Item extends Card{
	
	/*
	 * Item Attributes
	 * Card Type
	 * Cost to Buy
	 * Item Name
	 * Effect
	 */
	String NAME;
	int COST;

	public Item(String name, int cost, int ammo,int cardIndex) {
		super(name, cost,ammo, cardIndex);
		// TODO Auto-generated constructor stub
//		this.NAME = name;
//		this.COST = cost;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}

}
