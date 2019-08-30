package com.example.mainproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Typeface typeface;
    ImageButton fast_backwardButton,fast_forwardButton,previousButton,pauseButton,playButton,nextButton;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fast_backwardButton = (ImageButton) findViewById(R.id.imageButtonUpper1Id) ;
        fast_forwardButton = (ImageButton) findViewById(R.id.imageButtonUpper2Id) ;
        previousButton = (ImageButton) findViewById(R.id.imageButtonLower1Id);
        pauseButton = (ImageButton) findViewById(R.id.imageButtonLower2Id);
        playButton = (ImageButton) findViewById(R.id.imageButtonLower3Id);
        nextButton = (ImageButton) findViewById(R.id.imageButtonLower4Id);

        fast_backwardButton.setOnClickListener(this);
        fast_forwardButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this,R.raw.ore_manwa_re);

        typeface = Typeface.createFromAsset(getAssets(),"kaushan_script/kaushan.otf");
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Toast.makeText(MainActivity.this,"Music app is closed successfully...",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.imageButtonUpper1Id){
           if(mediaPlayer != null){
               Toast.makeText(MainActivity.this,"Fast_Backwarding",Toast.LENGTH_SHORT).show();
           }
       }
       if(v.getId()==R.id.imageButtonUpper2Id){
           if(mediaPlayer != null){
               Toast.makeText(MainActivity.this,"Fast_Forwarding",Toast.LENGTH_SHORT).show();
           }
       }
       if(v.getId()==R.id.imageButtonLower1Id){
            if(mediaPlayer != null){
                Toast.makeText(MainActivity.this,"Previously Played",Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==R.id.imageButtonLower2Id){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this,"Paused",Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==R.id.imageButtonLower3Id){
            if(mediaPlayer != null){
                mediaPlayer.start();
                Toast.makeText(MainActivity.this,"Playing",Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()==R.id.imageButtonLower4Id){
            if(mediaPlayer != null){
                Toast.makeText(MainActivity.this,"Next",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
