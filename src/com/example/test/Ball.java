package com.example.test;



import android.graphics.Rect;

public abstract class Ball extends Shape {
	
	protected Vector2d pos;
	protected int radius;
	protected Platform platform;

	public Ball(Vector2d pos, int color, Rect playground, int radius, Platform platform) {
		super(color, playground);
		// TODO Auto-generated constructor stub
		this.pos = pos;
		this.radius = radius;
		this.platform = platform;
	}
}
