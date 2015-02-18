package com.doanan.gameCards;

public class Action extends Card{
	
	/*
	 * Action Attributes
	 * Card Type
	 * Cost to Buy
	 * Action Name
	 * Effect
	 * Bonus Icons
	 */
	public String NAME;
	public int COST;
	public int ACTION;
	public int AMMO;

	/**
	 * Creates an ACTION Card.
	 * @param name Name of the card.
	 * @param cost How much gold is required to obtain the card.
	 * @param cardIndex (Used to determine where the card is located in the deck)
	 * @param ammo (AMMO IGNORE THIS)
	 * @param action The number of action points the player has.
	 */
	public Action(String name, int cost, int cardIndex, int ammo,int action) {
		super(name,cost,ammo,cardIndex);
//		this.NAME = name;
//		this.COST = cost;
		this.ACTION = action;
	}

}
