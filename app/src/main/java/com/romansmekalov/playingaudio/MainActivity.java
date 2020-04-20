package com.romansmekalov.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean playing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPlayer();
    }

    private void initPlayer(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bird_in_rain);
    }

    public void toogle(View view) {
        Button toogleBtn = findViewById(R.id.toogleButton);
        if(playing){
            mediaPlayer.stop();
            toogleBtn.setText("Play");
            playing = false;
            initPlayer();
        }else{
            mediaPlayer.start();
            toogleBtn.setText("Pause");
            playing = true;
        }
    }
}
