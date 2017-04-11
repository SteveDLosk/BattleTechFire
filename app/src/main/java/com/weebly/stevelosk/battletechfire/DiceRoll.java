package com.weebly.stevelosk.battletechfire;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.Random;

public class DiceRoll extends AppCompatActivity {

    Random r = new Random();
    ImageButton mButton = null;
    TextView rView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        rView = (TextView) findViewById(R.id.rollResult);
        mButton = (ImageButton) findViewById(R.id.diceImageView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
                playSound();
            }
        });
    }

    /** Called when the user touches the button */
    public void rollDice() {
        // roll the dice
        int die1 = r.nextInt(6) + 1;
        int die2 = r.nextInt(6) + 1;
        int result = die1 + die2;

        // output the roll to the screen
        String outputText = String.valueOf(result);
        rView.setText(outputText);
    }

    private void playSound() {
        Context ctx = getApplicationContext();
        MediaPlayer mPlayer = MediaPlayer.create(ctx, R.raw.roll);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.start();
    }
}
