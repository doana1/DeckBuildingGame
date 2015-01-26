package com.doanan.game;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class myOnClickListener implements OnClickListener{
	int myOnClickVariable;
	String[] imageFileName;
	String[] imageDescription;
	int iterator;
	
	public myOnClickListener(Context context, String[] imageFileName, String[] imageDescription, int iterator){
		this.imageFileName = imageFileName;
		this.imageDescription = imageDescription;
		this.iterator = iterator;
	}
	
	public void onClick(View v, String[] imageFileName,String[] imageDescription,int iterator) {
		imageFileName = this.imageFileName;
		imageDescription = this.imageDescription;
		iterator = this.iterator;
		// TODO Auto-generated method stub
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
