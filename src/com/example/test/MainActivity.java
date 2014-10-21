package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class MainActivity extends Activity implements OnTouchListener{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//    	SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);        
//        setContentView(new Game(this, sm));
        
        
        MediaPlayer ourSound = MediaPlayer.create(this, R.raw.title);
        ourSound.setLooping(true);
        ourSound.start();
        
        View myLayout = (View) findViewById(R.layout.activity_main);
        myLayout.setOnTouchListener(this);
        
        setContentView(R.layout.activity_main);
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
		return false;
	}
    
    

}
