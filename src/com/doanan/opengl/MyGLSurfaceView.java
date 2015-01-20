package com.doanan.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView{
	
	public MyGLSurfaceView(Context context){
		super(context);
		
		// Set the Renderer for drawing on the GLSurfaceView
		setRenderer(new MyGLRenderer());
		
		// Render the view only when there is a change in the drawing data
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

}
