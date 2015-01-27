package com.doanan.gamePlayer;

public interface Turn{
	
	public enum Phase{
		ACTION,
		BUY,
		EXPLORE
	}
	
	public void getCurrentTurn();
	
}
