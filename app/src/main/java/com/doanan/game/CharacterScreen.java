package com.doanan.game;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doanan.gameCards.Character;
import com.doanan.gameComponentsCreate.CharacterCreate;
import com.example.firstgame.R;

import java.io.IOException;
import java.io.InputStream;

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
        ImageView characterImage = (ImageView) characterView.findViewById(R.id.characterImage);
        switch (characterChoice){
            case "jill":
                character = characters.Jill;
                imageAssets(characterImage,characterChoice);
                break;
            case "chris":
                character = characters.Chris;
                imageAssets(characterImage,characterChoice);
                break;
        }
    }

    public void imageAssets(ImageView image,String character){
        AssetManager assetManager = getActivity().getAssets();
        InputStream istr;
        try{
            istr = assetManager.open("imgs/cards/"+ character+".jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(istr);
            image.setImageBitmap(Bitmap.createScaledBitmap(bitmap,150,150,false));
            istr.close();
        }catch(IOException e){
            e.printStackTrace();
            image.setImageResource(R.drawable.test);
        }
    }

    public Character getCurrentCharacter(){
        return character;
    }

    public void setCharacterHUD(int health, int decorations){
        characterHealth.setText("Health: " + Integer.toString(health));
        characterDecorations.setText("Decorations: " + Integer.toString(decorations));
    }

    public void initCharacterHUD(){
        characterName = (TextView) characterView.findViewById(R.id.character_name);
        characterName.setText((character.getNAME()));

        characterHealth = (TextView) characterView.findViewById(R.id.character_health);
        characterHealth.setText(("Health: " + character.getHEALTH()));

        characterDecorations = (TextView) characterView.findViewById(R.id.character_decorations);
        characterDecorations.setText(("Decorations: " + character.getDECORATIONS()));
    }
}
