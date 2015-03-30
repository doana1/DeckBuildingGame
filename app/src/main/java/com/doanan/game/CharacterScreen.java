package com.doanan.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.doanan.gameComponentsCreate.CharacterCreate;
import com.doanan.gameCards.Character;
import com.example.firstgame.R;

/**
 * Created by An Doan on 3/26/2015.
 */
public class CharacterScreen extends Fragment {

    View characterView;
    TextView characterName, characterHealth, characterDecorations;
    CharacterCreate characters = new CharacterCreate();
    Character character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        characterView = inflater.inflate(R.layout.character_screen, container, false);


        selectCharacter();
        initCharacterHUD();
//        setCharacterHUD(100,0);

        String myTag = getTag();
        ((MainGameInterface)getActivity()).setCharacterFragment(myTag);

        return characterView;
    }

    public static CharacterScreen newInstance(String text) {

        CharacterScreen f = new CharacterScreen();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public void selectCharacter(){
        String characterChoice = ((MainGameInterface)getActivity()).getCharacterChoice();
        switch (characterChoice){
            case "jill":
                character = characters.Jill;
                break;
            case "chris":
                character = characters.Chris;
                break;
        }
    }

    public void setCharacterHUD(int health, int decorations){
        characterHealth.setText("Health: " + Integer.toString(health));
        characterDecorations.setText("Decorations: " + Integer.toString(decorations));
    }

    public void initCharacterHUD(){
        characterName = (TextView) characterView.findViewById(R.id.character_name);
        characterName.setText(getArguments().getString(character.getNAME()));

        characterHealth = (TextView) characterView.findViewById(R.id.character_health);
        characterHealth.setText(getArguments().getString("Health: " + character.getHEALTH()));

        characterDecorations = (TextView) characterView.findViewById(R.id.character_decorations);
        characterDecorations.setText(getArguments().getString("Decorations: " + character.getDECORATIONS()));

    }
}
