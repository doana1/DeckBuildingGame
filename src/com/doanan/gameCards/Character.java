package com.doanan.gameCards;

public class Character extends Card{
	//Card Types
		String Character, Ammunition, Weapon, Infected, Token, Item;
		
		//Card Attributes
		String Cost, Effect, Gold, Ammo, Damage;
		
		// Character Card Information
		public int HEALTH, DECORATIONS, LEVEL;
		
		public Character(String name, int cost, int health, int decorations, int level){
			super(name, cost);
			//Track Character Health, Ammo, and Decorations
			//Characters don't have cost but required from inheritance
			this.HEALTH = health;
			this.DECORATIONS = decorations;
			this.LEVEL = level;
		}
}
