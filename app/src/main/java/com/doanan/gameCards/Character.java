package com.doanan.gameCards;

public class Character{
    int HEALTH, DECORATIONS, LEVEL;
    String NAME, FILEPATH;

    /**
     * Creates a character to play the game with.
     *
     * @param name Name of the character
     * @param health Amount of health the character has.
     * @param decorations Amount of decorations the character has.
     * @param level The current level of the character.
     * @param filePath Filepath to image file of the character.
     */
	public Character(String name, int health, int decorations, int level,String filePath){
        this.NAME = name;
		this.HEALTH = health;
		this.DECORATIONS = decorations;
		this.LEVEL = level;
        this.FILEPATH = filePath;
	}

    public void levelUnlocked1(String name){
        switch (name){
            case "Chris Redfield":
                break;
            case "Jill Valentine":
                break;
        }
    }

    public void levelUnlocked2(String name){
        switch (name){
            case "Chris Redfield":
                break;
            case "Jill Valentine":
                break;
        }
    }

    public String getNAME(){
        return NAME;
    }

    public int getHEALTH(){
        return HEALTH;
    }
    public int getDECORATIONS(){
        return DECORATIONS;
    }


}
