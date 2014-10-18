package com.example.test;

import android.graphics.Canvas;
import android.graphics.Rect;

public class RotatingPlatform extends Platform {
	
	protected float angle;
	protected float maxAngle;
	
	public RotatingPlatform(Rect geometry, int color, Rect playground, float angle, float maxAngle) {
		super(geometry, color, playground);
		this.maxAngle = maxAngle;
		// TODO Auto-generated constructor stub

	}

	@Override
	void draw(Canvas canvas) {
		// TODO Auto-generated method stub
				
		paint.setColor(color);
		
		canvas.save();
		canvas.rotate(angle, px, py);
		canvas.drawRect(geometry, paint);
		canvas.restore();

	}

	@Override
	void update(int dx) {
		// TODO Auto-generated method stub
		float newAngle = (float) (angle - dx*0.5);
		
		if(newAngle > maxAngle)
		{
			angle = maxAngle;
		}else if(newAngle < -maxAngle){
			angle = -maxAngle;
		}else{
			angle -= dx*0.5;
		}
	}

}
