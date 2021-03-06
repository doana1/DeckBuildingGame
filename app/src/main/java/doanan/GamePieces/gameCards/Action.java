package doanan.GamePieces.gameCards;

public class Action extends Card{
	
	/*
	 * Action Attributes
	 * Card Type
	 * Cost to Buy
	 * Action Name
	 * Effect
	 * Bonus Icons
	 */
	public int EXTRA_ACTION;
    public int EXTRA_EXPLORE;
    public int EXTRA_BUY;
    public int EXTRA_CARDS;

	/**
	 * Creates an ACTION Card.
	 * @param name Name of the card.
	 * @param cost How much gold is required to obtain the card.
	 * @param cardIndex (Used to determine where the card is located in the deck)
	 * @param ammo (AMMO IGNORE THIS)
	 * @param action The number of action points the player has.
	 */

	public Action(String name, int cost, int damage, int ammo,int gold,int extraAction,int extraBuys, int extraExplores,int extraCards,String filePath) {
		super(name,cost,ammo,0,damage,-1,gold,filePath);
		this.EXTRA_ACTION = extraAction;
        this.EXTRA_BUY = extraBuys;
        this.EXTRA_CARDS = extraCards;
        this.EXTRA_EXPLORE = extraExplores;
	}

    public void addDamage(Card card){
        if (card.getClass().equals(Weapon.class)) {
            card.DAMAGE += 10;
            card.deadlyAims++;
        }
    }

    public void decreaseDamage(Card card){
            card.DAMAGE -= 10;
            card.deadlyAims--;
    }



}
