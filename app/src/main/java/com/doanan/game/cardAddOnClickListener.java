package com.doanan.game;

import android.view.View;
import android.view.View.OnClickListener;

import com.doanan.gamePlayer.Deck;

public class cardAddOnClickListener implements OnClickListener {
	
	Deck Deck;
	
	public cardAddOnClickListener(Deck deck){
		this.Deck = deck;
	}
	
	public void onClick(Deck deck) {
		deck = this.Deck;

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
