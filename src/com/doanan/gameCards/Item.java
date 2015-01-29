package com.doanan.gameCards;

public class Item implements Card{
	
	/*
	 * Item Attributes
	 * Card Type
	 * Cost to Buy
	 * Item Name
	 * Effect
	 */
	String NAME;
	int COST;

	public Item(String name, int cost) {
//		super(name, cost);
		// TODO Auto-generated constructor stub
		this.NAME = name;
		this.COST = cost;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}

}
