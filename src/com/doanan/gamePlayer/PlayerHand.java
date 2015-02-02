package com.doanan.gamePlayer;

import java.util.ArrayList;

import com.doanan.gameCards.Card;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<Card>();
	public ArrayList<Card> usedCards = new ArrayList<Card>();
	public ArrayList<Card> discard = new ArrayList<Card>();
	public Deck playerDeck;
	public PlayerHand(){
		
	}
	
	/*
	 * Draws 5 cards from the deck
	 * Should be called at the end of a turn too
	 */
	public void draw(){
		for(int i = 0; i < 6; i++){
			playerHand.add(playerDeck.removeCard());
		}
	}
	
	/*
	 * Play function
	 * if card is played, then it moves into card played area
	 */
	public void play(int index){
		usedCards.add(playerHand.remove(index));
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
