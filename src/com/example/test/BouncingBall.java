package com.example.test;


import android.graphics.Canvas;
import android.graphics.Rect;

public class BouncingBall extends Ball {
	
	protected Vector2d velocity; 

	public BouncingBall(Vector2d pos, int color, Rect playground, int radius, Vector2d velocity, Platform platform) {
		super(pos, color, playground, radius, platform);
		// TODO Auto-generated constructor stub
		this.velocity = velocity;
	}

	@Override
	void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(color);
		canvas.drawCircle((float)pos.x, (float)pos.y, radius, paint);
	}

	@Override
	void update(int dx) {
		// TODO Auto-generated method stub
		int newX = (int) (pos.x + velocity.x);
		int newY = (int) (pos.y + velocity.y);
		
		if(newX-radius <0){
			velocity.x = -velocity.x;
		}else if(newX + radius > playground.right){
			velocity.x = -velocity.x;
		}
		
		
		if(newY-radius < 0){
			velocity.y =-velocity.y;
		}else if(newY+radius > platform.geometry.bottom-platform.thick){
			if(newX > platform.geometry.left && newX < platform.geometry.right){
				velocity.y = -velocity.y;
			}
		}
		
		pos.x += velocity.x;
		pos.y += velocity.y;
		
	}

}
