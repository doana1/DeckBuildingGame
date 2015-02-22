package com.doanan.gameCards;

public class Token extends Card{
	
	/*
	 * Token Attributes
	 * Card Type
	 * Name
	 * Effect (Gives player the thing indicated on the card)
	 */
	
	public String NAME;
	public int COST;

	public Token(String name, int cost,int ammo,int ammorequirement, int damage,int cardIndex, int gold, String filePath) {
		super(name, cost, ammo, ammorequirement, damage, cardIndex, gold, filePath);
//		this.NAME = name;
//		this.COST = cost;
		// TODO Auto-generated constructor stub
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}

}
