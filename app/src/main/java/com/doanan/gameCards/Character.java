package com.doanan.gameCards;

public class Character extends Card{
	//Card Types
		String Character, Ammunition, Weapon, Infected, Token, Item;
		
		//Card Attributes
		String Effect, Gold, Ammo, Damage;
		
		// Character Card Information
		public int HEALTH, DECORATIONS, LEVEL;
		public int AMMO;
//		public String NAME;
		
		public Character(String name, int cost, int health, int ammo, int decorations, int level, int cardIndex){
			super(name, cost, ammo,cardIndex);
			
			//Track Character Health, Ammo, and Decorations
			//Characters don't have cost but required from inheritance
//			this.NAME = name;
//			this.COST = cost;
			this.HEALTH = health;
			this.DECORATIONS = decorations;
			this.LEVEL = level;
		}

		public void getCurrentTurn() {
			// TODO Auto-generated method stub
			
		}
}