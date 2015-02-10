package com.doanan.gameCards;

public class Ammunition extends Card{
	
	public int AMMO, GOLD;
//	public String NAME;
	
	/**
	 * Creates an AMMUNITION Card.
	 * 
	 * @param name Name of the Card.
	 * @param cost Cost to purchase the Card.
	 * @param ammo Amount of ammunition the card provides.
	 * @param gold Amount of gold the card provides.
	 * @param cardIndex Used to determine where the card is located in a Player's Hand.
	 */
	public Ammunition(String name, int cost, int ammo, int gold, int cardIndex){
		super(name, cost, ammo,cardIndex);
		
//		this.AMMO = ammo;
		this.GOLD = gold;
//		this.COST = cost;
//		this.NAME = name;
	}

	public void getCurrentTurn() {
		// TODO Auto-generated method stub
		
	}
}
