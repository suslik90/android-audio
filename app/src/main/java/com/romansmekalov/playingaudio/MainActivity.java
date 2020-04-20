package com.romansmekalov.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean playing = false;
    SeekBar volumeSeekBar;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress changed: ",""+progress);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
