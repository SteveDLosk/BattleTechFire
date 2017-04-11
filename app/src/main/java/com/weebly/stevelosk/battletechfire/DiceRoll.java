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
                playSound();
                rollDice();
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

        // Create MediaPlayer and context objects
        Context ctx = getApplicationContext();
        MediaPlayer mPlayer;

        // random int to select sound, four options
        int choice = r.nextInt(4);

        // assign sound to MediaPlayer
        if (choice == 0)
            mPlayer = MediaPlayer.create(ctx, R.raw.roll0);
        else if (choice == 1)
            mPlayer = MediaPlayer.create(ctx, R.raw.roll1);
        else if (choice == 2)
            mPlayer = MediaPlayer.create(ctx, R.raw.roll2);
        else
            mPlayer = MediaPlayer.create(ctx, R.raw.roll3);

        // play sound
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.start();
    }
}
