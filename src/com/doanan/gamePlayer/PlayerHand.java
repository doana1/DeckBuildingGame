package com.doanan.gamePlayer;

import java.util.ArrayList;

import com.doanan.gameCards.Card;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<Card>();
	public Deck playerDeck;
	public PlayerHand(){
		
	}
	
	public void draw(){
		for(int i = 0; i < 6; i++){
			playerHand.add(playerDeck.remove());
		}
	}
	
	public void use(){
		/*
		 * Each card will be used differently
		 * Check type first
		 * Keep track of counters
		 * 
		 */
		int index = 3;
		playerHand.remove(index);
	}
	
}
