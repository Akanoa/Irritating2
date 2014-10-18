package com.example.test;



import android.graphics.Canvas;
import android.graphics.Rect;

public class SlidingBall extends Ball {
	
	protected RotatingPlatform platform;
	protected Vector2d velocity;

	public SlidingBall( Vector2d pos, int color, Rect playground, int radius,
			Platform platform) {
		super(pos, color, playground, radius, platform);
		this.platform = (RotatingPlatform) platform;
		this.velocity = new Vector2d(0,0);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(color);
		canvas.save();
		canvas.rotate(platform.angle, platform.px, platform.py);
		canvas.drawCircle((float)pos.x, (float)pos.y, radius, paint);
		canvas.restore();

	}

	@Override
	void update(int dx) {
		// TODO Auto-generated method stub
		pos.x += -dx;
	}

}
