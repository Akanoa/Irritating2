package com.example.test;

import android.content.Intent;
import android.util.Log;
import android.widget.VideoView;

public class ThreadVideo extends Thread {
	
	GameOver gameover;
	VideoView videoview;
	
	public ThreadVideo(GameOver gameover, VideoView videoview){
		this.gameover = gameover;
		this.videoview = videoview;
	}
	
    public void run() {
        try{

        	sleep(videoview.getDuration());
        	Log.d("yolo", "wait");
        } catch (Exception e) {

        }
        gameover.launch_new_intent();
    }
}
