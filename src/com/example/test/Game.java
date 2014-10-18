package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
	
	private Timer timer;
	private SensorManager sm;
	public int posX;
	public int posY;
	public List<Shape> drawables;
	
	public Game(Context context, SensorManager sm) {
		super(context);
		this.sm = sm;
		getHolder().addCallback(this);
		timer = new Timer();
		// TODO Auto-generated constructor stub
		drawables = new ArrayList<Shape>();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onDraw(Canvas canvas){
		
		//clear screen
		canvas.drawARGB(255, 0, 0, 0);
		
		for (Shape shape : drawables) {
			shape.draw(canvas);
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Rect screenDimensions = new Rect(0,0,getWidth(), getHeight());
		
		Platform horizontal = new HorizontalPlatform(new Rect(
				screenDimensions.left+100, 
				screenDimensions.top+200, 
				screenDimensions.left+160, 
				screenDimensions.top+210), 
				Color.GREEN, screenDimensions);
		
		RotatingPlatform rotating = new RotatingPlatform(new Rect(
				screenDimensions.left+50, 
				screenDimensions.bottom-100, 
				screenDimensions.right-50, 
				screenDimensions.bottom-80
				), Color.RED, screenDimensions, 0, 25);
		
		float py = rotating.py-rotating.thick/2-16;
		
		Ball sliding = new SlidingBall(new Vector2d(rotating.px,py), Color.BLUE, screenDimensions, 16, rotating);
		
		py = horizontal.py-horizontal.thick/2-16;
		
		Ball bouncing = new BouncingBall(new Vector2d(horizontal.px, py), Color.MAGENTA, screenDimensions, 10, new Vector2d(-10,-10), horizontal);
		
		drawables.add(horizontal);
		drawables.add(rotating);
		drawables.add(sliding);
		drawables.add(bouncing);
		
		timer.schedule(new GameTimerTask(this, getHolder(), sm), 0, 100);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		timer.cancel();
	}

}
