package com.doanan.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.example.firstgame.R;

/**
 * Created by An Doan on 3/25/2015.
 */
public class MainGameInterface extends android.support.v4.app.FragmentActivity {

    static final int NUM_ITEMS = 2;

    MyAdapter mAdapter;

    ViewPager mPager;

    String CharacterFragment = "";

    String characterChoice = "jill";
//    String characterChoice = intent.getStringExtra("CharacterChoice");

    public String getCharacterChoice(){
        return characterChoice;
    }

    public void setCharacterFragment(String t){
        CharacterFragment = t;
    }

    public String getCharacterFragment(){
        return CharacterFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.fragment_pager);

        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        characterChoice = getIntent().getStringExtra("CharacterChoice");
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){

                case 0: return CharacterScreen.newInstance("CharacterScreen");
                case 1: return MainGameActivity.newInstance("Main Game Activity");

                default: return CharacterScreen.newInstance("CharacterScreen, Default");
            }
        }

    }
}
