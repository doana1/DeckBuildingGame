package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Action;

public class ActionCreate {

    /**
     * Constructor
     * Name
     * Cost
     * Ammo Requirement
     * Damage
     * CardIndex
     * Ammo
     * Action
     * Gold
     */
	
	/*
	 * Deadly Aim
	 * All your Weapons get +10 damage this turn.
	 */
	String deadlyAimName = "Deadly Aim";
	int deadlyAimCost = 50;
    int deadlyAimAmmo = 20;

    /*
     * Reload
     * Move 1 Weapon from your Discard Pile to your Hand.
     */
    String reloadName = "Reload";
    int reloadCost = 50;
    int reloadAmmo = 20;
    int reloadActions = 2;

    /*
     * Ominous Battle
     * Trash 1 card from your Hand.
     */
    String ominousBattleName = "Ominous Battle";
    int ominousBattleCost = 60;
    int ominousBattleGold = 10;
    int ominousBattleCards = 3;

    /*
     * Mansion Foyer
     */
    String mansionFoyerName = "Mansion Foyer";
    int mansionFoyerCost = 30;
    int mansionFoyerCards = 2;

    /*
     * Struggle for Survival
     * You can use this card from your Hand to lower the Damage of 1 Weapon being used
     * costing 40 Gold or less to 0.
     */
    String struggleForSurvivalName = "Struggle for Survival";
    int struggleForSurvivalCost = 30;
    int struggleForSurvivalActions = 1;
    int struggleForSurvivalExplores = 1;

    /*
     * The Merchant
     */
    String merchantName = "The Merchant";
    int merchantCost = 50;
    int merchantCards = 1;
    int merchantGold = 20;
    int merchantBuys = 1;

    /*
     * Umbrella Corporation
     * Move 1 card from your Hand to the top of your Inventory
     */
    String umbrellaName = "Umbrella Corporation";
    int umbrellaCost = 50;
    int umbrellaCards = 2;
    int umbrellaActions = 1;


    //public Action(String name, int cost, int damage, int ammo,int gold,int extraAction,int extraBuys, int extraExplores,int extraCards) {
	
	public Action deadlyAim = new Action(deadlyAimName,deadlyAimCost,0,deadlyAimAmmo,0,0,0,0,0);
    public Action reload = new Action(reloadName,reloadCost,0,reloadAmmo,0,reloadActions,0,0,0);
    public Action ominousBattle = new Action(ominousBattleName,ominousBattleCost,0,0,ominousBattleGold,0,0,0,ominousBattleCards);
    public Action mansionFoyer = new Action(mansionFoyerName,mansionFoyerCost,0,0,0,0,0,0,mansionFoyerCards);
    public Action struggleForSurvival = new Action(struggleForSurvivalName,struggleForSurvivalCost,0,0,0,struggleForSurvivalActions,0,struggleForSurvivalExplores,0);
    public Action theMerchant = new Action(merchantName,merchantCost,0,0,merchantGold,0,merchantBuys,0,merchantCards);
    public Action umbrellaCorporation = new Action(umbrellaName,umbrellaCost,0,0,0,umbrellaActions,0,0,umbrellaCards);
	
	public ActionCreate(){
		
	}
}
