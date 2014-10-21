package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
//import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Video.VideoColumns;
import android.widget.MediaController;
import android.widget.VideoView;

public class GameOver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gmvr);
		
	}
	
	@Override
	public void onStart(){
		super.onStart();
		
		VideoView videoManager = (VideoView) findViewById(R.id.videoManager);
		
		Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.end);
		
		videoManager.setVideoURI(uri);
		MediaController mediaController = new MediaController(this);
		
		videoManager.setMediaController(mediaController);
		
		new ThreadVideo(this, videoManager).start();
		
		videoManager.start();
	}
	
	public void launch_new_intent()
	{
      Intent intent = new Intent(this, GameActivity.class);
      startActivity(intent);
      finish();
	}

}
