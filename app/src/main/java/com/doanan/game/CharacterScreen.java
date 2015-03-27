package com.doanan.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstgame.R;

/**
 * Created by An Doan on 3/26/2015.
 */
public class CharacterScreen extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.character_screen, container, false);

        TextView tv = (TextView) v.findViewById(R.id.character_name);
    tv.setText(getArguments().getString("msg"));

    return v;
}

    public static CharacterScreen newInstance(String text) {

        CharacterScreen f = new CharacterScreen();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
