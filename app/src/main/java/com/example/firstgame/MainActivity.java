package com.example.firstgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.doanan.game.MainGameActivity;
import com.doanan.game.MainGameInterface;

public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.firstgame.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new Fragment_1()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		
		
		switch(item.getItemId()){
			case R.id.item1:
				transaction.replace(R.id.container, new Fragment_1()).commit();
				return true;
			case R.id.item2:
				transaction.replace(R.id.container, new Fragment_2()).commit();
				return true;
			case R.id.item3:
				transaction.replace(R.id.container, new Fragment_3()).commit();
				return true;
			case R.id.action_settings:
				return true;
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void startGame(View view){
//		Intent intent = new Intent(this, MainGameActivity.class);
        Intent intent = new Intent(this, MainGameInterface.class);
		startActivity(intent);
	}
}
