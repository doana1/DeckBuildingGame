package com.doanan.gameCards;

public class Card{
	
	public String NAME;
	public int COST;
	// Unsure if I need this, used to determine index of card in hand
	public int CARDINDEX;
	public int AMMO;
    public int DAMAGE;
    public int AMMOREQUIREMENT;
    public int GOLD;
    public String FILEPATH;

    public int deadlyAims = 0;
	
	/**
	 * Creates a CARD.
     *
	 * @param name Name of the card.
	 * @param cost Cost to purchase the card.
     * @param ammo Ammo the card gives to the player.
     * @param ammoRequirement Amount of ammo required to use a card.
     * @param damage Amount of damage power card gives the player.
	 * @param cardIndex Used to determine where the card is located in a Player's Hand.
     * @param gold Amount of gold card gives to the player.
	 */
	public Card(String name, int cost, int ammo, int ammoRequirement, int damage, int cardIndex,int gold,String filePath){
		this.NAME = name;
		this.COST = cost;
		this.AMMO = ammo;
        this.AMMOREQUIREMENT = ammoRequirement;
        this.DAMAGE = damage;
		this.CARDINDEX = cardIndex;
        this.GOLD = gold;
        this.FILEPATH = filePath;
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
