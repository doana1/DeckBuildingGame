package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Weapon;

public class WeaponCreate {
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
    String pistolFilePath = "pistol.jpg";

    // Weapon Knife
    String knifeName = "Knife";
    int knifeCost = 0;
    int knifeAmmoRequirement = 0;
    int knifeDamage = 5;
    String knifeFilePath = "knife.jpg";

    // Weapon Burst-Pistol
    String burstPistolName = "Burst Pistol";
    int burstPistolCost = 60;
    int burstPistolAmmoRequirement = 30;
    int burstPistolDamage = 20;
    String burstPistolFilePath = "burst_pistol.jpg";

    // Weapon Magnum
    String magnumName = "Magnum";
    int magnumCost = 90;
    int magnumAmmoRequirement = 50;
    int magnumDamage = 50;
    String magnumFilePath = "six_shooter.jpg";

    // Machine Gun
    String mgName = "Machine Gun";
    int mgCost = 30;
    int mgAmmoRequirement = 40;
    int mgDamage = 20;
    String mgFilePath = "machine_gun.jpg";


    // Shotgun
    String shotgunName = "Shotgun";
    int shotgunCost = 40;
    int shotgunAmmoRequirement = 40;
    int shotgunDamage = 25;
    String shotgunFilePath = "shotgun.jpg";
	
	public Weapon pistol = new Weapon(pistolName, pistolCost, 0,pistolAmmoRequirement, pistolDamage, false, -1,0,pistolFilePath);
    public Weapon knife = new Weapon(knifeName, knifeCost, 0,knifeAmmoRequirement, knifeDamage, false, -1,0,knifeFilePath);
    public Weapon burstPistol = new Weapon(burstPistolName,burstPistolCost, 0, burstPistolAmmoRequirement, burstPistolDamage, false, -1, 0,burstPistolFilePath);
    public Weapon magnum = new Weapon(magnumName, magnumCost, 0, magnumAmmoRequirement, magnumDamage, false, -1, 0, magnumFilePath);
    public Weapon machineGun = new Weapon(mgName,mgCost,0,mgAmmoRequirement, mgDamage, false, -1, 0, mgFilePath);
    public Weapon shotgun = new Weapon(shotgunName,shotgunCost,0,shotgunAmmoRequirement,shotgunDamage,false,-1,0,shotgunFilePath);
	
	public WeaponCreate(){
		
	}
	
}
