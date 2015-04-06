package com.doanan.gameCards;

public class Item extends Card{
	
	/*
	 * Item Attributes
	 * Card Type
	 * Cost to Buy
	 * Item Name
	 * Effect
	 */

	public Item(String name, int cost, int ammo,int ammorequirement,int damage,int cardIndex, int gold, String filePath) {
		super(name, cost,ammo,ammorequirement,damage, cardIndex, gold, filePath);


	}

}
