package com.doanan.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		 * Used to remove actionbar in this activity
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.main_game);
	}
	
	protected void imageView1(){
		AlertDialog.Builder builder = new AlertDialog.Builder(null);
		
		builder.setMessage("How are you")
			   .setTitle("The Title");
		
		AlertDialog dialog = builder.create();
	}
}
