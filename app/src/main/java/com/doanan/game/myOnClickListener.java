package com.doanan.game;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.doanan.gamePlayer.Deck;

public class myOnClickListener implements OnClickListener{
	int myOnClickVariable;
	String[] imageFileName;
	String[] imageDescription;
	String[] imageTitle;
    int[] cardType;
	int iterator;
	Deck deck;
	
	public myOnClickListener(Context context, String[] imageFileName, String[] imageDescription, String[] imageTitle, int[] cardType,int iterator,Deck deck){
		this.imageFileName = imageFileName;
		this.imageDescription = imageDescription;
		this.imageTitle = imageTitle;
		this.iterator = iterator;
        this.cardType = cardType;
		
		this.deck = deck;
	}
	
	public void onClick(View v, String[] imageFileName,String[] imageDescription, String[] imageTitle, int[] cardType,int iterator) {
		imageFileName = this.imageFileName;
		imageDescription = this.imageDescription;
		imageTitle = this.imageTitle;
		iterator = this.iterator;
        cardType = this.cardType;
		
		deck = this.deck;

	}

	public void onClick(View v) {
		
	}
	
}
