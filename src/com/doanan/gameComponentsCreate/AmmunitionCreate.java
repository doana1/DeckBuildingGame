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
	
	// Ammunition x20
	String ammo20Name = "Ammunitionx20";
	int ammo20Cost = 30;
	int ammo20Ammo = 20;
	int ammo20Gold = 20;
	
	// Ammunition x30
	String ammo30Name = "Ammunitionx30";
	int ammo30Cost = 60;
	int ammo30Ammo = 30;
	int ammo30Gold = 30;
	
	public Ammunition ammo10 = new Ammunition(ammo10Name, ammo10Cost, ammo10Ammo, ammo10Gold);
	public Ammunition ammo20 = new Ammunition(ammo20Name, ammo20Cost, ammo20Ammo, ammo20Gold);
	public Ammunition ammo30 = new Ammunition(ammo30Name, ammo30Cost, ammo30Ammo, ammo30Gold);
	
	public AmmunitionCreate(){
		
	}
	
	public Ammunition getAmmo10(){
		return ammo10;
	}

}