package doanan.GamePieces.gamePlayer;

import doanan.GamePieces.gameCards.Action;
import doanan.GamePieces.gameCards.Ammunition;
import doanan.GamePieces.gameCards.Card;
import doanan.GamePieces.gameCards.Item;
import doanan.GamePieces.gameCards.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	/*
	 * Implement the following
	 * - A Deck full of everything I can buy
	 * - Ability to see Deck
	 * - Buying ability
	 * - A Discard deck and ability to view it
	 * - Current 5 cards in hand
	 * - Cards just played
	 * - Shuffle deck method
	 */
//	Card[] deck = new Card[10];
	
	public ArrayList<Card> deck = new ArrayList<Card>();

	int index;
	
	
	public Deck(){
		
	}
	
	/*
	 * Check each add
	 * Starting index
	 * 
	 */
	
	public void add(Weapon card){
		deck.add(card);
	}
	
	public void add(Item card){
		deck.add(card);
	}

    public boolean isEmpty(){
        return deck.isEmpty();
    }
	
	public void add(Action card){
		deck.add(card);
	}
	
	public void add(Ammunition card){
		deck.add(card);
	}

    public void add(Card card){
        deck.add(card);
    }
	
	/*
	 * Checks if object in deck is an item
	 */
	public String itemC(){
		for(Object o:deck){
			if(o.getClass().equals(Item.class)){
				return "Item Card Added";
				
			}
		}
		return null;
	}
	
	/*
	 * Checks if object in deck is an ammunition
	 */
	public String ammoC(){
		for(Object o:deck){
			if(o.getClass().equals(Ammunition.class)){
				return "Ammo Card Added";
				
			}
		}
		return null;
	}
	
	/*
	 * Checks if object in deck is a weapon
	 */
	public String weaponC(){
		for(Object o:deck){
			if(o.getClass().equals(Weapon.class)){
				return "Weapon Card Added";
				
			}
		}
		return null;
	}
	
	/*
	 * Checks if object in deck is an action
	 */
	public String action(){
		for(Object o:deck){
			if(o.getClass().equals(Action.class)){
				return "Action Card Added";
				
			}
		}
		return null;
	}
	
	/**
	 * Returns the name of the top card from the deck.
	 * 
	 * @return Name of the top card.
	 */
	public String getCardTitle(){
		Card card = deck.get(deck.size()-1);
		return card.NAME;
	}
	
	/**
	 * Returns the cost of the top card from the deck.
	 * 
	 * @return Cost of the top card.
	 */
	public int getCardDescription(){
		return deck.remove(deck.size()).COST;
	}
	
	/**
	 * Returns the top card from the deck.
	 * 
	 * @return Top card from the deck.
	 */
	public Card removeCard(){
		return deck.remove(deck.size()-1);
	}
	
	/**
	 * Returns the amount of cards in the deck.
	 * 
	 * @return Size of deck.
	 */
	public int deckSize(){
		return deck.size();
	}

    public void shuffle(){
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }


    public void toDeck(ArrayList<Card> discardDeck){
        deck.addAll(discardDeck);
    }


}
