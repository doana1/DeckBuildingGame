package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Card;
import com.doanan.gameCards.Monster;

import java.util.ArrayList;

public class MonsterCreate {
    public ArrayList<Monster> Mansion = new ArrayList<>();
    public Monster currentMonster;

    public MonsterCreate(){
        Mansion.add(monster1);

    }

    public void EXPLORE(){
        draw();

    }

    public void draw(){
        currentMonster = Mansion.remove(Mansion.size()-1);
        Mansion.add(currentMonster);
    }

    public Monster getCurrentMonster(){
        return currentMonster;
    }

    public int getDecoration(){
        return currentMonster.DECORATIONS;
    }

    public int getDamage(){
        return currentMonster.DAMAGE;
    }

    Monster monster1 = new Monster("monster_1",20,10,0,false);

}
