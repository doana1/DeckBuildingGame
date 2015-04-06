package doanan.GamePieces.game;

import android.view.View;
import android.view.View.OnClickListener;

import doanan.GamePieces.gamePlayer.Deck;

public class cardAddOnClickListener implements OnClickListener {
	
	doanan.GamePieces.gamePlayer.Deck Deck;
    int cardType;
	
	public cardAddOnClickListener(Deck deck, int cardType){
		this.Deck = deck;
        this.cardType = cardType;
	}
	
	public void onClick(Deck deck) {
		deck = this.Deck;

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
