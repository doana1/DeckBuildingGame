package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Ammunition;

public class AmmunitionCreate {
	
	
	/*
	 * Ammunition Constructor
	 * Name:
	 * Cost:
	 * Ammo:
	 * Gold:
	 */
	
	// Ammunition x10
	String ammo10Name = "Ammunitionx10";
	int ammo10Cost = 0;
	int ammo10Ammo = 10;
	int ammo10Gold = 10;
    String ammo10FilePath = "king_of_spades2.jpg";
	
	// Ammunition x20
	String ammo20Name = "Ammunitionx20";
	int ammo20Cost = 30;
	int ammo20Ammo = 20;
	int ammo20Gold = 20;
    String ammo20FilePath = "queen_of_clubs2.jpg";
	
	// Ammunition x30
	String ammo30Name = "Ammunitionx30";
	int ammo30Cost = 60;
	int ammo30Ammo = 30;
	int ammo30Gold = 30;
    String ammo30FilePath = "royalty.png";
	
	public Ammunition ammo10 = new Ammunition(ammo10Name, ammo10Cost, ammo10Ammo, 0,0,ammo10Gold, -1, ammo10FilePath);
	public Ammunition ammo20 = new Ammunition(ammo20Name, ammo20Cost, ammo20Ammo, 0,0,ammo20Gold, -1, ammo20FilePath);
	public Ammunition ammo30 = new Ammunition(ammo30Name, ammo30Cost, ammo30Ammo, 0,0,ammo30Gold, -1, ammo30FilePath);
	
	/**
	 * Constructor used to access local variables of the class.
	 * <p>
	 * These variables include.
	 * ammo10, ammo20, ammo30
	 */
	public AmmunitionCreate(){
		
	}
	
	public Ammunition getAmmo10(){
		return ammo10;
	}

}
