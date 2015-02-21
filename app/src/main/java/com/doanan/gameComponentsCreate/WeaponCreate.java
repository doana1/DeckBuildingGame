package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Weapon;

public class WeaponCreate {

    // Ammunition x10
    String ammo10Name = "Ammunitionx10";
    int ammo10Cost = 0;
    int ammo10Ammo = 10;
    int ammo10Gold = 10;

    /*
     * Weapon Constructor
     * Name:
     * Cost:
     * AmmoRequirement:
     * Damage:
     * Effect:
     * CardIndex:
     */
	
	// Weapon Pistol
	String pistolName = "Pistol";
    int pistolCost = 20;
    int pistolAmmoRequirement = 20;
    int pistolDamage = 10;

    // Weapon Knife
    String knifeName = "Knife";
    int knifeCost = 0;
    int knifeAmmoRequirement = 0;
    int knifeDamage = 5;

    // Weapon Burst-Pistol
    String burstPistolName = "Burst Pistol";
    int burstPistolCost = 60;
    int burstPistolAmmoRequirement = 30;
    int burstPistolDamage = 20;

    // Weapon Magnum
    String magnumName = "Magnum";
    int magnumCost = 90;
    int magnumAmmoRequirement = 50;
    int magnumDamage = 50;

	
	public Weapon pistol = new Weapon(pistolName, pistolCost, 0,pistolAmmoRequirement, pistolDamage, false, -1,0);
    public Weapon knife = new Weapon(knifeName, knifeCost, 0,knifeAmmoRequirement, knifeDamage, false, -1,0);
    public Weapon burstPistol = new Weapon(burstPistolName,burstPistolCost, 0, burstPistolAmmoRequirement, burstPistolDamage, false, -1, 0);
    public Weapon magnum = new Weapon(magnumName, magnumCost, 0, magnumAmmoRequirement, magnumDamage, false, -1, 0);
	
	public WeaponCreate(){
		
	}
	
}
