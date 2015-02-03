package com.doanan.gamePlayer;

import java.util.ArrayList;

import com.doanan.gameCards.Card;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<Card>();
	public ArrayList<Card> usedCards = new ArrayList<Card>();
	public ArrayList<Card> discard = new ArrayList<Card>();
	public PlayerHand(){
		
	}
	
	/*
	 * Draws 5 cards from the deck
	 * Should be called at the end of a turn too
	 * Need to add a case where deck only has 2 cards
	 * Case: (Shuffle Discard)
	 * Deck = Shuffled Discard
	 */
	public void draw(Deck deck){
		for(int i = 0; i < 5; i++){
			Card temp;
//			temp = playerDeck.deck.remove(i);
			temp = deck.removeCard();
			temp.CARDINDEX = i;
			playerHand.add(temp);
//			playerHand.add(playerDeck.removeCard());
			
		}
	}
	
	/**
	 * Play function
	 * If card is played, then it moves into card played area.
	 * Take a card from playerHand and add it to used Cards.
	 * <p>
	 * @param cardIndex Takes card index that was played
	 * 
	 */
	public void play(int cardIndex){
		Card cardPlayed = playerHand.remove(cardIndex);
		usedCards.add(cardPlayed);
	}
	
	public void use(){
		/*
		 * Each card will be used differently
		 * Check type first
		 * Keep track of counters
		 * 
		 */
//		int index = 3;
//		playerHand.remove(index);
	}
	
}
