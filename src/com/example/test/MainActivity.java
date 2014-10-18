package com.example.test;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;


public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);        
        setContentView(new Game(this, sm));
    }

}