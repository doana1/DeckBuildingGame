package com.doanan.game;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstgame.R;

public class MainGameActivity extends Activity {
	//Card Types
	String Character, Ammunition, Weapon, Infected, Token, Item, Action;
	
	//Card Attributes
	String Name, Cost, Health, Effect, Gold, Ammo, Damage, Decorations;
	
	//Turns
	public enum Turn{
		ACTION, BUY, EXPLORE
	}
	
	private Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * Used to remove actionbar in this activity
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.main_game);
		
		ImageView image1 = (ImageView) findViewById(R.id.imageView1);
		image1.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				///your code here
				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.bigimage);
				dialog.setTitle("Title...");
				
				//set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Android custom dialog example!");
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				image.setImageResource(R.drawable.ic_launcher);
				
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				//if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						dialog.dismiss();
					}
				});
				
				dialog.show();
			}
		});
		
		ImageView image2 = (ImageView) findViewById(R.id.imageView2);
		image2.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				///your code here
				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.bigimage);
				dialog.setTitle("This is the second image");
				
				//set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Description of what this image really is");
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				
				//Uncomment to use launcher icon
//				image.setImageResource(R.drawable.ic_launcher);
				
				//Using image from Assets
				try{
					//get input stream
					InputStream ims = getAssets().open("imgs/cards/ace_of_spades.jpg");
					//load image as Drawable
					Drawable d = Drawable.createFromStream(ims, null);
					//set image to ImageView
					image.setImageDrawable(d);
				}
				catch(IOException e){
					//handle
					image.setImageResource(R.drawable.ic_launcher);
					return;
				}

				
				
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				//if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						dialog.dismiss();
					}
				});
				
				dialog.show();
			}
		});
		
		ImageView image3 = (ImageView) findViewById(R.id.imageView3);
		image3.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				///your code here
				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.bigimage);
				dialog.setTitle("This is the second image");
				
				//set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("THE ACE OF HEARTS!!!");
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				
				//Uncomment to use launcher icon
//				image.setImageResource(R.drawable.ic_launcher);
				
				//Using image from Assets
				try{
					//get input stream
					InputStream ims = getAssets().open("imgs/cards/ace_of_hearts.jpg");
					//load image as Drawable
					Drawable d = Drawable.createFromStream(ims, null);
					//set image to ImageView
					image.setImageDrawable(d);
				}
				catch(IOException e){
					//handle
					image.setImageResource(R.drawable.ic_launcher);
					return;
				}

				
				
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				//if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						dialog.dismiss();
					}
				});
				
				dialog.show();
			}
		});
		
	}
	
	
	protected void imageView1(View arg0){
		// custom dialog
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.bigimage);
		dialog.setTitle("Title...");
		
		//set the custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Android custom dialog example!");
		ImageView image = (ImageView) dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.ic_launcher);
		
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		//if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				dialog.dismiss();
			}
		});
		
		dialog.show();
	}
}
