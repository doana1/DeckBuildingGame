package com.doanan.gamePlayer;

import android.util.Log;

import com.doanan.gameCards.Ammunition;
import com.doanan.gameCards.Card;
import com.doanan.gameCards.Weapon;
import com.doanan.gameCards.Action;
import com.doanan.gameComponentsCreate.ActionCreate;

import java.util.ArrayList;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<Card>();
	public ArrayList<Card> usedCards = new ArrayList<Card>();
	public ArrayList<Card> discardCards = new ArrayList<Card>();

    ActionCreate action = new ActionCreate();
	
	public PlayerHand(){
		
	}

	/**
	 * Draws 5 cards from the DECK to the PLAYER's HAND.
	 * 
	 * @param deck The player's deck that is used during the game.
	 */
	public void draw(Deck deck){

        if(deck.deckSize() > 4 || deck.isEmpty()){
            Log.e("DRAW_IF","Cards were drawn normally");

            if(!deck.isEmpty()){
                Log.e("IF","Deck is not empty");
            }
            if (deck.isEmpty()){
                discardToDeck(deck);
                deck.shuffle();
                Log.e("SHUFFLE","SHUFFLED AND NEW DECK");
            }

            for(int i = 0; i < 5; i++){
//                Card temp;
//                temp = deck.removeCard();
//                temp.CARDINDEX = i;
//                playerHand.add(temp);
                playerHand.add(deck.removeCard());
            }
        }

		else{
            Log.e("DRAW_ELSE", "Drawn remaining cards in Deck, Shuffled, Drawn");
            int remainingDraw = 0;
            for(int i=0;i<deck.deckSize();i++){
//                Card temp;
//                temp = deck.removeCard();
//                temp.CARDINDEX = i;
//                playerHand.add(temp);
                playerHand.add(deck.removeCard());
                remainingDraw++;
            }
            discardToDeck(deck);
            deck.shuffle();

            while(remainingDraw < 5){
//                Card temp;
//                temp = deck.removeCard();
//                temp.CARDINDEX = remainingDraw;
//                playerHand.add(temp);
                playerHand.add(deck.removeCard());
                remainingDraw++;
            }
        }
	}

    public void drawExtra(Player player,int extraDraw){

        for(int i = 0; i < extraDraw; i++){
            if (player.DECK.isEmpty()){
                discardToDeck(player.DECK);
                player.DECK.shuffle();
                Log.e("DRAW_EXTRA","SHUFFLED AND NEW DECK");
                Log.e("Size of Deck: ", " player.DECK.deckSize()");
                playerHand.add(player.DECK.removeCard());
            }
//            Card temp;
//            temp = player.DECK.removeCard();
//            temp.CARDINDEX = i;
//            playerHand.add(temp);
            else{
                playerHand.add(player.DECK.removeCard());
            }

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

    public void discardPile(ArrayList<Card> remainingCards){

        discardCards.addAll(remainingCards);
        remainingCards.clear();

    }

    public void discardEverything(){
        discardCards.addAll(playerHand);
        discardCards.addAll(usedCards);
        playerHand.clear();
        usedCards.clear();
    }

    public void discardToDeck(Deck deck){
        deck.toDeck(discardCards);
        discardCards.clear();
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
        else if(card.getClass().equals(Action.class)){
            if (card.NAME.equals(action.deadlyAim.NAME)){
                player.AMMO += action.deadlyAim.AMMO;

                // Weapons get +10 Damage this turn
                for (Card m: playerHand){
                    action.deadlyAim.addDamage(m);
                }
                for (Card m: usedCards){
                    action.deadlyAim.addDamage(m);
                    if (m.getClass().equals(Weapon.class)){
                        player.DAMAGE += 10;
                    }
                }
            }
            else if(card.NAME.equals(action.reload.NAME)){
                player.AMMO += action.reload.AMMO;
                player.ACTION += action.reload.EXTRA_ACTION;
                // TODO
                // Move 1 Weapon from your discard pile to your hand
            }
            else if(card.NAME.equals(action.ominousBattle.NAME)){
                player.GOLD += action.ominousBattle.GOLD;
                player.DRAWS += action.ominousBattle.EXTRA_CARDS;
                // TODO
                // Trash 1 card from your Hand.
            }
            else if(card.NAME.equals(action.mansionFoyer.NAME)){
                // Draw 2 cards from player.Deck
                player.DRAWS += action.mansionFoyer.EXTRA_CARDS;
                drawExtra(player,player.DRAWS);
            }
            else if(card.NAME.equals(action.struggleForSurvival.NAME)){
                player.ACTION += action.struggleForSurvival.EXTRA_ACTION;
                player.EXPLORE += action.struggleForSurvival.EXTRA_EXPLORE;
                // TODO
                // You can discard this card from your hand to lower the damage of 1 weapon being used costing 40 Gold or less to 0
            }
            else if(card.NAME.equals(action.theMerchant.NAME)){
                player.GOLD += action.theMerchant.GOLD;
                player.DRAWS += action.theMerchant.EXTRA_CARDS;
                player.BUY += action.theMerchant.EXTRA_BUY;
            }
            else if(card.NAME.equals(action.umbrellaCorporation.NAME)){
                player.DRAWS += action.umbrellaCorporation.EXTRA_CARDS;
                player.ACTION += action.umbrellaCorporation.EXTRA_ACTION;
                // TODO
                // Move 1 card from your Hand to the top of your inventory
            }
        }
		//Once card is used, move it to the CardsUsed arraylist
		play(card);
	}

    public void removeEffects(){
        for(Card m: discardCards){
            if (m.getClass().equals(Weapon.class)){
                while(m.deadlyAims > 0) {
                    action.deadlyAim.decreaseDamage(m);
                }
            }
        }


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
