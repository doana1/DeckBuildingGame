package doanan.GamePieces.gamePlayer;

import doanan.GamePieces.gameCards.Ammunition;

public class Player {
	/*
	 * Counters to keep track of a players information
	 */
	public String NAME, CHARACTERNAME;
	public int HEALTH, ACTION, BUY, EXPLORE, GOLD, AMMO, DAMAGE;
    public int DRAWS;
    public Deck DECK;
    public int DECORATIONS;
    public int MAXHEALTH;
	
	/**
	 * Creates a Player.
	 * <p>
	 * 
	 * 
	 * @param name Name of the person playing the game.
	 * @param charactername Name of the character the player is using.
	 * @param health Amount of health the player has left.
	 */
	public Player(String name, String charactername, int health){
		this.NAME = name;
		this.CHARACTERNAME = charactername;
		this.HEALTH = health;
		this.ACTION = 1;
		this.BUY = 1;
		this.EXPLORE = 1;
		this.GOLD = 0;
		this.AMMO = 0;
        this.DECK = new Deck();
        this.DECORATIONS = 0;

	}

    public Player(){
        this.DECK = new Deck();
        this.ACTION = 1;
        this.BUY = 1;
        this.EXPLORE = 1;
    }
	

	
	/**
	 * Adds GOLD to a PLAYER from an ammunition card.
	 * @param card An ammunition card.
	 */
	public void addAmmoGold(Ammunition card){
		this.GOLD = card.GOLD;
	}
	
	/**
	 * Returns player gold.
	 * 
	 * @return Amount of GOLD a player has.
	 */
	public int getPlayerGOLD(){
		return GOLD;
	}
	
	/**
	 * Returns player ammo.
	 * 
	 * @return Amount of AMMO a player has.
	 */
	public int getPlayerAMMO(){
		return AMMO;
	}

    /**
     * Returns player damage.
     * It is the amount of power they currently have to defeat monsters.
     *
     * @return Amount of DAMAGE power a player has.
     */
    public int getPlayerDAMAGE(){
        return DAMAGE;
    }

    /**
     * Sets the player's health.
     *
     * @param health Amount of health a player will have.
     */
    public void setPlayerHealth(int health){
        this.HEALTH = health;
    }

    public void setPlayerName(String playerName){
        this.NAME = playerName;
    }

    public void setCharacterName(String characterName){
        this.CHARACTERNAME = characterName;
    }

    public void setMaxHealth(int maxHealth){
        this.MAXHEALTH = maxHealth;
    }

    public int getMaxHealth(){
        return MAXHEALTH;
    }
	
}
