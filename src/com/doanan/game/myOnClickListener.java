package com.doanan.game;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class myOnClickListener implements OnClickListener{
	int myOnClickVariable;
	String[] imageFileName;
	String[] imageDescription;
	String[] imageTitle;
	int iterator;
	
	public myOnClickListener(Context context, String[] imageFileName, String[] imageDescription, String[] imageTitle, int iterator){
		this.imageFileName = imageFileName;
		this.imageDescription = imageDescription;
		this.imageTitle = imageTitle;
		this.iterator = iterator;
	}
	
	public void onClick(View v, String[] imageFileName,String[] imageDescription, String[] imageTitle, int iterator) {
		imageFileName = this.imageFileName;
		imageDescription = this.imageDescription;
		imageTitle = this.imageTitle;
		iterator = this.iterator;

	}

	public void onClick(View v) {
		
	}
	
}
