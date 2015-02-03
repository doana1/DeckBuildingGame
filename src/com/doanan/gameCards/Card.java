package com.doanan.gameCards;

import com.doanan.gamePlayer.Turn;

public class Card implements Turn{
	
	public String NAME;
	public int COST;
	// Unsure if I need this, used to determine index of card in hand
	public int CARDINDEX;
	
	public Card(String name, int cost, int cardIndex){
		this.NAME = name;
		this.COST = cost;
		this.CARDINDEX = cardIndex;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
}
