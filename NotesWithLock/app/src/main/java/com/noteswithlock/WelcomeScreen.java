package com.noteswithlock;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Dhanesh on 7/8/2014.
 */
/*This is first activity
 *In this activity the app plays music for 5 sec and calls LoginCkeck.java class
 */
public class WelcomeScreen extends Activity

{

    MediaPlayer startSong;
    @Override
    protected void onCreate(Bundle temp)
    {
        super.onCreate(temp);
        setContentView(R.layout.welcome_screen);
        startSong= MediaPlayer.create(WelcomeScreen.this,R.raw.beautiful_music_box);
        startSong.start();

        Thread timer=new Thread()
        {
            public void run(){
                try{
                    sleep(5000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent openPic=new Intent("com.noteswithlock.Logincheck");
                    startActivity(openPic);
                }
            }
        };
        timer.start();
    }

/*this method pause the music as soon as this activity paused.*/
    protected void onPause(){
        super.onPause();
        startSong.release();
        finish();
    }
}