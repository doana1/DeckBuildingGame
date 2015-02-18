package com.doanan.gameCards;

import com.doanan.gamePlayer.Turn;

public class Card implements Turn{
	
	public String NAME;
	public int COST;
	// Unsure if I need this, used to determine index of card in hand
	public int CARDINDEX;
	public int AMMO;
	
	/**
	 * Creates a CARD.
	 * 
	 * @param name Name of the card.
	 * @param cost Cost to purchase the card.
	 * @param cardIndex Used to determine where the card is located in a Player's Hand.
	 */
	public Card(String name, int cost, int ammo, int cardIndex){
		this.NAME = name;
		this.COST = cost;
		this.AMMO = ammo;
		this.CARDINDEX = cardIndex;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Returns the title name of a card.
	 * 
	 * @return The NAME of the card.
	 */
	public String getName(){
		return NAME;
	}
}
