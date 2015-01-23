package com.doanan.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

public class OpenGLES20Activity extends Activity{
	
	private GLSurfaceView mGLView;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// Keep screen on
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		// TODO Buttons Page
//		FrameLayout frame = (FrameLayout)findViewById(R.id.opengl);
//		setContentView(R.layout.opengl);
		
		// Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity.
		
		mGLView = new MyGLSurfaceView(this);
		setContentView(mGLView);
//		frame.addView(mGLView,0);
	}
	
	@Override
    protected void onPause() {
        super.onPause();
        // The following call pauses the rendering thread.
        // If your OpenGL application is memory intensive,
        // you should consider de-allocating objects that
        // consume significant memory here.
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The following call resumes a paused rendering thread.
        // If you de-allocated graphic objects for onPause()
        // this is a good place to re-allocate them.
        mGLView.onResume();
    }
	
}