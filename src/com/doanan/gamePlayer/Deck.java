package com.doanan.gamePlayer;

import java.util.ArrayList;

import com.doanan.gameCards.Action;
import com.doanan.gameCards.Ammunition;
import com.doanan.gameCards.Card;
import com.doanan.gameCards.Item;
import com.doanan.gameCards.Weapon;

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
	
	public void add(Action card){
		deck.add(card);
//		for(int i=0;i<deck.length;i++){
//			if(deck[i] == null){
//				deck[i] = card;
//				break;
//			}
//		}
	}
	
	public void add(Ammunition card){
		deck.add(card);
//		for(int i=0;i<deck.length;i++){
//			if(deck[i] == null){
//				deck[i] = card;
//				break;
//			}
//		}
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
	
	/*
	 * Returns Top Card Information
	 */
	
	public String getCardTitle(){
		Card card = deck.get(deck.size()-1);
		return card.NAME;
	}
	
	/*
	 * Returns Image Description
	 */
	public int getCardDescription(){
		return deck.remove(deck.size()).COST;
	}
	
	/*
	 * Removes the top card of the Deck
	 */
	public Card removeCard(){
		return deck.remove(deck.size());
		
	}
}
