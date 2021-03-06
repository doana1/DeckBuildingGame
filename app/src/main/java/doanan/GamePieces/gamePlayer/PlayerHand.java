package doanan.GamePieces.gamePlayer;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import doanan.GamePieces.gameCards.Action;
import doanan.GamePieces.gameCards.Ammunition;
import doanan.GamePieces.gameCards.Card;
import doanan.GamePieces.gameCards.Item;
import doanan.GamePieces.gameCards.Weapon;
import doanan.GamePieces.gameComponentsCreate.ActionCreate;
import doanan.GamePieces.gameComponentsCreate.ItemCreate;

public class PlayerHand {
	
	public ArrayList<Card> playerHand = new ArrayList<>();
	public ArrayList<Card> usedCards = new ArrayList<>();
	public ArrayList<Card> discardCards = new ArrayList<>();

    ActionCreate action = new ActionCreate();
    ItemCreate item = new ItemCreate();
	
	public PlayerHand(){
		
	}

    public void shuffleDiscard(){
        long seed = System.nanoTime();
        Collections.shuffle(discardCards, new Random(seed));
    }

    public void trash(Card card){
        playerHand.remove(card);
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
        Log.e("PLAYERDECK","Size of deck: "+deck.deckSize());
	}

    public void drawExtra(Player player,int extraDraw){

        for(int i = 0; i < extraDraw; i++){
            if (player.DECK.isEmpty()){
                discardToDeck(player.DECK);
                player.DECK.shuffle();
                Log.e("DRAW_EXTRA","SHUFFLED AND NEW DECK");
                Log.e("Size of Deck: ", ""+ player.DECK.deckSize());
                Log.e("EXTRA DECK", "Size of deck: " + player.DECK.deckSize());

                playerHand.add(player.DECK.removeCard());
            }

            else{
                playerHand.add(player.DECK.removeCard());
                Log.e("Size of Deck: ", ""+ player.DECK.deckSize());
                Log.e("EXTRA DECK", "Size of deck: " + player.DECK.deckSize());

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

    public void discardToHand(Card card){
        discardCards.remove(card);
        playerHand.add(card);
    }

    public void handToDeck(Deck deck,Card card){
        playerHand.remove(card);
        deck.add(card);

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

    public ArrayList<Card> checkForWeapons(){
        ArrayList<Card> weaponCards = new ArrayList<>();
        for(Card m: usedCards){
            if (m.getClass().equals(Weapon.class)){
                weaponCards.add(m);
            }
        }
        sortWeapons(weaponCards);
        return weaponCards;
    }

    public void sortWeapons(ArrayList<Card> weapons){
        Collections.sort(weapons, new Comparator<Card>() {
            @Override
            public int compare(Card lhs, Card rhs) {
                if (lhs.DAMAGE >= rhs.DAMAGE){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
    }

    public void checkWeaponUsed(Player player){
        for(Card m: checkForWeapons()){
            if (player.AMMO >= m.AMMOREQUIREMENT && !m.weaponLoaded){
                player.AMMO -= m.AMMOREQUIREMENT;
                player.DAMAGE += m.DAMAGE;
                break;
            }
        }
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
            checkWeaponUsed(player);
            // Check if weapon card already on field
            // If there is one, check if it is loaded
            // If not, check if ammo is greater or equal to it
            // Then remove ammo and add damage of weapon
		}
        else if(card.getClass().equals(Weapon.class)){
            if(player.AMMO >= card.AMMOREQUIREMENT){
                player.DAMAGE += card.DAMAGE;
                player.AMMO -= card.AMMOREQUIREMENT;
                card.weaponLoaded = true;
            }
        }
        else if(card.getClass().equals(Item.class)){
            if (card.NAME.equals(item.herb.NAME)){
                player.HEALTH += 20;
                if (player.HEALTH > player.MAXHEALTH){
                    player.HEALTH = player.MAXHEALTH;
                }
            }
            else if (card.NAME.equals(item.firstAid.NAME)){
                player.HEALTH = player.MAXHEALTH;
            }
        }
        else if(card.getClass().equals(Action.class) && player.ACTION > 0){
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
                player.ACTION--;
            }
            else if(card.NAME.equals(action.reload.NAME)){
                player.AMMO += action.reload.AMMO;
                player.ACTION += action.reload.EXTRA_ACTION;
                // Move 1 Weapon from your discard pile to your hand
                // Players need to be able to view discard pile first
                // Afterwards select card
                // Add it to player hand
                player.ACTION--;
            }
            else if(card.NAME.equals(action.ominousBattle.NAME)){
                // Draws 3 card from player.Deck
                // Trash one card in hand
                player.GOLD += action.ominousBattle.GOLD;
                player.DRAWS += action.ominousBattle.EXTRA_CARDS;
                drawExtra(player,player.DRAWS);
                player.ACTION--;
            }
            else if(card.NAME.equals(action.mansionFoyer.NAME)){
                // Draw 2 cards from player.Deck
                player.DRAWS += action.mansionFoyer.EXTRA_CARDS;
                drawExtra(player,player.DRAWS);
                player.ACTION--;
            }
            else if(card.NAME.equals(action.struggleForSurvival.NAME)){
                player.ACTION += action.struggleForSurvival.EXTRA_ACTION;
                player.EXPLORE += action.struggleForSurvival.EXTRA_EXPLORE;
                player.ACTION--;

                // Just gives players an additional ACTION to use and EXPLORE to use

                // NOTE "Original Card Ability"
                // You can discard this card from your hand to lower the damage of 1 weapon being used costing 40 Gold or less to 0
                // Open another dialog
                // Use regular or discard from hand
            }
            else if(card.NAME.equals(action.theMerchant.NAME)){
                player.GOLD += action.theMerchant.GOLD;
                player.DRAWS += action.theMerchant.EXTRA_CARDS;
                player.BUY += action.theMerchant.EXTRA_BUY;
                drawExtra(player,player.DRAWS);
                player.ACTION--;
            }
            else if(card.NAME.equals(action.umbrellaCorporation.NAME)){
                player.DRAWS += action.umbrellaCorporation.EXTRA_CARDS;
                player.ACTION += action.umbrellaCorporation.EXTRA_ACTION;
                drawExtra(player,player.DRAWS);
                player.ACTION--;
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
