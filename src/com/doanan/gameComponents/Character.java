package com.doanan.gameComponents;

public class Character extends Card{
	//Card Types
		String Character, Ammunition, Weapon, Infected, Token, Item;
		
		//Card Attributes
		String Cost, Effect, Gold, Ammo, Damage;
		
		// Character Card Information
		int Health, Decorations;
		
		public Character(String name, int health, int decorations){
			super(name);
			//Track Character Health, Ammo, and Decorations
			this.Health = health;
			this.Decorations = decorations;
		}
}
