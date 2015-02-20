package com.doanan.gamePlayer;

import com.doanan.gameCards.Ammunition;
import com.doanan.gameCards.Card;
import com.doanan.gameCards.Weapon;

import java.util.ArrayList;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<Card>();
	public ArrayList<Card> usedCards = new ArrayList<Card>();
	public ArrayList<Card> discardCards = new ArrayList<Card>();
	
	public PlayerHand(){
		
	}

	/**
	 * Draws 5 cards from the DECK to the PLAYER's HAND.
	 * 
	 * @param deck The player's deck that is used during the game.
	 * 
	 * Need to add cases such as if(DECK %5 != 0)
	 * Then draw remaining cards
	 * Shuffle (Discard Deck)
	 * Move Discarded Deck to DECK
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
	 * 
	 * @param usedCard Takes card index that was played
	 * 
	 */
	public void play(Card usedCard){
//		Card cardPlayed = usedCard;
		if(playerHand.contains(usedCard)){
			playerHand.remove(usedCard);
            usedCards.add(usedCard);
		}
//		usedCards.add(cardPlayed);
		//INDEX OUT OF BOUNDS
		//Apparently when an object is remove from an arraylist
		//All elements shift to the left and the size of the arraylist shrinks
	}

    public void discardAll(ArrayList<Card> remainingCards){

        discardCards.addAll(remainingCards);
        remainingCards.clear();

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
		
	/**
	 * Use a card from the PLAYER's HAND.
	 * 
	 * @param player Player whose cards to use.
	 * @param card Card to be used.
	 */
	public void useCard(Player player, Card card){
		if(card.getClass().equals(Ammunition.class)){
			player.AMMO += card.AMMO;
            player.GOLD += card.GOLD;
		}
        else if(card.getClass().equals(Weapon.class)){
            if(player.AMMO >= card.AMMOREQUIREMENT){
                player.DAMAGE += card.DAMAGE;
                player.AMMO -= card.AMMOREQUIREMENT;
            }
        }
		//Once card is used, move it to the CardsUsed arraylist
		play(card);
	}
	
	public String cardName(Card card){
		return card.NAME;
	}
	
	/**
	 * Returns the amount of cards in the player's hand.
	 * 
	 * @return Player's hand size.
	 */
	public int handSize(){
		return playerHand.size();
	}
	
}
