package com.example.test;

import android.graphics.Canvas;
import android.graphics.Rect;

public class HorizontalPlatform extends Platform {
	

	public HorizontalPlatform(Rect geometry, int color, Rect playground){
		super(geometry, color, playground);
		  
	}

	@Override
	void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(color);
		canvas.drawRect(geometry, paint);
		
	}

	@Override
	void update(int dx) {
		// TODO Auto-generated method stub
		int newX = geometry.left + dx;
		
		if(newX+length > playground.right){
			geometry.left = playground.right - length;
			geometry.right = playground.right;
		}else if(newX <= 0){
			geometry.left = 0;
			geometry.right = length;
		}else{
			geometry.left+=dx;
			geometry.right+=dx;			
		}

	}

}
