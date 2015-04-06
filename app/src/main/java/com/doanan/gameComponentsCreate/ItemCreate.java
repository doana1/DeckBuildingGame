package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Item;

public class ItemCreate {
	

    // Herb
    String herbName = "Herb";
    int herbCost = 20;

    // First Aid Spray
    String firstAidName = "First Aid Spray";
    int firstAidCost = 60;

    public Item herb = new Item(herbName,herbCost,0,0,0,-1,0,"herb.jpg");
    public Item firstAid = new Item(firstAidName,firstAidCost,0,0,0,-1,0,"first_aid.jpg");

	
	public ItemCreate(){
		
	}
}
