package com.doanan.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.firstgame.R;

public class OpenGLES20Activity extends Activity{
	
	public GLSurfaceView mGLView;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// Keep screen on
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		
		
		// Buttons Page
		FrameLayout frame = (FrameLayout)findViewById(R.id.opengl);
		setContentView(R.layout.opengl);
		
		// Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity.
		
		mGLView = new MyGLSurfaceView(this);
		setContentView(mGLView);
//		frame.addView(mGLView,0);
	}
	
}
