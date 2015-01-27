package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Character;

public class CharacterCreate{
	/*
	 * This Class is used to create all characters in the game.
	 * Then this class's constructor will be created in the main game.
	 */
	
	/*
	 * Character Constructor
	 * Name:
	 * Cost:
	 * Health:
	 * Decorations:
	 * Level:
	 */
	String rebeccaName = "Rebecca";
	int rebeccaCost = 0;
	int rebeccaHealth = 120;
	int rebeccaDecorations = 0;
	int rebeccaLevel = 0;
	
	public Character Rebecca = new Character(rebeccaName, rebeccaCost,rebeccaHealth,rebeccaDecorations,rebeccaLevel);

	public CharacterCreate(){
		//Constructor used simply to create Characters
	}
}
