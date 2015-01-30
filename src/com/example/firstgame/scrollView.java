package com.example.firstgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class scrollView extends Activity{
	Button addinHorizontalScrollView, addinScrollView;
	 LinearLayout inHorizontalScrollView, inScrollView;
	  
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.scrollview);
	          
	        inHorizontalScrollView = (LinearLayout)findViewById(R.id.inhorizontalscrollview);
	        inScrollView = (LinearLayout)findViewById(R.id.inscrollview);
	          
	        addinHorizontalScrollView = (Button)findViewById(R.id.addinhorizontalscrollview);
	        addinHorizontalScrollView.setOnClickListener(new OnClickListener(){
	  
	   public void onClick(View arg0) {
	    addImageView(inHorizontalScrollView);
	   }});
	          
	        addinScrollView = (Button)findViewById(R.id.addinscrollview);
	        addinScrollView.setOnClickListener(new OnClickListener(){
	  
	   public void onClick(View arg0) {
	    addImageView(inScrollView);
	   }});
	          
	    }
	      
	    private void addImageView(LinearLayout layout){
	     ImageView imageView = new ImageView(this);
	     imageView.setImageResource(R.drawable.ic_launcher);
	     layout.addView(imageView);
	     }
}
