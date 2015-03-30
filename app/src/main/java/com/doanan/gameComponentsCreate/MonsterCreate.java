package com.doanan.gameComponentsCreate;

import com.doanan.gameCards.Monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MonsterCreate {
    public ArrayList<Monster> Mansion = new ArrayList<>();
    public ArrayList<Monster> discardedMansion = new ArrayList<>();
    public Monster currentMonster;

    public MonsterCreate(){
        for (int i = 0; i < 3; i++){
            Mansion.add(zombieButcher);
            Mansion.add(licker);
            Mansion.add(dr_salvador);
            Mansion.add(gatling_gun_majini);
            Mansion.add(cerberus);
            Mansion.add(bui_kichwa);
            Mansion.add(majini);
        }
        for (int i=0; i < 2; i++){
            Mansion.add(zombie_male);
            Mansion.add(zombie_female);
            Mansion.add(mimicry_marcus);
            Mansion.add(hunter);
        }
        Mansion.add(uroboros);
        Mansion.add(el_gigante);
        Mansion.add(nemesis);
        Mansion.add(executioner);
        shuffle();
    }

    public void shuffle(){
        long seed = System.nanoTime();
        Collections.shuffle(Mansion, new Random(seed));
    }


    public void EXPLORE(){
        draw();

    }

    public void draw(){
        if (!Mansion.isEmpty()){
            currentMonster = Mansion.remove(Mansion.size()-1);
            discardedMansion.add(currentMonster);
        }
        else{
            Mansion.addAll(discardedMansion);
            discardedMansion.clear();
        }
    }

    public void returnToMansion(){
        Mansion.add(currentMonster);
        discardedMansion.remove(currentMonster);
        shuffle();
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

    public int getHealth(){
        return currentMonster.HEALTH;
    }

    public String getName(){
        return currentMonster.NAME;
    }

    Monster zombieButcher = new Monster("Zombie Butcher",15,10,1,false);

    Monster licker = new Monster("Licker",40,30,3,false);

    Monster dr_salvador = new Monster("Dr. Salvador",20,15,2,false);

    Monster gatling_gun_majini = new Monster("Gatling Gun Majini",40,25,4,true);

    Monster uroboros = new Monster("Uroboros Aheri",90,70,8,true);

    Monster cerberus = new Monster("Cerberus",25,10,2,false);

    Monster zombie_male = new Monster("Zombie (Male)",20,20,1,false);

    Monster zombie_female = new Monster("Zombie (Female)",15,10,1,true);

    Monster bui_kichwa = new Monster("Bui Kichwa",10,10,1,false);

    Monster majini = new Monster("Majini",15,10,1,false);

    Monster el_gigante = new Monster("El Gigante",40,40,4,false);

    Monster mimicry_marcus = new Monster("Mimicry Marcus",30,20,2,false);

    Monster nemesis = new Monster("Nemesis T-Type",60,40,5,true);

    Monster executioner = new Monster("Executioner",30,25,3,false);

    Monster hunter = new Monster("Hunter",40,30,4,true);

}
