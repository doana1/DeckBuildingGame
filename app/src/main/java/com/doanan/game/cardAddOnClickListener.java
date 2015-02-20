package com.doanan.game;

import android.view.View;
import android.view.View.OnClickListener;

import com.doanan.gamePlayer.Deck;

public class cardAddOnClickListener implements OnClickListener {
	
	Deck Deck;
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
