package com.example.test;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class Shape {
	protected int color;
	protected Paint paint;
	protected Rect playground;
	
	public Shape(int color, Rect playground){
		paint = new Paint();
		this.color = color;
		this.playground = playground;
	}
	
	abstract void draw(Canvas canvas);
	
	abstract void update(int dx);
}
