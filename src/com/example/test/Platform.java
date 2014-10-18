package com.example.test;

import android.graphics.Rect;

public abstract class Platform extends Shape{
	
	protected Rect geometry;
	protected int length;
	protected int thick;
	protected float px;
	protected float py;
	
	public Platform(Rect geometry, int color, Rect playground){
		super(color, playground);
		this.geometry = geometry;
		this.length = geometry.right - geometry.left;
		this.thick = geometry.bottom - geometry.top;
		this.px = this.geometry.left + length/2;
		this.py = this.geometry.top + thick/2;
		
	}
}
