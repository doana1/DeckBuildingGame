package com.doanan.gameCards;

import com.doanan.gamePlayer.Turn;

public class Card implements Turn{
	
	public String NAME;
	public int COST;
	
	public Card(String name, int cost){
		this.NAME = name;
		this.COST = cost;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}	
}
