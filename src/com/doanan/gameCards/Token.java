package com.doanan.gameCards;

public class Token implements Card{
	
	/*
	 * Token Attributes
	 * Card Type
	 * Name
	 * Effect (Gives player the thing indicated on the card)
	 */
	
	public String NAME;
	public int COST;

	public Token(String name, int cost) {
//		super(name, cost);
		this.NAME = name;
		this.COST = cost;
		// TODO Auto-generated constructor stub
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}

}