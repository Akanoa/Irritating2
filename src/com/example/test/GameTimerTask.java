package com.example.test;

import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;

public class GameTimerTask extends TimerTask implements SensorEventListener{
	private SurfaceHolder holder;
	private Game game;
	
	private int dx = 0;
	
	public GameTimerTask(Game game, SurfaceHolder holder, SensorManager sm)
	{
		this.holder = holder;
		this.game = game;
		Sensor accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@SuppressLint("WrongCall")
	@Override
	public void run() {
		
		//update elements
		for (Shape shape : game.drawables) {
			shape.update(dx);
		}
		dx=0;
		
		//redraw
		Canvas c = null;
		try{
			c = holder.lockCanvas(null);
			synchronized (holder) {
				game.onDraw(c);
			}
		}finally{
			if(c!=null){
				holder.unlockCanvasAndPost(c);
			}
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		int gain = 3;
		dx=(int) -event.values[0]*gain;
	}
}
