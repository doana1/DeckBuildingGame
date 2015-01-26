package com.doanan.gameComponents;

public interface Turn{
	
	public enum Phase{
		ACTION,
		BUY,
		EXPLORE
	}
	
	public void getCurrentTurn();
	
}
