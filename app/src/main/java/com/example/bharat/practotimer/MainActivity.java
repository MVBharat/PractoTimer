  package com.example.bharat.practotimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

  public class MainActivity extends AppCompatActivity {
      SeekBar timerSeekBar;
      public void controlTimer(View view){
          new CountDownTimer(timerSeekBar.getProgress() * 1000,1000) {
              @Override
              public void onTick(long millisUntilFinished) {
                        
              }

              @Override
              public void onFinish() {

              }
          };
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar)findViewById(R.id.timerSeekBar);
        final TextView timerTextView = (TextView)findViewById(R.id.timerTextView);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = (int)progress / 60 ;
                int seconds = progress - minutes * 60;

                String secondString=  Integer.toString(seconds);
                if (secondString == "0"){
                    secondString = "00";
                }
                timerTextView.setText(Integer.toString(minutes) + ":" + secondString);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
